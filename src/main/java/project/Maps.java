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


public class Maps {// classe qui gere les maps
	private TiledMap map;

	public Maps(TiledMap map) {// enlever TileMap du constructeur 
        this.map=map;
    }
	
	public void render() {/// contenu du jeux
		this.map.render(50, 50);// place la map a 50x et 50y
	}

	public void init() throws SlickException {//initalise la 1er map 
		this.map = new TiledMap("src/main/resources/map/lvl.tmx");
	}
}
