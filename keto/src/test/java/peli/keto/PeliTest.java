
package peli.keto;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import peli.gui.Piirtoalusta;

public class PeliTest {
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void setPisteetAsettaaPisteetOikein() {
        Peli peli = new Peli(2,2);
        peli.setPisteet(3);
        assertEquals(3, peli.getPisteet());
    }
    
    @Test
    public void getPisteetAntaaPisteetOikein() {
        Peli peli = new Peli(2,2);
        peli.setPisteet(3);
        assertEquals(3, peli.getPisteet());
    }
    
    @Test
    public void getRuudukkoPalauttaaOikeanKokoisenRuudukon() {
        Peli peli = new Peli(2,2);
        assertEquals(2, peli.getRuudukko().getKorkeus());
        assertEquals(2, peli.getRuudukko().getLeveys());
    }
    
    @Test
    public void uusiPeliNollaaPisteet() {
        Peli peli = new Peli(2,2);
        peli.setPisteet(3);
        peli.setPaivitettava(new Piirtoalusta(peli, 5));
        peli.uusiPeli();
        assertEquals(0, peli.getPisteet());
    }
}
