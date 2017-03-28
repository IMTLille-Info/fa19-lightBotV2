/**
 * 
 */
package project;

import static org.junit.Assert.*;

import javax.swing.GroupLayout.SequentialGroup;

import org.junit.Test;
import org.newdawn.slick.Animation;

/**
 * @author TSXN4236
 *
 */
public class DeplacementPersonnageTest {
	protected Animation[] animations = new Animation[8];
	
	/** The y. */
	protected float x = 50+16, y = 50+(5*32)+(16);// position  du personnage 
	
	/** The direction. */
	protected int direction=3;// direction du personnage
	
	/** The game over. */
	protected  boolean moving=false,gameOver=true;// déplacement du personnage
	
	/** The map. */
	protected Maps map;
	
	/** The control. */
	protected Controler control;
	
	/** The nbx. */
	private float nbx = this.x;
	
	/** The nby. */
	private float nby = this.y;
	private Boolean fal= false;
	
	/** The niveau. */
	private int niveau;
	//private boolean go = false;
	
	
	/** The fin. */
	private boolean fin=false;
	DeplacementPersonnage dl = new DeplacementPersonnage(map, control, direction);
	
    @Test
    public void test() {
    	//this.dl.setgameOver(fal);
    	assertEquals(this.dl.getgameOver(), true);

    }

}
