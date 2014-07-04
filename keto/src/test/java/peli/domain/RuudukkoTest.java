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
        Pelilogiikka ruudukko = new Pelilogiikka(2, 3);
        assertEquals(2, ruudukko.getLeveys());
    }

    @Test
    public void getKorkeusPalauttaaRuudukonKorkeuden() {
        Pelilogiikka ruudukko = new Pelilogiikka(2, 3);
        assertEquals(3, ruudukko.getKorkeus());
    }

    @Test
    public void getRuutuPalauttaaHalutussaPaikassaOlevanRuudun() {
        Pelilogiikka ruudukko = new Pelilogiikka(2, 2);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(1, 1);
        ruudukko.setRuutu(ruutu, koordinaatit);
        assertEquals(ruutu, ruudukko.getRuutu(koordinaatit));
    }

    @Test
    public void setRuutuAsettaaAnnetunRuudunHaluttuunPaikkaan() {
        Pelilogiikka ruudukko = new Pelilogiikka(2, 2);
        Ruutu ruutu = new Ruutu(Vari.SININEN);
        Koordinaatit koordinaatit = new Koordinaatit(1, 1);
        ruudukko.setRuutu(ruutu, koordinaatit);
        assertEquals(ruutu, ruudukko.getRuutu(koordinaatit));
    }

    @Test
    public void poistaRuutuMuuttaaAnnetunRuudunTyhjaksi() {
        Pelilogiikka ruudukko = new Pelilogiikka(2, 2);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(1, 1);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.poistaRuutu(koordinaatit);
        assertNull(ruudukko.getRuutu(koordinaatit));
    }

    @Test
    public void liikutaKaikkiRuudutAlasLiikuttaaYhdenRuudunAlas() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(0, 0);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(0, 2);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutAlasLiikuttaaKaksiPaallekkaistaRuutuaAlas() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        Koordinaatit koordinaatit1 = new Koordinaatit(0, 0);
        Koordinaatit koordinaatit2 = new Koordinaatit(0, 1);
        Koordinaatit loppukoordinaatit1 = new Koordinaatit(0, 1);
        Koordinaatit loppukoordinaatit2 = new Koordinaatit(0, 2);
        ruudukko.setRuutu(ruutu, koordinaatit1);
        ruudukko.setRuutu(ruutu2, koordinaatit2);
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertNull(ruudukko.getRuutu(loppukoordinaatit1));
        assertEquals(Vari.LIILA, ruudukko.getRuutu(loppukoordinaatit2).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutYlosLiikuttaaYhdenRuudunYlos() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(0, 2);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(0, 0);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.YLOS);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutYlosLiikuttaaKaksiPaallekkaistaRuutuaYlos() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        assertNull(ruudukko.getRuutu(loppukoordinaatit2));
    }

    @Test
    public void liikutaKaikkiRuudutVasenLiikuttaaYhdenRuudunVasemmalle() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(2, 0);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(0, 0);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.VASEN);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutVasenLiikuttaaKaksiPaallekkaistaRuutuaVasemmalle() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(1, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(2, 0));
        ruudukko.liikutaKaikkiRuudut(Suunta.VASEN);
        assertEquals(Vari.LIILA, ruudukko.getRuutu(new Koordinaatit(0, 0)).getVari());
        assertNull(ruudukko.getRuutu(new Koordinaatit(1, 0)));
    }

    @Test
    public void liikutaKaikkiRuudutOikeaLiikuttaaYhdenRuudunOikealle() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Koordinaatit koordinaatit = new Koordinaatit(0, 0);
        Koordinaatit loppuKoordinaatit = new Koordinaatit(2, 0);
        ruudukko.setRuutu(ruutu, koordinaatit);
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertEquals(Vari.PUNAINEN, ruudukko.getRuutu(loppuKoordinaatit).getVari());
    }

    @Test
    public void liikutaKaikkiRuudutOikeaLiikuttaaKaksiPaallekkaistaRuutuaOikealle() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 0));
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertNull(ruudukko.getRuutu(new Koordinaatit(1, 0)));
        assertEquals(Vari.LIILA, ruudukko.getRuutu(new Koordinaatit(2, 0)).getVari());
    }

    @Test
    public void liikutaNiinEttaKolmeSamaaSarakkeessa() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu3 = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(0, 1));
        ruudukko.setRuutu(ruutu3, new Koordinaatit(1, 2));
        ruudukko.liikutaKaikkiRuudut(Suunta.OIKEA);
        assertNull(ruudukko.getRuutu(new Koordinaatit(2, 0)));
        assertNull(ruudukko.getRuutu(new Koordinaatit(2, 1)));
        assertNull(ruudukko.getRuutu(new Koordinaatit(2, 2)));
    }

    @Test
    public void liikutaNiinEttaKolmeEriaSarakkeessa() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
        Ruutu ruutu = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu2 = new Ruutu(Vari.PUNAINEN);
        Ruutu ruutu3 = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(ruutu, new Koordinaatit(0, 0));
        ruudukko.setRuutu(ruutu2, new Koordinaatit(1, 0));
        ruudukko.setRuutu(ruutu3, new Koordinaatit(2, 1));
        ruudukko.liikutaKaikkiRuudut(Suunta.ALAS);
        assertNull(ruudukko.getRuutu(new Koordinaatit(0, 2)));
        assertNull(ruudukko.getRuutu(new Koordinaatit(1, 2)));
        assertNull(ruudukko.getRuutu(new Koordinaatit(2, 2)));
    }

    @Test
    public void liikutaNiinEttaKolmeEriaRivilla() {
        Pelilogiikka ruudukko = new Pelilogiikka(3, 3);
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
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        assertEquals(1, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void lisaaSallittuvariEiLisaaSamaaVariaListaan() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        assertEquals(1, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void lisaaSallittuvariLisaaUseampiaVarejaListaan() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.lisaaSallittuVari(Vari.SININEN);
        assertEquals(2, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void sallittujenVarienListaOnTyhjaJosVarejaEiOleLisatty() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        assertEquals(0, ruudukko.getSallitutVarit().size());
    }
    
    @Test
    public void arvoUusiRuutuArpooTyhjaanRuudukkoonSallitunVarisenRuudun() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.arvoUusiRuutu();
        Koordinaatit koordinaatit = new Koordinaatit(0,0);
        boolean loytyy = false;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                if (ruudukko.getRuutu(koordinaatit) != null && ruudukko.getRuutu(koordinaatit).getVari().equals(Vari.PUNAINEN)){
                    loytyy = true;
                }
            }
        }
        assertTrue(loytyy);
    }
    
    @Test
    public void arvoUusiRuutuArpooUseampiaRuutujaSamaanRuudukkoon() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        ruudukko.arvoUusiRuutu();
        ruudukko.arvoUusiRuutu();
        Koordinaatit koordinaatit = new Koordinaatit(0,0);
        int arvottujaRuutuja = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                if (ruudukko.getRuutu(koordinaatit) != null && ruudukko.getRuutu(koordinaatit).getVari().equals(Vari.PUNAINEN)){
                    arvottujaRuutuja++;
                }
            }
        }
        assertEquals(2, arvottujaRuutuja);
    }
    
    @Test
    public void onkoRuudukkoTaynnaToimiiKunRuudukkoEiOleTaynna() {
        Pelilogiikka ruudukko = new Pelilogiikka(2,2);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        for (int i=0; i<3; i++){
            ruudukko.arvoUusiRuutu();
        }
        assertEquals(false, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void onkoRuudukkoTaynnaToimiiKunRuudukkoOnTaynna() {
        Pelilogiikka ruudukko = new Pelilogiikka(2,2);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        for (int i=0; i<5; i++){
            ruudukko.arvoUusiRuutu();
        }
        assertEquals(true, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void onkoRuudukkoTaynnaToimiiKunRuudukkoOnTyhja() {
        Pelilogiikka ruudukko = new Pelilogiikka(2,2);
        ruudukko.lisaaSallittuVari(Vari.PUNAINEN);
        assertEquals(false, ruudukko.onkoRuudukkoTaynna());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoOnMahdollinenRivillaYhdistamisenTakia() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        Ruutu pr = new Ruutu(Vari.PUNAINEN);
        Ruutu sr = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(pr, new Koordinaatit(0,0));
        ruudukko.setRuutu(sr, new Koordinaatit(1,0));
        ruudukko.setRuutu(sr, new Koordinaatit(2,0));
        assertEquals(true, ruudukko.onkoSiirtoMahdollinen());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoOnMahdollinenSarakkeessaYhdistamisenTakia() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        Ruutu pr = new Ruutu(Vari.PUNAINEN);
        Ruutu sr = new Ruutu(Vari.SININEN);
        ruudukko.setRuutu(pr, new Koordinaatit(0,0));
        ruudukko.setRuutu(sr, new Koordinaatit(0,1));
        ruudukko.setRuutu(sr, new Koordinaatit(0,2));
        assertEquals(true, ruudukko.onkoSiirtoMahdollinen());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoOnMahdollinenRivillaPoistonTakia() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        Ruutu pr = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(pr, new Koordinaatit(0,0));
        ruudukko.setRuutu(pr, new Koordinaatit(1,0));
        ruudukko.setRuutu(pr, new Koordinaatit(2,0));
        assertEquals(true, ruudukko.onkoSiirtoMahdollinen());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoOnMahdollinenSarakkeessaPoistonTakia() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
        Ruutu pr = new Ruutu(Vari.PUNAINEN);
        ruudukko.setRuutu(pr, new Koordinaatit(0,0));
        ruudukko.setRuutu(pr, new Koordinaatit(0,1));
        ruudukko.setRuutu(pr, new Koordinaatit(0,2));
        assertEquals(true, ruudukko.onkoSiirtoMahdollinen());
    }
    
    @Test
    public void onkoSiirtoMahdollinenToimiiKunSiirtoEiOleMahdollinen() {
        Pelilogiikka ruudukko = new Pelilogiikka(3,3);
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
