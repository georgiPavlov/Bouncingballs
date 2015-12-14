import java.applet.Applet;
import java.awt.*;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class GameApp extends Applet {
    public Game game;
    InputHandler inputHandler;

    public void init(){
        game = new Game();
        game.setBackground(Color.yellow);
        game.setPreferredSize(new Dimension(600,625));
        game.setVisible(true);
        this.add(game);
        game.setFocusable(true);
        inputHandler = new InputHandler(game);


    }

    public void paint(Graphics g){
        this.setSize(new Dimension(800,650));

    }
}
