
package peli.huipputulokset;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TuloslistaTest {
    
    public TuloslistaTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void getListaPalauttaaTyhjänListan() {
        Tuloslista lista = new Tuloslista(5, "testilista");
        assertEquals(0, lista.getLista().size());
    }
}
