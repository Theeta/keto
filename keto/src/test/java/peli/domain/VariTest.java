
package peli.domain;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VariTest {
    
    public VariTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void punainenPalauttaaOikeanVarin() {
        assertEquals(Color.RED, Vari.PUNAINEN.varinVari());
    }
    
    @Test
    public void sininenPalauttaaOikeanVarin() {
        assertEquals(Color.BLUE, Vari.SININEN.varinVari());
    }
    @Test
    public void tyhjaPalauttaaOikeanVarin() {
        assertEquals(Color.WHITE, Vari.TYHJA.varinVari());
    }
    @Test
    public void liilaPalauttaaOikeanVarin() {
        assertEquals(Color.GRAY, Vari.LIILA.varinVari());
    }
}
