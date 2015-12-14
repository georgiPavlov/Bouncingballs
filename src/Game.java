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

    }

    public void render(Graphics g){
        g.clearRect(player.old.x*player.old.BOX_SIZE,
                player.old.y*player.old.BOX_SIZE,
                player.old.BOX_SIZE,player.old.BOX_SIZE);
        g.clearRect(0,0,WIDTH,HEIGHT);
        player.drawPlayer(g);
        shell.drawShell(g);
        ball.drawBall(g);
    }

    @Override
    public void run() {
        while (gameRunning){
            player.tick();
            if(shell.startShell) {
                shell.tick();
            }
            ball.tick();
            render(globalGraphics);
            try {
                Thread.sleep(175);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("job!");
        }

    }
}
