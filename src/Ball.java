import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Ball {
    public static List<Box> body;
    public static List<Ball> balls;
    public static List<Box> temp3;
    public static boolean reverse1=false;
    public static boolean reverse2=false;


    public Ball() {
        body =new LinkedList<>();
        Collections.addAll(body,
                new Box(13, 15),
                new Box(13, 16),
                new Box(12, 15),
                new Box(12, 16)
        );
    }

    public void drawBall(Graphics g){
        int count = (int)Math.sqrt(body.size());
        for (Box box: body){
            g.setColor(Color.red);
            g.fillOval(box.x * box.BOX_SIZE, box.y * box.BOX_SIZE,
                    box.BOX_SIZE, box.BOX_SIZE);
        }
    }

    public  void tick(){
        int count = -(int)Math.sqrt(body.size());
        int ycount =(int)Math.sqrt(body.size());
        if(reverse1){
            count  = -count;
        }
        if(reverse2){
            ycount=-ycount;
        }
        Box temp;

        for (int i = 0; i < body.size(); i++) {
                  temp = body.get(i);
                  if (temp.x + count > 30 || temp.x + count <0  ){
                      reverse1 = !reverse1;
                      System.out.println(reverse1);
                      body = temp3;
                      System.out.println(" 1 x= " + temp.x + "y= " + temp.y);
                      return;
                  }
                  if(temp.y + ycount > 30 || temp.y + ycount < 0){
                      reverse2 = !reverse2;
                      System.out.println(reverse2);
                      body = temp3;
                      System.out.println(" 2 x= " + temp.x + "y= " + temp.y);
                      return;
                  }
                  temp.x = temp.x + count;
                  temp.y = temp.y + ycount;
                      body.set(i, temp);

        }
        //System.out.println("I am here");
              temp3 = body;




    }
}
