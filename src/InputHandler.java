import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class InputHandler implements KeyListener {
    public InputHandler(Game game){
        game.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_RIGHT) {
            if (Game.player.box.x < 29 ) {
                Game.player.setVel1(1);
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            if (Game.player.box.x > 0 ) {
                Game.player.setVel1(-1);
            }
        }else if(keyCode == KeyEvent.VK_UP){
            Game.shell.startShell=true;
        }
        if (keyCode == KeyEvent.VK_ESCAPE) ;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
