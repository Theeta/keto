
package peli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuudukkoTest {
    
    public RuudukkoTest() {
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
    public void arvoUusiRuutuLisaaTyhjaanRuudukkoonVarillisenRuudun() {
        Ruudukko ruudukko = new Ruudukko(2,2);
        ruudukko.arvoUusiRuutu();
        boolean loytyy = false;
        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                if (ruudukko.getRuutu(j, i).getVari().equals(Vari.PUNAINEN) || ruudukko.getRuutu(j, i).getVari().equals(Vari.SININEN)){
                    loytyy = true;
                }
            }
        }
        assertEquals(true, loytyy);
    }
    
    @Test
    public void ruudukkoEiOleTaynnaJosOnArvottuVahemmanRuutujaKunRuudukossaOn() {
        Ruudukko ruudukko = new Ruudukko(2,2);
        ruudukko.arvoUusiRuutu();
        ruudukko.arvoUusiRuutu();
        assertEquals(false, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void ruudukkoOnTaynnaJosSiihenArvottuYhtaMontaRuutuaKuinOnRuudukossa() {
        Ruudukko ruudukko = new Ruudukko(2,2);
        ruudukko.arvoUusiRuutu();
        ruudukko.arvoUusiRuutu();
        ruudukko.arvoUusiRuutu();
        ruudukko.arvoUusiRuutu();
        assertEquals(true, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void liikutaRuutujaAlasLiikuttaaYhdenRuudunAlas() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(ruutu, 0, 0);
        ruudukko.liikutaRuutujaAlas();
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(0, 2).getVari());
    }
    
    @Test
    public void liikutaRuutujaAlasLiikuttaaKaksiPaallekkaistaRuutuaAlas() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, 0, 0);
        ruudukko.setRuutu(ruutu2, 0, 1);
        ruudukko.liikutaRuutujaAlas();
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(0, 1).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(0, 2).getVari());
    }
    
    @Test
    public void liikutaRuutujaAlasLiikuttaaKaksiVierekkaistaRuutuaAlas() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, 0, 0);
        ruudukko.setRuutu(ruutu2, 1, 0);
        ruudukko.liikutaRuutujaAlas();
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(0, 2).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(1, 2).getVari());
    }

}
