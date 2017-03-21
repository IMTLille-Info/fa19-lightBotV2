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

	public Information(int p_niveau,List<ControleurPerso> p_listControl) {
		this.niveau=p_niveau;
		this.listControleurinfo=p_listControl;
	}
	
	
	public void render(Graphics p_g) {// methode qui met a jours le contenu du jeux 
		   p_g.setColor(new Color( 0,0,0 ));
		   p_g.drawString( "Information" ,  650, 400);
		   p_g.drawString( "level : "+this.niveau ,  550, 420);
		   if(nombrelist()<=0){
			   p_g.drawString( "nombre de déplacement restant : 0" ,  550, 440);
		   }
		   else{
			   p_g.drawString( "nombre de déplacement restant : "+nombrelist() ,  550, 440);
		   }
		  
	}
	private int nombrelist() {
		this.compteurList=0;
		for(int i=0;i<=this.listControleurinfo.size()-1;i++){
			this.compteurList++;
		}
		switch(this.niveau){
		case 1 :
			this.compteurList=12-this.compteurList;
			break;
		case 2:
			this.compteurList=15-this.compteurList;
			break;
		
		}
		return this.compteurList;
	}
}
