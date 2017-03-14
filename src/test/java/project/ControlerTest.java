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
private static Properties prop;  // les propriétés
private static FileInputStream propFile;  //le fichier de propriétés
public class ControlerTest {
	public List<ControleurPerso> listControl= new LinkedList<ControleurPerso>();
	expectedSize = ControleurPerso.parseInt(prop.getProperty("taille"));
    @Test
    public void testadd() {
    	assertEquals(expectedSize, listControl.size());
    	listControl.add(ControleurPerso.haut);
    	assertEquals(expectedSize+1, listControl.size());
    	 assertThat(Month.valueOf("January"), is(notNullValue()));
    	 List<String> e = mapperFactory.getMapperFacade().mapAsList(Arrays.asList(E.a, E.b, E.c), String.class);
         
         Assert.assertEquals(Arrays.asList("a", "b", "c"), e);
    	

	
	//fail("Not yet implemented");
    }

}
