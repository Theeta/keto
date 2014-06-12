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
    public void getLeveysPalauttaaRuudukonLeveyden() {
        Ruudukko ruudukko = new Ruudukko(2, 3);
        assertEquals(2, ruudukko.getLeveys());
    }

    @Test
    public void getKorkeusPalauttaaRuudukonKorkeuden() {
        Ruudukko ruudukko = new Ruudukko(2, 3);
        assertEquals(3, ruudukko.getKorkeus());
    }

    @Test
    public void getRuutuPalauttaaHalutussaPaikassaOlevanRuudun() {
        Ruudukko ruudukko = new Ruudukko(2, 2);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(1, 1);
        ruudukko.setRuutu(ruutu, koordinaatit);
        assertEquals(ruutu, ruudukko.getRuutu(koordinaatit));
    }

    @Test
    public void setRuutuAsettaaAnnetunRuudunHaluttuunPaikkaan() {
        Ruudukko ruudukko = new Ruudukko(2, 2);
        Ruutu ruutu = new Ruutu(Vari.SININEN);
        Koordinaatit koordinaatit = new Koordinaatit(1, 1);
        ruudukko.setRuutu(ruutu, koordinaatit);
        assertEquals(ruutu, ruudukko.getRuutu(koordinaatit));
    }

    @Test
    public void poistaRuutuMuuttaaAnnetunRuudunTyhjaksi() {
        Ruudukko ruudukko = new Ruudukko(2, 2);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(1, 1);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.poistaRuutu(koordinaatit);
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(koordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutAlasLiikuttaaYhdenRuudunAlas() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(0, 0);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(0, 2);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutAlasLiikuttaaKaksiPaallekkaistaRuutuaAlas() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.LIILA);
        Koordinaatit koordinaatit1 = new Koordinaatit(0, 0);
        Koordinaatit koordinaatit2 = new Koordinaatit(0, 1);
        Koordinaatit loppukoordinaatit1 = new Koordinaatit(0, 1);
        Koordinaatit loppukoordinaatit2 = new Koordinaatit(0, 2);
        ruudukko.setRuutu(ruutu, koordinaatit1);
        ruudukko.setRuutu(ruutu2, koordinaatit2);
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppukoordinaatit1).getVari());
        assertEquals(Vari.LIILA, ruudukko.getRuutu(loppukoordinaatit2).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutAlasLiikuttaaKaksiVierekkaistaRuutuaAlas() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 0));
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(0, 2)).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(new Koordinaatit(1, 2)).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutAlasLiikuttaaKaksiPaallekkaistaRuutuaAlasJaYhdistaaNe() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        Koordinaatit koordinaatit1 = new Koordinaatit(0, 0);
        Koordinaatit koordinaatit2 = new Koordinaatit(0, 1);
        Koordinaatit loppukoordinaatit1 = new Koordinaatit(0, 1);
        Koordinaatit loppukoordinaatit2 = new Koordinaatit(0, 2);
        ruudukko.setRuutu(ruutu, koordinaatit1);
        ruudukko.setRuutu(ruutu2, koordinaatit2);
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(loppukoordinaatit1).getVari());
        assertEquals(Vari.LIILA, ruudukko.getRuutu(loppukoordinaatit2).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutYlosLiikuttaaYhdenRuudunYlos() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(0, 2);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(0, 0);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.YLOS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutYlosLiikuttaaKaksiPaallekkaistaRuutuaYlos() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.LIILA);
        Koordinaatit koordinaatit1 = new Koordinaatit(0, 1);
        Koordinaatit koordinaatit2 = new Koordinaatit(0, 2);
        Koordinaatit loppukoordinaatit1 = new Koordinaatit(0, 0);
        Koordinaatit loppukoordinaatit2 = new Koordinaatit(0, 1);
        ruudukko.setRuutu(ruutu, koordinaatit1);
        ruudukko.setRuutu(ruutu2, koordinaatit2);
        ruudukko.liikutaKaikkiRuudut(Suunta.YLOS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppukoordinaatit1).getVari());
        assertEquals(Vari.LIILA, ruudukko.getRuutu(loppukoordinaatit2).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutYlosLiikuttaaKaksiVierekkaistaRuutuaYlos() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 2));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 2));
        ruudukko.liikutaKaikkiRuudut(Suunta.YLOS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(0, 0)).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(new Koordinaatit(1, 0)).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutYlosLiikuttaaKaksiPaallekkaistaRuutuaYlosJaYhdistaaNe() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        Koordinaatit koordinaatit1 = new Koordinaatit(0, 1);
        Koordinaatit koordinaatit2 = new Koordinaatit(0, 2);
        Koordinaatit loppukoordinaatit1 = new Koordinaatit(0, 0);
        Koordinaatit loppukoordinaatit2 = new Koordinaatit(0, 1);
        ruudukko.setRuutu(ruutu, koordinaatit1);
        ruudukko.setRuutu(ruutu2, koordinaatit2);
        ruudukko.liikutaKaikkiRuudut(Suunta.YLOS);
        assertEquals(Vari.LIILA, ruudukko.getRuutu(loppukoordinaatit1).getVari());
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(loppukoordinaatit2).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutVasenLiikuttaaYhdenRuudunVasemmalle() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(2, 0);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(0, 0);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.VASEN);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutVasenLiikuttaaKaksiPaallekkaistaRuutuaVasemmalle() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        Koordinaatit koordinaatit1 = new Koordinaatit(2, 0);
        Koordinaatit koordinaatit2 = new Koordinaatit(2, 1);
        Koordinaatit loppukoordinaatit1 = new Koordinaatit(0, 0);
        Koordinaatit loppukoordinaatit2 = new Koordinaatit(0, 1);
        ruudukko.setRuutu(ruutu, koordinaatit1);
        ruudukko.setRuutu(ruutu2, koordinaatit2);
        ruudukko.liikutaKaikkiRuudut(Suunta.VASEN);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppukoordinaatit1).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(loppukoordinaatit2).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutVasenLiikuttaaKaksiVierekkaistaRuutuaVasemmalle() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.LIILA);
        ruudukko.setRuutu(ruutu, new Koordinaatit(1, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(2, 0));
        ruudukko.liikutaKaikkiRuudut(Suunta.VASEN);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(0, 0)).getVari());
        assertEquals(Vari.LIILA, ruudukko.getRuutu(new Koordinaatit(1, 0)).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutVasenLiikuttaaKaksiVierekkaistaRuutuaVasemmalleJaYhdistaaNe() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(1, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(2, 0));
        ruudukko.liikutaKaikkiRuudut(Suunta.VASEN);
        assertEquals(Vari.LIILA, ruudukko.getRuutu(new Koordinaatit(0, 0)).getVari());
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(1, 0)).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutOikeaLiikuttaaYhdenRuudunOikealle() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(0, 0);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(2, 0);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutOikeaLiikuttaaKaksiPaallekkaistaRuutuaOikealle() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        Koordinaatit koordinaatit1 = new Koordinaatit(0, 0);
        Koordinaatit koordinaatit2 = new Koordinaatit(0, 1);
        Koordinaatit loppukoordinaatit1 = new Koordinaatit(2, 0);
        Koordinaatit loppukoordinaatit2 = new Koordinaatit(2, 1);
        ruudukko.setRuutu(ruutu, koordinaatit1);
        ruudukko.setRuutu(ruutu2, koordinaatit2);
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppukoordinaatit1).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(loppukoordinaatit2).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutOikeaLiikuttaaKaksiVierekkaistaRuutuaOikealle() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.LIILA);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 0));
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(1, 0)).getVari());
        assertEquals(Vari.LIILA, ruudukko.getRuutu(new Koordinaatit(2, 0)).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutOikeaLiikuttaaKaksiVierekkaistaRuutuaOikealleJaYhdistaaNe() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 0));
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(1, 0)).getVari());
        assertEquals(Vari.LIILA, ruudukko.getRuutu(new Koordinaatit(2, 0)).getVari());
    }

    @Test
    public void liikutaNiinEttaKolmeSamaaSarakkeessa() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu3 = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(0, 1));
        ruudukko.setRuutu(ruutu3, new Koordinaatit(1, 2));
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(2, 0)).getVari());
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(2, 1)).getVari());
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(2, 2)).getVari());
    }

    @Test
    public void liikutaNiinEttaKolmeEriaSarakkeessa() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        Ruutu ruutu3 = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(0, 1));
        ruudukko.setRuutu(ruutu3, new Koordinaatit(1, 2));
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(2, 0)).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(new Koordinaatit(2, 1)).getVari());
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(2, 2)).getVari());
    }

    @Test
    public void liikutaNiinEttaKolmeSamaaRivilla() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu3 = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 0));
        ruudukko.setRuutu(ruutu3, new Koordinaatit(2, 1));
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(0, 2)).getVari());
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(1, 2)).getVari());
        assertEquals(Vari.TYHJA, ruudukko.getRuutu(new Koordinaatit(2, 2)).getVari());
    }

    @Test
    public void liikutaNiinEttaKolmeEriaRivilla() {
        Ruudukko ruudukko = new Ruudukko(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        Ruutu ruutu3 = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 0));
        ruudukko.setRuutu(ruutu3, new Koordinaatit(2, 1));
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(0, 2)).getVari());
        assertEquals(Vari.SININEN, ruudukko.getRuutu(new Koordinaatit(1, 2)).getVari());
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(new Koordinaatit(2, 2)).getVari());
    }
    
    @Test
    public void lisaaSallittuvariLisaaVarinListaan() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        assertEquals(1, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void lisaaSallittuvariEiLisaaSamaaVariaListaan() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        assertEquals(1, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void lisaaSallittuvariLisaaUseampiaVarejaListaan() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.lisaaSallittuVari(Vari.SININEN);
        assertEquals(2, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void sallittujenVarienListaOnTyhjaJosVarejaEiOleLisatty() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        assertEquals(0, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void arvoUusiRuutuArpooTyhjaanRuudukkoonSallitunVarisenRuudun() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.arvoUusiRuutu();
        Koordinaatit koordinaatit = new Koordinaatit(0,0);
        boolean loytyy = false;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                if (ruudukko.getRuutu(koordinaatit).getVari().equals(Vari.PUNAINEN)){
                    loytyy = true;
                }
            }
        }
        assertTrue(loytyy);
    }
    
    @Test
    public void arvoUusiRuutuArpooUseampiaRuutujaSamaanRuudukkoon() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.arvoUusiRuutu();
        ruudukko.arvoUusiRuutu();
        Koordinaatit koordinaatit = new Koordinaatit(0,0);
        int arvottujaRuutuja = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                if (ruudukko.getRuutu(koordinaatit).getVari().equals(Vari.PUNAINEN)){
                    arvottujaRuutuja++;
                }
            }
        }
        assertEquals(2, arvottujaRuutuja);
    }
    
    @Test
    public void onkoRuudukkoTaynnaToimiiKunRuudukkoEiOleTaynna() {
        Ruudukko ruudukko = new Ruudukko(2,2);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        for (int i=0; i<3; i++){
            ruudukko.arvoUusiRuutu();
        }
        assertEquals(false, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void onkoRuudukkoTaynnaToimiiKunRuudukkoOnTaynna() {
        Ruudukko ruudukko = new Ruudukko(2,2);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        for (int i=0; i<5; i++){
            ruudukko.arvoUusiRuutu();
        }
        assertEquals(true, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void onkoRuudukkoTaynnaToimiiKunRuudukkoOnTyhja() {
        Ruudukko ruudukko = new Ruudukko(2,2);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        assertEquals(false, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoOnMahdollinenRivilla() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        Ruutu pr = new Ruutu(Vari.PUNAINEN);
        Ruutu sr = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(pr, new Koordinaatit(0,0));
        ruudukko.setRuutu(sr, new Koordinaatit(1,0));
        ruudukko.setRuutu(sr, new Koordinaatit(2,0));
        assertEquals(true, ruudukko.onkoSiirtoMahdollinen());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoOnMahdollinenSarakkeessa() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        Ruutu pr = new Ruutu(Vari.PUNAINEN);
        Ruutu sr = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(pr, new Koordinaatit(0,0));
        ruudukko.setRuutu(sr, new Koordinaatit(0,1));
        ruudukko.setRuutu(sr, new Koordinaatit(0,2));
        assertEquals(true, ruudukko.onkoSiirtoMahdollinen());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoEiOleMahdollinen() {
        Ruudukko ruudukko = new Ruudukko(3,3);
        Ruutu lr = new Ruutu(Vari.LIILA);
        Ruutu sr = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(lr, new Koordinaatit(0,0));
        ruudukko.setRuutu(sr, new Koordinaatit(0,1));
        ruudukko.setRuutu(lr, new Koordinaatit(0,2));
        ruudukko.setRuutu(sr, new Koordinaatit(1,0));
        ruudukko.setRuutu(lr, new Koordinaatit(1,1));
        ruudukko.setRuutu(sr, new Koordinaatit(1,2));
        ruudukko.setRuutu(lr, new Koordinaatit(2,0));
        ruudukko.setRuutu(sr, new Koordinaatit(2,1));
        ruudukko.setRuutu(lr, new Koordinaatit(2,2));
        assertEquals(false, ruudukko.onkoSiirtoMahdollinen());
    }
}
