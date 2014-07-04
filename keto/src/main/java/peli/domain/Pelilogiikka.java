package peli.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Luokka sisältää peliruudukon ja tarjoaa metodeja sen käsittelyyn. 
 * Luokka on vastuussa esimerkiksi ruutujen liikuttamisesta haluttuun suuntaan 
 * ja ruutujen värin muuttamisesta tietyissä tilanteissa. Luokka myös palauttaa 
 * pelipisteitä kun ruudukosta saadaantyhjennettyä ruutuja.
 *
 * @author noora&mikko
 */
public class Pelilogiikka {

    private final int LEVEYS;
    private final int KORKEUS;
    private HashSet<Koordinaatit> poistettavat;
    private Koordinaatit koordinaatit;
    private ArrayList<Vari> sallitutVarit;
    private Random arpoja;
    private Peliruudukko ruudukko;

    /**
     * Konstruktori luo annettujen parametrien mukaisen ruudukon ja alustaa sen
     * ruudut tyhjiksi.
     *
     * @param leveys Kertoo kuinka monta ruutua leveä peliruudukko on
     * @param korkeus Kertoo kuinka monta ruutua korkea peliruudukko on
     */
    public Pelilogiikka(int leveys, int korkeus) {
        this.arpoja = new Random();
        this.sallitutVarit = new ArrayList();
        this.LEVEYS = leveys;
        this.KORKEUS = korkeus;

        ruudukko = new Peliruudukko(leveys, korkeus);
        //ruudut = new Ruutu[leveys][korkeus];
        koordinaatit = new Koordinaatit(0, 0);
        this.poistettavat = new HashSet<Koordinaatit>();
    }

    /**
     *
     * @return Palauttaa ruudukon leveyden ruutuina
     */
    public int getLeveys() {
        return this.LEVEYS;
    }

    /**
     *
     * @return Palauttaa ruudukon korkeuden ruutuina
     */
    public int getKorkeus() {
        return this.KORKEUS;
    }

    /**
     * Metodi palauttaa tietyissä koordinaateissa sijaitevan ruudun
     *
     * @param koordinaatit Kertoo mikä ruutu palautetaan
     * @return Palauttaa ruudun
     */
    public Ruutu getRuutu(Koordinaatit koordinaatit) {
        return ruudukko.getRuutu(koordinaatit);
        //return ruudut[koordinaatit.getX()][koordinaatit.getY()];
    }

    /**
     * Metodi asettaa annetun ruudun annettuihin koordinaatteihin
     *
     * @param ruutu Ruutu joka halutaan sijoittaa jonnekin
     * @param koordinaatit Ruudun haluttu sijainti
     */
    public void setRuutu(Ruutu ruutu, Koordinaatit koordinaatit) {
        ruudukko.setRuutu(koordinaatit, ruutu);
        //ruudut[koordinaatit.getX()][koordinaatit.getY()] = ruutu;
    }

    /**
     *
     * @return Palauttaa listan väreistä, jotka voidaan arpoa uudelle ruudulle
     */
    public ArrayList<Vari> getSallitutVarit() {
        return sallitutVarit;
    }

    /**
     * Metodi poistaa annetuissa koordinaateissa sijaitsevan ruudun eli muuttaa
     * sen värin tyhjäksi
     *
     * @param koordinaatit Kertoo mikä ruutu halutaan poistaa
     */
    public void poistaRuutu(Koordinaatit koordinaatit) {
        ruudukko.setRuutu(koordinaatit, null);
        //ruudut[koordinaatit.getX()][koordinaatit.getY()] = null;
    }

    /**
     * Metodi tarkistaa, onko ruudukossa vielä tilaa ja arpoo sitten uusia
     * ruudukon ruutuja, kunnes löytyy tyhjä ruutu. Sen jälkeen ruudulle
     * arvotaan väri
     *
     */
    public void arvoUusiRuutu() {
        if (onkoRuudukkoTaynna()) {
            return;
        }
        do {
            koordinaatit.setX(arpoja.nextInt(this.LEVEYS));
            koordinaatit.setY(arpoja.nextInt(this.KORKEUS));
        } while (ruudukko.getRuutu(koordinaatit, Suunta.YLOS) != null);
        arvoRuudunVari(koordinaatit);
    }

    /**
     * Metodi lisää uuden värin listaan, jolta arvotaan uuden ruudun väri
     *
     * @param vari Listaan lisättävä väri
     */
    public void lisaaSallittuVari(Vari vari) {
        if (!sallitutVarit.contains(vari)) {
            this.sallitutVarit.add(vari);
        }
    }

    /**
     * Metodi arpoo annetulle ruudulle värin sallittujen värien listasta
     *
     * @param ruutu Ruutu. jolle väri arvotaan
     */
    private void arvoRuudunVari(Koordinaatit koordinaatit) {
        Vari uusiVari = sallitutVarit.get(arpoja.nextInt(sallitutVarit.size()));
        ruudukko.setRuutu(koordinaatit, Suunta.YLOS, new Ruutu(uusiVari));
    }

    /**
     * Metodi käy läpi ruudukon ruudut ja tarkastaa, onko ruudukossa tyhjiä
     * ruutuja
     *
     * @return Palauttaa false, jos ruudukosta löytyy tyhjä ruutu ja true, jos
     * ruudukko on täynnä eli tyhjiä ruutuja ei ole
     */
    public boolean onkoRuudukkoTaynna() {
        for (int i = 0; i < this.KORKEUS; i++) {
            for (int j = 0; j < this.LEVEYS; j++) {
                if (ruudukko.getRuutu(i, j, Suunta.YLOS) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodi käy läpi ruudukon sarakkeet ja rivit ja tutkii onko millään niistä
     * mahdollista tehdä siirto
     *
     * @return Jos jokin siirto on mahdollinen, palautetaan true ja jos ei ole,
     * palautetaan false.
     */
    public boolean onkoSiirtoMahdollinen() {
        return onkoSiirtoMahdollinenSarakkeissa() || onkoSiirtoMahdollinenRiveilla();
    }

    /**
     * Metodi käy läpi ruudukon sarakkeet ja tutkii onko millään niistä
     * mahdollista tehdä siirto eli löytyykö mistään sarakkeesta vähintään kolme
     * samanväristä ruutua peräkkäin tai löytyykö mistään sarakkeesta peräkkäin
     * kaksi ruutua, jotka on värien puolesta mahdollista yhdistää
     *
     * @return Palauttaa true, jos edes jokin siirto on mahdollinen ja false,
     * jos mahdollisia siirtoja ei ole
     */
    private boolean onkoSiirtoMahdollinenSarakkeissa() {
        Ruutu[][] ruudut = ruudukko.getRuudut();
        Koordinaatit k = new Koordinaatit(0, 0);
        for (int i = 0; i < this.LEVEYS; i++) {
            k.setX(i);
            for (int j = 0; j < this.KORKEUS - 2; j++) {
                k.setY(j);
                if (ruudut[k.getX()][k.getY()] == null || ruudut[k.getX()][k.getY() + 1] == null || ruudut[k.getX()][k.getY() + 2] == null) {
                    return true;
                }
                if (ruudut[k.getX()][k.getY()].getVari().equals(ruudut[k.getX()][k.getY() + 1].getVari())
                        && ruudut[k.getX()][k.getY()].getVari().equals(ruudut[k.getX()][k.getY() + 2].getVari())) {
                    return true;
                } else if (!ruudut[k.getX()][k.getY()].getVari().varienYhdiste(ruudut[k.getX()][k.getY() + 1].getVari()).equals(Vari.TYHJA)
                        || !ruudut[k.getX()][k.getY() + 1].getVari().varienYhdiste(ruudut[k.getX()][k.getY() + 2].getVari()).equals(Vari.TYHJA)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodi käy läpi ruudukon rivit ja tutkii onko millään niistä mahdollista
     * tehdä siirto eli löytyykö miltään riviltä vähintään kolme samanväristä
     * ruutua peräkkäin tai löytyykö miltään riviltä peräkkäin kaksi ruutua,
     * jotka on värien puolesta mahdollista yhdistää
     *
     * @return Palauttaa true, jos edes jokin siirto on mahdollinen ja false,
     * jos mahdollisia siirtoja ei ole
     */
    private boolean onkoSiirtoMahdollinenRiveilla() {
        Ruutu[][] ruudut = ruudukko.getRuudut();

        Koordinaatit k = new Koordinaatit(0, 0);
        for (int i = 0; i < this.KORKEUS; i++) {
            k.setY(i);
            for (int j = 0; j < this.LEVEYS - 2; j++) {
                k.setX(j);
                if (ruudut[k.getX()][k.getY()].getVari().equals(ruudut[k.getX() + 1][k.getY()].getVari())
                        && ruudut[k.getX()][k.getY()].getVari().equals(ruudut[k.getX() + 2][k.getY()].getVari())) {
                    return true;
                } else if (!ruudut[k.getX()][k.getY()].getVari().varienYhdiste(ruudut[k.getX() + 1][k.getY()].getVari()).equals(Vari.TYHJA)
                        || !ruudut[k.getX() + 1][k.getY()].getVari().varienYhdiste(ruudut[k.getX() + 2][k.getY()].getVari()).equals(Vari.TYHJA)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodi liikuttaa kaikkia ruudukon ruutuja annettuun suuntaan.
     * Liikutustapa riippuu annetusta suunnasta. Lopuksi ruudukosta poistetaan
     * kaikki kolmen tai useamman peräkkäisen samanvärisen ruudun jaksot.
     *
     * @param suunta Kertoo, mihin suuntaan kaikkia ruudukon ruutuja halutaan
     * liikuttaa
     * @return Metodi palauttaa luvun, joka kertoo ruudukosta poistettujen
     * ruutujen lukumäärän
     */
    public int liikutaKaikkiRuudut(Suunta suunta) {
        liikutaKaikkiSuuntaan(suunta);
        return poistaPerakkaisetSamat();
    }

    private void liikutaKaikkiSuuntaan(Suunta suunta) {
        int laskuri = 0;
        for (int y = 1; y < ruudukko.ruudukonKorkeusAsennossa(suunta); y++) {
            for (int x = 0; x < ruudukko.ruudukonLeveysAsennossa(suunta); x++) {
                laskuri = liikutaMahdollisimmanPaljonYlosRuudukonOllessaAsennossa(suunta, x, y);
            }
        }
    }

    private int liikutaMahdollisimmanPaljonYlosRuudukonOllessaAsennossa(Suunta suunta, int x, int y) {
        if (ruudukko.getRuutu(x, y, suunta) == null) {
            return 0;
        }
        Vari ruudunVari = ruudukko.getRuutu(x, y, suunta).getVari();
        int laskuri = 0;
        while (y - 1 >= 0 && (ruudukko.getRuutu(x, y - 1, suunta) == null)) {
            ruudukko.setRuutu(x, y - 1, suunta, ruudukko.getRuutu(x, y, suunta));
            ruudukko.setRuutu(x, y, suunta, null);
            y--;
            laskuri++;
        }

        if (y - 1 >= 0) {
            Vari yhdiste = ruudukko.getRuutu(x, y - 1, suunta).getVari().varienYhdiste(ruudunVari);
            if (yhdiste != Vari.TYHJA) {
                ruudukko.setRuutu(x, y, suunta, null);
                ruudukko.setRuutu(x, y - 1, suunta, new Ruutu(yhdiste));
            }
        }

        return laskuri;
    }

    /**
     * Metodi lisää ruutuja poistettavien ruutujen listaan ja lopuksi tyhjentää
     * tämän listan.
     *
     * @return Palautetaan poistettujen ruutujen lukumäärä
     */
    private int poistaPerakkaisetSamat() {

        for (int y = 0; y < this.KORKEUS; y++) {
            for (int x = 0; x < this.LEVEYS; x++) {
                if (ruudukko.getRuutu(x, y, Suunta.YLOS) != null) {
                    poistaPerakkaiset(new Koordinaatit(x, y));
                }
            }
        }
        return tyhjennaPoistettavatRuudut();
    }

    private void poistaPerakkaiset(Koordinaatit koord) {
        int x = koord.getX();
        int y = koord.getY();
        Vari vari = ruudukko.getRuutu(x, y).getVari();
        etsi(new Koordinaatit(x, y), vari, Suunta.OIKEA, 0, 3);
        etsi(new Koordinaatit(x, y), vari, Suunta.ALAS, 0, 3);

    }

    private boolean etsi(Koordinaatit koord, Vari vari, Suunta suunta, int lkm, int tavoite) {
        if (koord.getX() >= this.LEVEYS || koord.getY() >= this.KORKEUS) {
            return false;
        }

        if (this.ruudukko.getRuutu(koord) != null && this.ruudukko.getRuutu(koord).getVari() == vari) {
            lkm++;
            Koordinaatit seuraava = koord.teeKopio();
            seuraava.liikuta(suunta);
            if (etsi(seuraava, vari, suunta, lkm, tavoite) || lkm >= tavoite) {
                this.poistettavat.add(koord.teeKopio());
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi käy läpi poistettavien ruutujen listan ja tyhjentää sen ruudut.
     * Poistettavista ruuduista saa pisteitä niiden värin perusteella
     *
     * @param poistettavatRuudut Lista poistettavista ruuduista
     * @return Palauttaa poistettujen ruutujen värin perusteella määräytyvän
     * pistemäärän
     */
    private int tyhjennaPoistettavatRuudut() {
        int pisteet = 0;
        for (Koordinaatit koord : poistettavat) {
            pisteet += ruudukko.getRuutu(koord).getVari().varinPisteet();
            ruudukko.setRuutu(koord, null);
        }
        poistettavat.removeAll(poistettavat);
        return pisteet;
    }
}
