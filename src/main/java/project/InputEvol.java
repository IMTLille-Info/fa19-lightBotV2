/**
 * 
 */
package project;

import org.newdawn.slick.Input;

import project.WindowGame.ControleurPerso;

/**
 * @author TSXN4236
 *
 */
public class InputEvol extends WindowGame{// gere les inputs du programme (clic et deplacements souris, touches)

	
	@Override
	public void keyPressed(int key, char c) {
	    switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;  
	    }
	}
	
	@Override
	public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	        this.moving = false;
	        if (Input.KEY_W == key) {liste();}
	    }
	
	@Override
	public void mousePressed(int button, int x, int y) {
		switch (button) {
		//case Input.isMouseButtonDown(button): 
		case Input.MOUSE_LEFT_BUTTON:
			if(400<x && x<500 && 300<y && y<400) {// bouton GO
				this.x = 50; this.y = 50+(5*32)+(16); this.moving=true; this.bool=true;
				} 
			if(y>486 && y<582){// (550 -64) +96
				if(x>50 && x <146){
					this.str="controleur haut";
					this.controleur.add(ControleurPerso.haut);
				}
				else if(x>178 && x<274){
					
					this.str="controleur gauche";
					this.controleur.add(ControleurPerso.gauche);
				}
				else if(x>306 && x<402){
					this.str="controleur droite";
					this.controleur.add(ControleurPerso.droite);
				}
				else if(x>434 && x<530){
					this.str="controleur bas";
					this.controleur.add(ControleurPerso.bas);
				}
				else this.str="mouse controleur";
			}
			else this.str="mouse active";break;
	}
	}
	@Override
	public void mouseReleased(int button, int x, int y) {
		 //this.str="";
		liste();
	}
	
	public void liste(){// juste pour les tests
		
		//this.str=""+listControleurClickUtilisateur.get(listControleurClickUtilisateur.size()-1);
		this.str="";
		for(int i=0;i<=this.listControler.size()-1;i++){
			this.str=this.str+this.listControler.get(i)+", ";
		}
	}
	
	
}