
package peli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RuutuTest {
    
    public RuutuTest() {
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
    public void arvoRuudunVariMuuttaaRuudunVaria() {
        Ruutu ruutu = new Ruutu(Vari.TYHJA);
        ruutu.arvoRuudunVari();
        assertTrue(ruutu.getVari().equals(Vari.SININEN) || ruutu.getVari().equals(Vari.PUNAINEN));
    }
}
