/**
 * 
 */
package project;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import project.WindowGame.ControleurPerso;

/**
 * @author ZMNF8866
 *
 */
public class Controler {// la classe controleur gere les boutons des actions du personnage
	protected List<ControleurPerso> listControleur= new LinkedList<ControleurPerso>();
	 private int translation=0,start=0;
		
	public Controler(List<ControleurPerso> p_listControl) {// constructeur de la classe controleur
		this.listControleur=p_listControl;
	}
	/*
	 * Nom de la m�thode : render
	 * Parametres en entree : Graphics p_g
	 *  - nom_variable : p_g est pour ins�rer les �l�ments graphique
	 * Objectif de la m�thode :
	 * Cr�e les controleurs
	 * 
	 * Algorithme ou pseudo code :
	 * Debut*/
	public void render(Graphics p_g) {// methode qui met a jour le contenu du jeu
		createControl(p_g,ControleurPerso.haut);// appel de la methode de creation pour le controleur haut
		createControl(p_g,ControleurPerso.gauche);
		createControl(p_g,ControleurPerso.droite);
		createControl(p_g,ControleurPerso.bas);
	}
	/* Fin */
	/*
	 * Nom de la m�thode : clear
	 * Parametres en entree : N/A
	 * Objectif de la m�thode :
	 * Enlever tous les �l�ments de la liste des controleurs
	 * Algorithme ou pseudo code :
	 * Debut*/
	public void clear(){
		while(this.listControleur.size()!=0){
		for(int i=0;i<=this.listControleur.size()-1;i++){
		 this.listControleur.remove(i);
		}}
	}
	/* Fin */
	/*
	 * Nom de la m�thode : createControl
	 * Parametres en entree : Graphics p_g, ControleurPerso p_control
	 *  - nom_variable : p_g est pour ins�rer les �l�ments graphique
	 *   - nom_variable : p_control est pour connaitre le controleur � ajouter
	 * Objectif de la m�thode :
	 * Cr�e les controleurs
	 * 
	 * Algorithme ou pseudo code :
	 * Debut*/
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
	/* Fin */
	/*
	 * Nom de la m�thode : add
	 * Parametres en entree : ControleurPerso p_control
	 *  - nom_variable : p_control est le controleur a mettre dans la liste
	 * Objectif de la m�thode :
	 * ajouter des controleurs dans la liste
	 * 
	 * Algorithme ou pseudo code :
	 * Debut*/
	public void add(ControleurPerso p_control) {//  methode pour inserer les valeur dans la liste 
			  this.listControleur.add(p_control);
	}
	/* Fin */
}
