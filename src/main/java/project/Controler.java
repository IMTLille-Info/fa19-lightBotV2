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
public class Controler {// la classe controleur gere les boutons des actions du personnage
	public List<ControleurPerso> listControl= new LinkedList<ControleurPerso>();;
	 public int translation=0,start=0;	
	
	public Controler(List<ControleurPerso> p_listControl) {// constructeur de la classe controleur
		this.listControl=p_listControl;
		this.add(ControleurPerso.vide);// met la valeur vide en premiere valeur de la liste 
	}

	public void render(Graphics p_g) {// methode qui met a jours le contenu du jeux 
		//this.controleur.render(50, 550);
		createControl(p_g,ControleurPerso.haut);// appel de la methode de creation pour le controleur haut
		createControl(p_g,ControleurPerso.gauche);
		createControl(p_g,ControleurPerso.droite);
		createControl(p_g,ControleurPerso.bas);	
	}

	public void init() throws SlickException {
	//si rien enlever
	}
	
	public void createControl(Graphics p_g, ControleurPerso p_control){// methode qui place sur l'affichage les controleurs
		translation=125;start=50;
		switch (p_control)
		{
		  case haut:// cree le controleur haut
			  p_g.setColor(new Color( 0,255 ,0 ));//set la couleur pour le rectangle
			  p_g.fillRect(start, 500, 100, 100);//cree un rectangle
			  p_g.setColor(new Color( 0,0,0 ));// set la couleur pour le texte
			  p_g.drawString( "haut" , start, 500);// cree le texte
		    break;
		  case gauche:
			  p_g.setColor(new Color( 0,255 ,0 ));
			  p_g.fillRect(start+translation, 500, 100, 100);
			  p_g.setColor(new Color( 0,0,0 ));
			  p_g.drawString( "gauche" , start+translation, 500);
		    break;
		  case droite:
			  p_g.setColor(new Color( 0,255 ,0 ));
			  p_g.fillRect(start+translation*2, 500, 100, 100);
			  p_g.setColor(new Color( 0,0,0 ));
			  p_g.drawString( "droite" , start+translation*2, 500);
			break;
		  case bas:
			  p_g.setColor(new Color( 0,255 ,0 ));
			  p_g.fillRect(start+translation*3, 500, 100, 100);
			  p_g.setColor(new Color( 0,0,0 ));
			  p_g.drawString( "bas" , start+translation*3, 500);
			 break;
		  default:
			  p_g.drawString( "ERREUR" , 0, 0);
		}
	}	
	
	public void add(ControleurPerso p_control) {//  methode pour inserer les valeur dans la liste 
		switch (p_control)
		{
		  case vide:
			  listControl.add(ControleurPerso.vide);
		    break;
		  case haut:
			  listControl.add(ControleurPerso.haut);// insere le controle haut dans la liste
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