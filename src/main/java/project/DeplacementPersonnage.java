/**
 * 
 */
package project;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * @author TSXN4236
 *
 */
public class DeplacementPersonnage {// classe qui gere le deplacement et les sprites du personnage
		protected Animation[] animations = new Animation[8];
		private float x;
		private float y;
		private boolean moving;//  est le boolean "false" le personnage est static "true" le personnage "bouge"
		private int direction;// gere la direction du personnage

		public DeplacementPersonnage(float p_x, float p_y, int p_direction, boolean p_moving) {// constructeur de la classe
			this.x=p_x;
			this.y=p_y;
			this.direction=p_direction;
			this.moving=p_moving; 
		}

		public void init() throws SlickException {// initialisation des sprites 
			SpriteSheet spriteSheet = new SpriteSheet("src/main/resources/sprites/c.png", 64, 64);
			this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);// appel la methode pour charger les sprites
		    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		    this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
		    this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
		    this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
		    this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
		}

		private Animation loadAnimation(SpriteSheet p_spriteSheet, int p_startX, int p_endX, int p_y) {// charge les sprites dans un tableau
		    Animation animation = new Animation();
		    for (int x = p_startX; x < p_endX; x++) {
		        animation.addFrame(p_spriteSheet.getSprite(x, p_y), 100);
		    }
		    return animation;
		}
	}

