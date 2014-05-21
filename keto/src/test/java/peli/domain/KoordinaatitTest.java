
package peli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KoordinaatitTest {
    
    public KoordinaatitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void liikutaYlosToimii() {
        Koordinaatit koordinaatit = new Koordinaatit(1,1);
        koordinaatit.liikuta(Suunta.YLOS);
        assertEquals(1, koordinaatit.getX());
        assertEquals(0, koordinaatit.getY());
    }
    
    @Test
    public void liikutaAlasToimii() {
        Koordinaatit koordinaatit = new Koordinaatit(1,1);
        koordinaatit.liikuta(Suunta.ALAS);
        assertEquals(1, koordinaatit.getX());
        assertEquals(2, koordinaatit.getY());
    }
    
    @Test
    public void liikutaOikealleToimii() {
        Koordinaatit koordinaatit = new Koordinaatit(1,1);
        koordinaatit.liikuta(Suunta.OIKEA);
        assertEquals(2, koordinaatit.getX());
        assertEquals(1, koordinaatit.getY());
    }
    
    @Test
    public void liikutaVasemmalleToimii() {
        Koordinaatit koordinaatit = new Koordinaatit(1,1);
        koordinaatit.liikuta(Suunta.VASEN);
        assertEquals(0, koordinaatit.getX());
        assertEquals(1, koordinaatit.getY());
    }
}
