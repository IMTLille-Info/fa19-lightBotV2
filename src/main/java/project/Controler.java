/**
 * 
 */
package project;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import project.WindowGame.ControleurPerso;

/**
 * @author ZMNF8866
 *
 */
public class Controler {
	public List<ControleurPerso> listControl= new LinkedList<ControleurPerso>();;
	 public int translation=0,start=0;	
	
	public Controler(List<ControleurPerso> listControl) {
		// TODO Auto-generated constructor stub
		this.listControl=listControl;
		this.add(ControleurPerso.vide);
	}

	public void render(Graphics g) {
		//this.controleur.render(50, 550);
		createControl(g,ControleurPerso.haut);
		createControl(g,ControleurPerso.gauche);
		createControl(g,ControleurPerso.droite);
		createControl(g,ControleurPerso.bas);	
	}

	public void init() throws SlickException {
	//si rien enlever
	}
	
	public void createControl(Graphics g, ControleurPerso control){
		translation=125;start=50;
		switch (control)
		{
		  case haut:
			  g.setColor(new Color( 0,255 ,0 ));
			  g.fillRect(start, 500, 100, 100);
			  g.setColor(new Color( 0,0,0 ));
			  g.drawString( "haut" , start, 500);
		    break;
		  case gauche:
			  g.setColor(new Color( 0,255 ,0 ));
			  g.fillRect(start+translation, 500, 100, 100);
			  g.setColor(new Color( 0,0,0 ));
			  g.drawString( "gauche" , start+translation, 500);
		    break;
		  case droite:
			  g.setColor(new Color( 0,255 ,0 ));
			  g.fillRect(start+translation*2, 500, 100, 100);
			  g.setColor(new Color( 0,0,0 ));
			  g.drawString( "droite" , start+translation*2, 500);
			break;
		  case bas:
			  g.setColor(new Color( 0,255 ,0 ));
			  g.fillRect(start+translation*3, 500, 100, 100);
			  g.setColor(new Color( 0,0,0 ));
			  g.drawString( "bas" , start+translation*3, 500);
			 break;
		  default:
			  g.drawString( "ERREUR" , 0, 0);
		}
	}	
	
	public void add(ControleurPerso control) {
		switch (control)
		{
		  case vide:
			  listControl.add(ControleurPerso.vide);
		    break;
		  case haut:
			  listControl.add(ControleurPerso.haut);
		    break;
		  case gauche:
			  listControl.add(ControleurPerso.gauche);
		    break;
		  case droite:
			  listControl.add(ControleurPerso.droite);
			break;
		  case bas:
			  listControl.add(ControleurPerso.bas);
			 break;
		  default:
			  listControl.add(ControleurPerso.vide);
		}
	}
}
