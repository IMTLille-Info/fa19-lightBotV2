/**
 * 
 */
package project;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * @author TSXN4236
 *
 */
public class DeplacementPersonnage {// classe qui gere le deplacement et les sprites du personnage
		protected Animation[] animations = new Animation[8];
		protected float x = 50+16, y = 50+(5*32)+(16);// position  du personnage 
		protected int direction=3;// direction du personnage
		protected  boolean moving=false;// déplacement du personnage
		protected Maps map;
		protected Controler control;
		private float nbx = this.x;
		private float nby = this.y;
		private float z;
	
				public DeplacementPersonnage(Maps p_m, Controler p_c) {// constructeur de la classe
			this.map=p_m;
			this.control=p_c;
		}

		public void init() throws SlickException {// initialisation des sprites 
			SpriteSheet spriteSheet = new SpriteSheet("src/main/resources/sprites/c.png", 64, 64);
			this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);// appel de la methode pour charger les sprites
		    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		    this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
		    this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
		    this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
		    this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
		}
		public void render(Graphics p_g) throws SlickException {/// contenu du jeu
			 p_g.setColor(new Color(0, 0, 0, .5f));
			p_g.fillOval(this.x - 16, this.y - 8, 32, 16);
			p_g.drawAnimation(this.animations[this.direction + (this.moving ? 4 : 0)], this.x-32, this.y-60);
			
		}

		private Animation loadAnimation(SpriteSheet p_spriteSheet, int p_startX, int p_endX, int p_y) {// charge les sprites dans un tableau
		    Animation animation = new Animation();
		    for (int x = p_startX; x < p_endX; x++) {
		        animation.addFrame(p_spriteSheet.getSprite(x, p_y), 100);
		    }
		    return animation;
		}
		
		/*
		 * Nom de la méthode : update
		 * Parametres en entree : int delta
		 *  - nom_variable : delta est le delta entre deux appels
		 * Objectif de la méthode :
		 * Mise à jour des éléments 
		 * Algorithme ou pseudo code :
		 * Debut */
		public void update(GameContainer container, int delta) throws SlickException {
			
			if (this.moving) {
				try{
					switch (this.control.listControleur.get(0)) {
				    	case haut : if(this.y>nby-32){this.direction = 0; this.y -= 0.1f * delta;}
				    				else {this.control.listControleur.remove(0); nbx = this.x;nby = this.y;} break; 
				    	case bas: if(this.y<nby+32){this.direction = 1; this.y += 0.1f * delta;}
				    			  else {this.control.listControleur.remove(0); nbx = this.x;nby = this.y;} break;
				    	case gauche: if(this.x>nbx-32){this.direction = 2; this.x -= 0.1f * delta;}
				    				 else {this.control.listControleur.remove(0); nbx = this.x;nby = this.y;} break;
				    	case droite: if(this.x<nbx+32){this.direction = 3; this.x += 0.1f *delta;}
				    				 else {this.control.listControleur.remove(0); nbx = this.x;nby = this.y;} break;
				    	default :
				    		System.out.println("testt");
				    				 
					}
				}
				catch(java.lang.IndexOutOfBoundsException e){
					this.moving=false; 
					this.nbx = 50+16; 
					this.nby = 50+(5*32)+(16);
				}
			}
	}

		
		public float getX() {
			return this.x;
		}
		public float getY() {
			return this.y;
		}
		

		
	}

	