import java.awt.*;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Player {
    public static Box box;
    public static Box old;
    private int vel1;

    public int getVel1() {
        return vel1;
    }

    public void setVel1(int vel1) {
        this.vel1 = vel1;
    }


    public Player(){
        box =new Box(15,29);
        vel1=0;
    }
    public void drawPlayer(Graphics g){
            g.setColor(Color.green);
            g.fillRect(box.x*box.BOX_SIZE,box.y*box.BOX_SIZE,
                    box.BOX_SIZE,box.BOX_SIZE);

    }

    public  void tick(){
        int position = box.x;
        old=box;
        box = new Box(position + vel1 ,30);
        vel1=0;
    }

}
