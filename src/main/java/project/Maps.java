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
	protected DeplacementPersonnage robot;
	
	public Maps(TiledMap map, int p_niveau) {// enlever TileMap du constructeur 
        this.map=map;
        this.niveau=p_niveau;
    }
	
	public void render() throws SlickException {/// contenu du jeu
		this.map.render(50, 50);// place la map a 50x et 50y
		//this.map = new TiledMap("src/main/resources/map/lvl2.tmx");
		switch(niveau){

		case 1: 
			this.map = new TiledMap("src/main/resources/map/lvl.tmx");
			break;
		case 2:
			this.map = new TiledMap("src/main/resources/map/lvl2.tmx");
			break;
		case 3:
			this.map = new TiledMap("src/main/resources/map/lvl3.tmx");
			break;
		}
	}

public void init() throws SlickException {//initalise la première map 
	this.map = new TiledMap("src/main/resources/map/lvl.tmx");
		addlist();
}


public void clear(){
	while(this.listControleurlvl.size()!=0){
		for(int i=0;i<=this.listControleurlvl.size()-1;i++){
			this.listControleurlvl.remove(i);
		}
	}
}

public void addlist(){
clear();
	switch(niveau){

	case 1: 
		//Pour le niveau 1
			this.listControleurlvl.add(ControleurPerso.droite);//start
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
			this.listControleurlvl.add(ControleurPerso.droite);
			this.listControleurlvl.add(ControleurPerso.droite);//arrivee
		break;
	}	
		
}
public void setniveau(int p_niveau){
	this.niveau=p_niveau;
	}

}