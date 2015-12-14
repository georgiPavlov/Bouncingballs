import java.awt.*;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Shell {
    public static Box shell;
    boolean startShell = false;
    private int vel2;

    public int getVel2() {
        return vel2;
    }

    public void setVel2(int vel2) {
        this.vel2 = vel2;
    }

     public Shell(){
        shell = new Box(15,28);
        vel2=-1;
    }

    public void drawShell(Graphics g){
        if(startShell) {
            g.setColor(Color.gray);
            g.fillRect(shell.BOX_SIZE * shell.x, shell.y * shell.BOX_SIZE,
                    shell.BOX_SIZE, shell.BOX_SIZE);
        }
    }

    public  void tick(){
        int position2 = shell.y;
        if(position2 <0 ){
            startShell=false;
            shell = new Box(15,28);
        }
        if(startShell){
            shell = new Box(Player.box.x,position2 + vel2 );
        }
    }
}
