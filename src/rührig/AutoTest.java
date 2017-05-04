package rührig;

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/**
 * Eine Testklasse zu der Klasse "Auto"
 * in der die Methoden mit der JUnit-Libary getestet werden.
 * @author Kevin Rührig 3CHIT
 * @version 5/4/2017
 * 
 * GitHub - SSH:
 * git@github.com:tgm-kruehrig/AutoTest19_kruehrig.git
 */
public class AutoTest {
	
	Auto a = new Auto("Volvo", Color.blue, 400);
	
	/**
	 * Attribute des Auto-Objektes testen.
	 * Es sollten alle passen.
	 */
	@Test
	public void testAuto1(){
		assertEquals("Volvo", a.getType());
	}
	
	@Test
	public void testAuto2(){
		assertEquals(Color.blue, a.getFarbe());
	}
	
	@Test
	public void testAuto3(){
		assertEquals(400, a.getLeistung());
	}
	
	/**
	 * Attribute des Auto-Objektes testen
	 * diesmal mit falschem Input
	 * Diese Tests ergeben keinen Sinn bzw. sind unnötig
	 */
	@Test
	public void testAuto1_1(){
		assertEquals("Ferrari", a.getType());
	}
	
	@Test
	public void testAuto2_1(){
		assertEquals(Color.red, a.getFarbe());
	}
	
	@Test
	public void testAuto3_1(){
		assertEquals(300, a.getLeistung());
	}
	
	/**
	 * Tests, in denen das Objekt verändert wird
	 * und anschließend die Attribute getestet.
	 */
	@Test
	public void test4(){
		a.setType("VW");
		assertEquals("VW", a.getType());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test4_1(){
		a.setType("  ");
	}
	
	@Test
	public void test5(){
		a.setFarbe(Color.white);
		assertEquals(Color.white, a.getFarbe());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test5_1(){
		a.setFarbe(null);
	}
	
	/**
	 * Hier gibt es einen Fehler im Code:
	 * leistung = this.leistung;
	 * Der Parameter von setLeistung() kann nicht gesetzt werden,
	 * da er immer auf das Attribut gestzt wird!
	 * Richtig wäre: this.leistung = leistung;
	 */
	@Test
	public void test6(){
		a.setLeistung(250);
		assertEquals(250, a.getLeistung());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test6_1(){
		a.setLeistung(0);
	}
	
	/**
	 * Hier wird die toString() Methode getestet
	 * Der Fehler liegt in dem letzten if-Statement:
	 * Wird die Farbe des Autos auf Color.black gesetzt,
	 * wird der String "rot" zurückgegeben.
	 * Richtig wäre:
	 * if (farbe.equals(Color.BLACK)) {
			farbString = "schwarz";
		}
	 */
	@Test
	public void test8(){
		a.setFarbe(Color.black);
		assertTrue(a.toString().contains("schwarz"));
	}
}
