
package peli.keto;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import peli.domain.Koordinaatit;
import peli.domain.Ruutu;
import peli.domain.Suunta;
import peli.domain.Vari;
import peli.gui.Piirtoalusta;

public class PeliTest {
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void setPisteetAsettaaPisteetOikein() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(3);
        assertEquals(3, peli.getPisteet());
    }
    
    @Test
    public void getPisteetAntaaPisteetOikein() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(3);
        assertEquals(3, peli.getPisteet());
    }
    
    @Test
    public void getRuudukkoPalauttaaOikeanKokoisenRuudukon() {
        Peli peli = new Peli(2,2, "testituloslista");
        assertEquals(2, peli.getRuudukko().getKorkeus());
        assertEquals(2, peli.getRuudukko().getLeveys());
    }
    
    @Test
    public void uusiPeliNollaaPisteet() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(3);
        peli.setPaivitettava(new Piirtoalusta(peli, 5));
        peli.uusiPeli("moi");
        assertEquals(0, peli.getPisteet());
    }
    
    @Test
    public void onkoPeliPaattynytToimiiTyhjallaRuudukolla() {
        Peli peli = new Peli(2,2, "testituloslista");
        
        assertEquals(false, peli.onkoPeliPaattynyt());
    }
    
    @Test
    public void onkoPeliPaattynytToimiiKunTehtyYksiSiirto() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.siirto(Suunta.YLOS);
        assertEquals(false, peli.onkoPeliPaattynyt());
    }
    
    @Test
    public void onkoPeliPaattynytToimiiKunTehtyAlleRuudukonRuutujenVerranSiirtoja() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.siirto(Suunta.YLOS);
        peli.siirto(Suunta.YLOS);
        peli.siirto(Suunta.YLOS);
        assertEquals(false, peli.onkoPeliPaattynyt());
    }
    
//    @Test
//    public void onkoPeliPaattynytToimiiKunRuudukkoOnTaynna() {
//        Peli peli = new Peli(2,2, "testituloslista");
//        peli.getRuudukko().setRuutu(new Ruutu(Vari.KELTAINEN), new Koordinaatit(0,0));
//        peli.getRuudukko().setRuutu(new Ruutu(Vari.KELTAINEN), new Koordinaatit(0,1));
//        peli.getRuudukko().setRuutu(new Ruutu(Vari.KELTAINEN), new Koordinaatit(1,0));
//        peli.getRuudukko().setRuutu(new Ruutu(Vari.KELTAINEN), new Koordinaatit(1,1));
//        assertEquals(true, peli.onkoPeliPaattynyt());
//    }
    
    @Test
    public void lisaaTarvittaessaSallittuVariToimiiKunPisteitaYliViisikymmenta() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(51);
        peli.siirto(Suunta.YLOS);
        assertEquals(3, peli.getRuudukko().getSallitutVarit().size());
    }
    
    @Test
    public void lisaaTarvittaessaSallittuVariToimiiKunPisteitaAlleViisikymmenta() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(49);
        peli.siirto(Suunta.YLOS);
        assertEquals(2, peli.getRuudukko().getSallitutVarit().size());
    }
    
    @Test
    public void lisaaTarvittaessaSallittuVariToimiiKunPisteitaViisikymmenta() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(50);
        peli.siirto(Suunta.YLOS);
        assertEquals(2, peli.getRuudukko().getSallitutVarit().size());
    }
    
    @Test
    public void lisaaTarvittaessaSallittuVariToimiiKunPisteitaYliSata() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(101);
        peli.siirto(Suunta.YLOS);
        assertEquals(4, peli.getRuudukko().getSallitutVarit().size());
    }
    
    @Test
    public void lisaaTarvittaessaSallittuVariToimiiKunPisteitaSata() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.setPisteet(100);
        peli.siirto(Suunta.YLOS);
        assertEquals(3, peli.getRuudukko().getSallitutVarit().size());
    }
    
    @Test
    public void siirtoEiKasvataPisteitaJosPelaajaEiSaaPisteita() {
        Peli peli = new Peli(2,2, "testituloslista");
        peli.siirto(Suunta.YLOS);
        assertEquals(0, peli.getPisteet());
    }
    
    @Test
    public void siirtoKasvattaaPisteitaJosPelaajaSaaPisteita() {
        Peli peli = new Peli(3,3, "testituloslista");
        peli.getRuudukko().setRuutu(new Ruutu(Vari.KELTAINEN), new Koordinaatit(0,0));
        peli.getRuudukko().setRuutu(new Ruutu(Vari.KELTAINEN), new Koordinaatit(1,0));
        peli.getRuudukko().setRuutu(new Ruutu(Vari.KELTAINEN), new Koordinaatit(2,0));
        peli.siirto(Suunta.OIKEA);
        assertEquals(3, peli.getPisteet());
    }
}
