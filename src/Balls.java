import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgipavlov on 16.12.15.
 */
public class Balls {
    public static final int RADIUS = 1;
    public static List<Ball> balls;

    public Balls(){
        balls = new ArrayList<>();
        Ball ball = new Ball();
        balls.add(ball);
    }

    public void drawBalls(Graphics g){
        for (int i = 0; i <balls.size() ; i++) {
            if(balls.get(i) != null){
                balls.get(i).drawBall(g);
            }
        }
    }

    public void tick(){
        int count;
        Ball temp;
        int x,y;
        for (int i = 0; i <balls.size() ; i++) {
            if(balls.get(i) != null){
                balls.get(i).tick();
            }
            if(balls.get(i).makeNew){
                balls.get(i).makeNew=false;
                count = balls.get(i).returnSize();
                if(count>1){
                    x=balls.get(i).getX();
                    y=balls.get(i).getY();
                    for (int j = 0; j <2 ; j++) {
                        temp = new Ball(x,y,count);
                        balls.add(temp);
                        x+=count;
                    }
                }
                for (int j = i; j <balls.size()-1 ; j++) {
                    balls.set(j,balls.get(i+1));
                }
                //balls.set(i,null);

            }

        }
    }

}
