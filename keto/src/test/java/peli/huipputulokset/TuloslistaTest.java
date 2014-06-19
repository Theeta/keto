
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
    public void getListaPalauttaaTyhjänListanKunListaOnTyhjennetty() {
        Tuloslista lista = new Tuloslista(5, "testilista");
        lista.tyhjennaLista();
        assertEquals(0, lista.getLista().size());
    }
    
    @Test
    public void lisaaListalleLisääUudenTuloksenTyhjäänListaan() {
        Tuloslista lista = new Tuloslista(5, "testilista");
        lista.tyhjennaLista();
        lista.lisaaListalle("Matti", 5);
        assertEquals(1, lista.getLista().size());
    }
    
    @Test
    public void lisaaListalleEiLisääLiikaaUusiaTuloksiaTyhjäänListaan() {
        Tuloslista lista = new Tuloslista(5, "testilista");
        lista.tyhjennaLista();
        lista.lisaaListalle("Matti", 1);
        lista.lisaaListalle("Matti", 2);
        lista.lisaaListalle("Matti", 3);
        lista.lisaaListalle("Matti", 4);
        lista.lisaaListalle("Matti", 5);
        lista.lisaaListalle("Matti", 6);
        lista.lisaaListalle("Matti", 7);
        assertEquals(5, lista.getLista().size());
    }
}
