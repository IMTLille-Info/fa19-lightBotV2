package project;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import project.WindowGame.ControleurPerso;


public class Information {

	private int niveau;
	protected List<ControleurPerso> listControleurinfo= new LinkedList<ControleurPerso>();
	private int compteurList=12;
	private DeplacementPersonnage perso;

	public Information(int p_niveau,List<ControleurPerso> p_listControl,DeplacementPersonnage p_perso) {
		this.niveau=p_niveau;
		this.listControleurinfo=p_listControl;
		this.perso=p_perso;
	}
	
	/*
	 * Nom de la m�thode : render
	 * Parametres en entree :Graphics p_g
	 *  - nom_variable : p_g est pour ins�rer les �l�ments graphiques
	 * Objectif de la m�thode :
	 * M�thode qui met � jour le contenu du jeu pour la partie information
	 * Algorithme ou pseudo code :
	 * Debut
	*/
	public void render(Graphics p_g) {// m�thode qui met � jour le contenu du jeu 
		   p_g.setColor(new Color( 0,0,0 ));
		   p_g.drawString( "Information" ,  650, 400);
		   p_g.drawString( "level : "+this.niveau ,  550, 420);
		  
		   if(nombrelist()<=0){
			   p_g.drawString( "nombre de d�placement restant : 0" ,  550, 440);
		   }
		   else{
			   p_g.drawString( "nombre de d�placement restant : "+nombrelist() ,  550, 440);
		   }
		   if(this.perso.getgameOver()==false){
			   p_g.setColor(new Color( 204,0 ,0 ));
			   p_g.fillRect(400, 300, 100, 100);
			   p_g.setColor(new Color( 0,0,0 ));
			   p_g.drawString( "Try Again" , 410, 350);
			   p_g.setColor(new Color( 204,0,0 ));
			   p_g.drawString( "Try Again" , 125, 146);
			  
		   }
		   else{
			   p_g.setColor(new Color( 0,255 ,0 ));
			   p_g.fillRect(400, 300, 100, 100);
			   p_g.setColor(new Color( 0,0,0 ));
			   p_g.drawString( "GO" , 440, 350);
		   }
	}
	
	 /* Fin */
	
	/*
	 * Nom de la m�thode : nombrelist
	 * Parametres en entree : N/A
	 * Valeur retourn�e : int this.compteurList retourne le nombre de contr�leurs possibles moins 
	 * le nombre de contr�leurs dans la liste 
	 * Objectif de la m�thode :
	 * Retouner la diff�rence entre le nombre de d�placements posibles pour la map et le nombre de contr�leurs
	 * Algorithme ou pseudo code :
	 * Debut */
	private int nombrelist() {
		this.compteurList=0;
		for(int i=0;i<=this.listControleurinfo.size()-1;i++){
			this.compteurList++;
		}
		switch(this.niveau){
		case 1 :
			this.compteurList=10-this.compteurList;
			break;
		case 2:
			this.compteurList=14-this.compteurList;
			break;
		case 3:
			this.compteurList=18-this.compteurList;
			break;
		
		}
		return this.compteurList;
	}
	/* Fin */
	public void setniveau(int p_niveau){
		this.niveau=p_niveau;
		}
	
}
