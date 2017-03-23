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
	
	public void render() {/// contenu du jeu
		this.map.render(50, 50);// place la map a 50x et 50y
	}

	public void init() throws SlickException {//initalise la première map 
		this.map = new TiledMap("src/main/resources/map/lvl.tmx");
	}
}
/*
public class Maps extends WindowGame {// classe qui gere les maps
	private TiledMap map;

	public Maps(TiledMap map) {// enlever TileMap du constructeur 
	    this.map=map;
	}
	
	public void render() {/// contenu du jeu
		this.map.render(50, 50);// place la map a 50x et 50y
	}

	public void init() throws SlickException {//initalise la premiere map 
		this.map = new TiledMap("src/main/resources/map/lvl.tmx");
	}
	
	private void updateTrigger() throws SlickException {
		for (int objectID = 0; objectID < this.map.getObjectCount(0); objectID++) {
			if (isInTrigger(objectID)) {
				if ("teleport".equals(this.map.getObjectType(0, objectID))) {
					teleport(objectID);
				} else if ("change-map".equals(this.map.getObjectType(0, objectID))) {
					changeMap(objectID);
				}
			}
		}
	}
		
	
	
	private void teleport(int objectID) {
		this.x = Float.parseFloat(this.map.getObjectProperty(0, objectID, "dest-x",
				Float.toString(x)));
		this.y = Float.parseFloat(this.map.getObjectProperty(0, objectID, "dest-y",
				Float.toString(y)));
	}

	private void changeMap(int objectID) throws SlickException {
		teleport(objectID);
		String newMap = this.map.getObjectProperty(0, objectID, "dest-map", "undefined");
		if (!"undefined".equals(newMap)) {
			this.map = new TiledMap("src/main/resources/map/lvl1.2.tmx" + newMap);
			//public void clear(List<ControleurPerso> p_listtoclear){
		}
	}
	
	private boolean isInTrigger(int id) {
		return this.x > this.map.getObjectX(0, id)
				&& this.x < this.map.getObjectX(0, id) + this.map.getObjectWidth(0, id)
				&& this.y > this.map.getObjectY(0, id)
				&& this.y < this.map.getObjectY(0, id) + this.map.getObjectHeight(0, id);
	}
	
	
	
}*/