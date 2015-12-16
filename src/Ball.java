import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Ball {
    public List<Box> body;
    public List<Box> temp3;
    public boolean reverse1 = false;
    public boolean reverse2 = false;
    public boolean makeNew = false;
    public static int countNewBalls=0;
    int count;
    int ycount;

    public Ball() {
        makeBall();
    }

    public Ball(int x, int y, int countMake) {
        List<Box> newBody = new ArrayList<>();
        for (int i = 0; i < countMake / 2; i++) {
            for (int j = 0; j < countMake / 2; j++) {
                newBody.add(new Box(x + j, y + i));
            }
        }
        countNewBalls++;
        body = newBody;
        count = (int) Math.sqrt(body.size());
        ycount = (int) Math.sqrt(body.size());
        if (countNewBalls % 2 == 0) {
            count = -count;
            ycount = -ycount;
        }

    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }

    public void drawBall(Graphics g) {

        for (Box box : body) {
            g.setColor(Color.red);
            g.fillOval(box.x * box.BOX_SIZE, box.y * box.BOX_SIZE,
                    box.BOX_SIZE, box.BOX_SIZE);
        }
    }

    public int returnSize() {
        return (int) Math.sqrt(body.size());
    }

    public void tick() {
        int count = this.count;
        int ycount = this.ycount;
        if (reverse1) {
            count = -count;
        }
        if (reverse2) {
            ycount = -ycount;
        }
        Box temp;
        for (int i = 0; i < body.size(); i++) {
            temp = body.get(i);
            if (temp.x + count > 30 || temp.x + count < 0) {
                reverse1 = !reverse1;
                System.out.println(reverse1);
                body = temp3;
                System.out.println(" 1 x= " + temp.x + "y= " + temp.y);
                tick();
            }
            if (temp.y + ycount > 30 || temp.y + ycount < 0) {
                reverse2 = !reverse2;
                System.out.println(reverse2);
                body = temp3;
                System.out.println(" 2 x= " + temp.x + "y= " + temp.y);
                tick();
            }
            temp.x = temp.x + count;
            temp.y = temp.y + ycount;
            body.set(i, temp);

        }
        if (body.contains(Shell.shell)) {
            //Game.gameRunning=false;
            makeNew = true;
        } else if (body.contains(Player.box)) {
            Game.gameRunning = false;
        }
        //System.out.println("I am here");
        temp3 = body;

    }

    public void makeBall() {
        body = new LinkedList<>();
        Collections.addAll(body,
                new Box(13, 15),
                new Box(13, 16),
                new Box(12, 15),
                new Box(12, 16)
        );
        count = (int) Math.sqrt(body.size());
        ycount = (int) Math.sqrt(body.size());

    }
}
