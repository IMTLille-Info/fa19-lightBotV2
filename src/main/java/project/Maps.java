/**
 * 
 */
package project;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Color;
/**
 * @author ZMNF8866
 *
 */
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import project.WindowGame.ControleurPerso;


public class Maps {// classe qui gere les maps
	private TiledMap map;
	protected List<ControleurPerso> listControleurlvl= new LinkedList<ControleurPerso>();
	protected int niveau=1;
	private float x;
	private float y;

	public Maps(TiledMap map, int p_niveau) {// enlever TileMap du constructeur 
        this.map=map;
        this.niveau=p_niveau;
    }
	
	public void render() throws SlickException {/// contenu du jeu
		this.map.render(50, 50);// place la map a 50x et 50y
		//this.map = new TiledMap("src/main/resources/map/lvl2.tmx");
	}

public void init() throws SlickException {//initalise la première map 
		//this.map = new TiledMap("src/main/resources/map/lvl.tmx");
		addlist();
}
void updateTrigger() throws SlickException {
	   
    for (int objectID = 0; objectID < this.map.getObjectCount(0); objectID++) {
        if (isInTrigger(objectID)) {
            String type = this.map.getObjectType(0, objectID);
            if ("teleport".equals(type)) {
                teleport(objectID);
            } else if ("change-map".equals(type)) {
                changeMap(objectID);
            }
        }
    }
}


private void teleport(int objectID) {
	this.x = Float.parseFloat(this.map.getObjectProperty(0, objectID, "dest-x",	Float.toString(x)));
	this.y = Float.parseFloat(this.map.getObjectProperty(0, objectID, "dest-y",	Float.toString(y)));

}

private void changeMap(int objectID) throws SlickException {
	teleport(objectID);
	String newMap = this.map.getObjectProperty(0, objectID, "dest-map", "undefined");
	if (!"undefined".equals(newMap)) {
		this.map = new TiledMap("src/main/resources/map/lvl2.tmx" + newMap);
		//public void clear(List<ControleurPerso> p_listtoclear){
	}
}


private boolean isInTrigger(int id) {
	return this.x > this.map.getObjectX(0, id)
			&& this.x < this.map.getObjectX(0, id) + this.map.getObjectWidth(0, id)
			&& this.y > this.map.getObjectY(0, id)
			&& this.y < this.map.getObjectY(0, id) + this.map.getObjectHeight(0, id);
}

public void clear(){
	while(this.listControleurlvl.size()!=0){
		for(int i=0;i<=this.listControleurlvl.size()-1;i++){
			this.listControleurlvl.remove(i);
		}
	}
}

void addlist(){
clear();
	switch(niveau){

	case 1: 
		//Pour le niveau 1
			this.listControleurlvl.add(ControleurPerso.droite);//start
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);//arrivee
		break;
	case 2:
		//Pour le niveau 2
			this.listControleurlvl.add(ControleurPerso.droite);//start
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.bas);
			this.listControleurlvl.add(ControleurPerso.bas);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.droite);//arrivee
		break;
		
	case 3:
		//Pour le niveau 3
			this.listControleurlvl.add(ControleurPerso.droite);//start
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.gauche);
			this.listControleurlvl.add(ControleurPerso.gauche);
			this.listControleurlvl.add(ControleurPerso.gauche);
			this.listControleurlvl.add(ControleurPerso.gauche);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.haut);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);//arrivee
		break;
	}	
		
}

}