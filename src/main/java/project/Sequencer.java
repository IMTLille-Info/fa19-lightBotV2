package project;

import org.newdawn.slick.Graphics;

public class Sequencer {
	private Controler controleur;
	private int moveCount = 0;
	
	public Sequencer(Controler p_c){
		this.controleur = p_c;
	}
	public void decomposition(Controler p_c, Graphics p_g){ //this.controleur
		String toReturn = "";
		for(int i=0; i<p_c.listControl.size(); i++){
			switch (p_c.listControl.get(i)){
				case haut :
					toReturn+="haut ";
				break;
				case bas :
					toReturn+="bas ";
				break;
				case gauche :
					toReturn+="gauche ";
				break;
				case droite :
					toReturn+="droite ";
				break;
				case vide :
					toReturn+="";
				break;
			}
		}
		p_g.drawString(toReturn, 510, 250);
		moveCount = p_c.listControl.size();
	}
	
	
	public int getMoveCount() {
		return moveCount;
	}
	
}