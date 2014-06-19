
package peli.huipputulokset;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TulosTest {
    
    public TulosTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void getNimiPalauttaaNimen() {
        Tulos tulos = new Tulos("Matti", 5);
        assertEquals("Matti", tulos.getNimi());
    }
    
    @Test
    public void getPisteetPalauttaaPisteet() {
        Tulos tulos = new Tulos("Matti", 5);
        assertEquals(5, tulos.getPisteet());
    }
    
    @Test
    public void compareToPalauttaaOikeanTuloksenKunToinenOnSuurempi() {
        Tulos tulos = new Tulos("Matti", 5);
        Tulos toinen = new Tulos("Pekka", 10);
        assertEquals(5, tulos.compareTo(toinen));
    }
    
    @Test
    public void compareToPalauttaaOikeanTuloksenKunToinenOnPienempi() {
        Tulos tulos = new Tulos("Matti", 5);
        Tulos toinen = new Tulos("Pekka", 2);
        assertEquals(-3, tulos.compareTo(toinen));
    }
    
    @Test
    public void compareToPalauttaaOikeanTuloksenKunTSamanSuuruiset() {
        Tulos tulos = new Tulos("Matti", 5);
        Tulos toinen = new Tulos("Pekka", 5);
        assertEquals(0, tulos.compareTo(toinen));
    }
}
