/**
 * 
 */
package project;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;



// TODO: Auto-generated Javadoc
/**
 * The Class WindowGame.
 *
 * @author ZMNF8866
 */
public class WindowGame extends BasicGame {// cette classe est le coeur du jeu
	
	private GameContainer container;
	protected TiledMap tiledmap;
	protected Maps map;
	protected DeplacementPersonnage robot;
	protected Controler controleur;
	protected Sequencer sq;
	protected Information info;
	private String str="";
	private boolean bool=false;
	protected enum ControleurPerso {haut,gauche,droite,bas,vide;}
	protected List<ControleurPerso> listControler = new LinkedList<ControleurPerso>();// liste des déplacements à effectuer
	protected int niveau=1;
	private int tmplvl=this.niveau;

	
	
	public WindowGame() {// constructeur de la classe instanciation des objets de chaque classe 
		super("test 1 :: lighbot");
		 this.controleur=new Controler(this.listControler,this.niveau);
		 this.map= new Maps(this.tiledmap,this.niveau);
		 this.robot=new DeplacementPersonnage(this.map,controleur,this.niveau);
		 this.sq = new Sequencer(controleur);
		 this.info= new Information(this.niveau,this.listControler,this.robot);
	}

	/*
	 * Nom de la méthode : render
	 * Parametres en entree : Graphics p_g
	 *  - nom_variable : p_g est pour insérer les éléments graphiques
	 * Objectif de la méthode :
	 * Ajouter des éléments dans le jeu
	 * Algorithme ou pseudo code :
	 * Debut */
	public void render(GameContainer container, Graphics p_g) throws SlickException {
		//contenu du jeu
		this.map.render();
		this.controleur.render(p_g);
		this.sq.decomposition(p_g);
		this.info.render(p_g);
		this.robot.render(p_g);
		p_g.setBackground(new Color( 204,204 ,255 ));
		 p_g.setColor(new Color(0, 0, 0, .5f));
		   p_g.drawString( this.str , 0, 0);
		   p_g.drawLine( 0, 400, 550, 400);
		   p_g.drawLine( 500, 0, 500, 400);
		   p_g.drawLine( 550, 400, 550, 680);
		   //g.drawString( "controleur" , 200, 500);
		   p_g.drawString( "sequence" , 600, 200);
		  
		   
		   p_g.setColor(new Color( 0,255 ,0 ));
		   p_g.fillRect(290, 300, 100, 100);
		   p_g.setColor(new Color( 0,0,0 ));
		   p_g.drawString( "Auto" , 322, 350);
		   
	}
	/* Fin */
	/*
	 * Nom de la méthode : init
	 * Objectif de la méthode :
	 * Initialiser les classes
	 * Algorithme ou pseudo code :
	 * Debut */
	@Override
	public void init(GameContainer container) throws SlickException {
		//initialisation
		this.container = container;
		this.map.init();
		this.robot.init();
	}
	/* Fin */
	/*
	 * Nom de la méthode : update
	 * Parametres en entree : int delta
	 *  - nom_variable : delta est le delta entre deux appels
	 * Objectif de la méthode :
	 * Mise à jour des éléments 
	 * Algorithme ou pseudo code :
	 * Debut */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		this.robot.update(container, delta);
		this.tmplvl=this.robot.getlvl();
		if(this.tmplvl!=this.niveau){ this.niveau=this.tmplvl;this.setniveau(this.niveau);}
	}
	/* Fin */
	/*
	 * Nom de la méthode : main
	 * Objectif de la méthode :
	 * Lance le programme avec la fenêtre
	 * Algorithme ou pseudo code :
	 * Debut */
	public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame(), 900, 680, false).start();// debut du programme 900/680 dimension de la fenetre
    }
	/* Fin */
	
	@Override
	public void keyPressed(int key, char c) {
	    /*switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;  
	    }*/
	}
	
	@Override
	public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	        this.robot.moving = false;
	       
	    }
	
	@Override
	public void mousePressed(int button, int x, int y) {
		
		switch (button) {
		//case Input.isMouseButtonDown(button): 
		
		case Input.MOUSE_LEFT_BUTTON:
			if(400<x && x<500 && 300<y && y<400) {// bouton GO
				//this.robot.x = 50; this.robot.y = 50+(5*32)+(16);
				 this.robot.setgameOver(true);
				this.robot.moving=true;// this.bool=true; 
				this.map.addlist();
				this.robot.x = 50+16;
				this.robot.y = 50+(5*32)+(16);
				
				
				} 
			if(y>486 && y<582){// (550 -64) +96
				if(x>50 && x <146){
					
					this.controleur.add(ControleurPerso.haut);
				}
				else if(x>178 && x<274){
					
					
					this.controleur.add(ControleurPerso.gauche);
				}
				else if(x>306 && x<402){
					
					this.controleur.add(ControleurPerso.droite);
				}
				else if(x>434 && x<530){
					
					this.controleur.add(ControleurPerso.bas);
				}
				
			}
	}
	}
	@Override
	public void mouseReleased(int button, int x, int y) {
		 //this.str="";
		
	}
	
	public void setniveau(int p_niveau){
		this.niveau=p_niveau;
		if(this.niveau<=3){
		this.info.setniveau(this.niveau);
		this.controleur.setniveau(this.niveau);
		this.map.setniveau(this.niveau);
		}
	}
	
}

//http://slick.ninjacave.com/javadoc/org/newdawn/slick/Input.html
