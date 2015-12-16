import java.awt.*;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Game extends Canvas implements Runnable{
    private Thread runThread;
    private Graphics globalGraphics;
    static boolean gameRunning = false;
    public  static final int ROWS = 30;
    public  static final int COLS = 30;
    public  static final int SIZE = 20;
    public  static final int WIDTH = COLS*SIZE;
    public  static final int HEIGHT = ROWS*SIZE;
    public static Player player;
    public static Shell shell;
    public static Ball ball;
    public static Balls balls;

    public void paint(Graphics g){
        globalGraphics=g.create();
        if(runThread == null){
            runThread = new Thread(this);
            runThread.start();
            gameRunning=true;
        }
    }

    public Game(){
       player = new Player();
        shell =new Shell();
        ball  = new Ball();
        balls = new Balls();

    }

    public void render(Graphics g){
        g.clearRect(0,0,WIDTH*2,HEIGHT*2);
        player.drawPlayer(g);
        shell.drawShell(g);
        //ball.drawBall(g);
        balls.drawBalls(g);
    }

    @Override
    public void run() {
        while (gameRunning){
            player.tick();
            if(shell.startShell) {
                shell.tick();
            }
            //ball.tick();
            balls.tick();
            render(globalGraphics);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println("job!");
        }

    }
}
