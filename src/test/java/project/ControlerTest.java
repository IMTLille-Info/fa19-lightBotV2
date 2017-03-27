/**
 * 
 */
package project;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import junit.framework.*;
import project.WindowGame.ControleurPerso;

/**
 * @author ZMNF8866
 *
 */

public class ControlerTest {
	protected List<ControleurPerso> listControleur= new LinkedList<ControleurPerso>();
 	private int translation=0,start=0,niveau=1,compteurList=0;
	protected Controler controleur;
	private int a;
	

	@Test
    public void testadd() {
		List<ControleurPerso> listControleur= new LinkedList<ControleurPerso>();
		this.listControleur.clear();
		a =this.listControleur.size();
		assertEquals(0, a);
    }





}
