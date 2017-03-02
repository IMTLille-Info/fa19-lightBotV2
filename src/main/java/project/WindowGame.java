/**
 * 
 */
package project;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

// TODO: Auto-generated Javadoc
/**
 * The Class WindowGame.
 *
 * @author 
 */
public class WindowGame extends BasicGame {
    
    
    private GameContainer container;
    
    
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame(), 640, 480, false).start();
    }
    
    public WindowGame() {
	super("project :: WindowGame");
    }
    
    @Override
    public void init(GameContainer container) throws SlickException {
        this.container = container;
    }

    public void render(GameContainer arg0, Graphics arg1) throws SlickException {
	// TODO Auto-generated method stub
    }

    
    @Override
    public void update(GameContainer arg0, int arg1) throws SlickException {
	// TODO Auto-generated method stub
	
    }
    
    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }
    
    
}