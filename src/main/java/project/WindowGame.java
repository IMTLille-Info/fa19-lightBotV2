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
	protected TiledMap tiledmap;// a supprimer si tu enlever dasn les parametre de la classe map 
	protected Maps map;// pareil que au dessus
	protected DeplacementPersonnage robot;
	protected Controler controleur;
	protected Sequencer sq;
	protected String str="";
	private boolean bool=false;
	protected float x = 50, y = 50+(5*32)+(16);// position  du personnage 
	protected int direction=3;// direction du personnage
	protected boolean moving=false;// deplacement ou pas 
	public enum ControleurPerso {haut,gauche,droite,bas,vide;}
	public List<ControleurPerso> listControl = new LinkedList<ControleurPerso>();// liste des d�placement a effectuer
	
	
	public WindowGame() {// constructeur de la classe creation des objet de "chaque" classe 
		super("test 1 :: lighbot");
		 this.map= new Maps(this.tiledmap);
		 this.robot=new DeplacementPersonnage(this.x,this.y,this.direction,this.moving);
		 this.controleur=new Controler(this.listControl);
		 this.sq = new Sequencer(controleur);
	}

	
	public void render(GameContainer container, Graphics g) throws SlickException {// boucle automatique
//contenu du jeux
		this.map.render();
		this.controleur.render(g);
		this.sq.decomposition(controleur,g);
		g.setBackground(new Color( 204,204 ,255 ));
		 g.setColor(new Color(0, 0, 0, .5f));
		  g.fillOval(this.x - 16, this.y - 8, 32, 16);
		   g.drawAnimation(this.robot.animations[this.direction + (this.moving ? 4 : 0)], this.x-32, this.y-60);
		   g.drawString( this.str , 0, 0);
		   g.drawLine( 0, 400, 500, 400);
		   g.drawLine( 500, 0, 500, 400);
		   //g.drawString( "controleur" , 200, 500);
		   g.drawString( "sequence" , 600, 200);
		   g.setColor(new Color( 0,255 ,0 ));
		   g.fillRect(400, 300, 100, 100);
		   g.setColor(new Color( 0,0,0 ));
		   g.drawString( "GO" , 440, 350);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
//initialisation
		this.container = container;
		this.map.init();
		this.robot.init();
		this.controleur.init();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
//mise a jour des �l�ments
		//str=""+delta;
		/*if (this.moving) {
	        switch (this.direction) {
	            case 0: this.y -= 0.1f * delta; break; // mettre des limite pour ne pas sortir de la map
	            case 1: this.x -= 0.1f * delta; break;
	            case 2: this.y += 0.1f * delta; break;
	            case 3: this.x += 0.1f * delta; break;
	        }
	    }*/

if(this.bool){//  debut du perso a 50px
if(this.x> 50+48 ){// une tuile = 32px + une demi tuile =16px 
	this.direction=0;// changement de la direction
	if(this.y<(50+(5*32)+(16)-32)){
		this.direction=3;
		if(this.x>50+48+64){
			this.direction=0;
			if(this.y<(50+(5*32)+(16)-32)-96){
				this.direction=3;
				if(this.x>50+48+64+96){
					this.moving=false;
				}
				else{
					this.x += 0.1f * delta;
				}
			}
			else{
				this.y -= 0.1f * delta;
			}
		}
		else{
			this.x += 0.1f * delta;
		}
	}
	else{
		this.y -= 0.1f * delta;
	}	
}
else{
	this.x += 0.1f * delta;
}}

}
	public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame(), 900, 680, false).start();// debut du programme 900/680 dimmention de la fenetre
    }

	
	@Override
	public void keyPressed(int key, char c) {// a metre dans input 
	    switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;  
	    }
	}
	
	@Override
	public void keyReleased(int key, char c) {// pareil input
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	        this.moving = false;
	        if (Input.KEY_W == key) {liste();}
	    }
	
	@Override
	public void mousePressed(int button, int x, int y) {// pareil input
		switch (button) {
		//case Input.isMouseButtonDown(button): 
		case Input.MOUSE_LEFT_BUTTON:
			if(400<x && x<500 && 300<y && y<400) {// bouton GO
				this.x = 50; this.y = 50+(5*32)+(16); this.moving=true; this.bool=true;
				} 
			if(y>486 && y<582){// (550 -64) +96
				if(x>50 && x <146){
					this.str="controleur haut";
					this.controleur.add(ControleurPerso.haut);
				}
				else if(x>178 && x<274){
					
					this.str="controleur gauche";
					this.controleur.add(ControleurPerso.gauche);
				}
				else if(x>306 && x<402){
					this.str="controleur droite";
					this.controleur.add(ControleurPerso.droite);
				}
				else if(x>434 && x<530){
					this.str="controleur bas";
					this.controleur.add(ControleurPerso.bas);
				}
				else this.str="mouse controleur";
			}
			else this.str="mouse active";break;
	}
	}
	@Override
	public void mouseReleased(int button, int x, int y) {// pareil input
		 //this.str="";
		liste();
	}
	
public void liste(){// juste pour les test
		
		//this.str=""+listControleurClickUtilisateur.get(listControleurClickUtilisateur.size()-1);
		this.str="";
		for(int i=0;i<=this.controleur.listControl.size()-1;i++){
			this.str=this.str+this.controleur.listControl.get(i)+", ";
		}
	}
	}

//http://slick.ninjacave.com/javadoc/org/newdawn/slick/Input.html