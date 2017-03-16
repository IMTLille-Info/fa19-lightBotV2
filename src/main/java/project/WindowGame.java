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
	
	protected GameContainer container;
	protected TiledMap tiledmap;// a supprimer si tu enlever dans les parametres de la classe map 
	protected Maps map;// pareil que au dessus
	protected DeplacementPersonnage robot;
	protected Controler controleur;
	protected Sequencer sq;
	protected String str="";
	private boolean bool=false;
	protected float x = 50, y = 50+(5*32)+(16);// position  du personnage 
	protected int direction=3;// direction du personnage
	protected boolean moving=false;// deplacement ou pas 
	protected enum ControleurPerso {haut,gauche,droite,bas,vide;}
	protected List<ControleurPerso> listControler = new LinkedList<ControleurPerso>();// liste des déplacements a effectuer
	
	
	public WindowGame() {// constructeur de la classe creation des objets de "chaque" classe 
		super("test 1 :: lighbot");
		 this.map= new Maps(this.tiledmap);
		 this.robot=new DeplacementPersonnage(this.x,this.y,this.direction,this.moving);
		 this.controleur=new Controler(this.listControler);
		 this.sq = new Sequencer(controleur);
	}

	
	public void render(GameContainer container, Graphics p_g) throws SlickException {// boucle automatique
//contenu du jeu
		this.map.render();
		this.controleur.render(p_g);
		this.sq.decomposition(p_g);
		p_g.setBackground(new Color( 204,204 ,255 ));
		 p_g.setColor(new Color(0, 0, 0, .5f));
		  p_g.fillOval(this.x - 16, this.y - 8, 32, 16);
		   p_g.drawAnimation(this.robot.animations[this.direction + (this.moving ? 4 : 0)], this.x-32, this.y-60);
		   p_g.drawString( this.str , 0, 0);
		   p_g.drawLine( 0, 400, 500, 400);
		   p_g.drawLine( 500, 0, 500, 400);
		   //g.drawString( "controleur" , 200, 500);
		   p_g.drawString( "sequence" , 600, 200);
		   p_g.setColor(new Color( 0,255 ,0 ));
		   p_g.fillRect(400, 300, 100, 100);
		   p_g.setColor(new Color( 0,0,0 ));
		   p_g.drawString( "GO" , 440, 350);
		   p_g.setColor(new Color( 0,255 ,0 ));
		   p_g.fillRect(290, 300, 100, 100);
		   p_g.setColor(new Color( 0,0,0 ));
		   p_g.drawString( "Auto" , 330, 350);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
//initialisation
		this.container = container;
		this.map.init();
		this.robot.init();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
	//mise a jour des éléments
			//str=""+delta;
			/*if (this.moving) {
		        switch (this.direction) {
		            case 0: this.y -= 0.1f * delta; break; // mettre des limites pour ne pas sortir de la map
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
		}
	}
	}
	
	public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame(), 900, 680, false).start();// debut du programme 900/680 dimension de la fenetre
    }
}

//http://slick.ninjacave.com/javadoc/org/newdawn/slick/Input.html
