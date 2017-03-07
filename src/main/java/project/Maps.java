/**
 * 
 */
package project;

/**
 * @author ZMNF8866
 *
 */
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class Maps {
	private TiledMap map;

	public Maps(TiledMap map) {
        this.map=map;
    }
	
	public void render() {
		this.map.render(50, 50);
	}

	public void init() throws SlickException {
		this.map = new TiledMap("src/main/resources/map/lvl.tmx");
	}
}
