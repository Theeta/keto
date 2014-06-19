package peli.domain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka sisältää tiedon peliruudukon ruutujen sisällöstä sekä tarjoaa metodeja
 * peliruudukon käsittelyyn. Luokka on vastuussa esimerkiksi ruutujen
 * liikuttamisesta haluttuun suuntaan ja ruutujen värin muuttamisesta tietyissä
 * tilanteissa. Luokka myös palauttaa pelipisteteitä kun ruudukosta saadaan
 * tyhjennettyä ruutuja.
 *
 * @author noora
 */
public class Ruudukko {

    private final Ruutu[][] ruudut;
    private final int LEVEYS;
    private final int KORKEUS;
    private Koordinaatit koordinaatit;
    private ArrayList<Vari> sallitutVarit;
    private Random arpoja;

    /**
     * Konstruktori luo annettujen parametrien mukaisen ruudukon ja alustaa sen
     * ruudut tyhjiksi.
     *
     * @param leveys Kertoo kuinka monta ruutua leveä peliruudukko on
     * @param korkeus Kertoo kuinka monta ruutua korkea peliruudukko on
     */
    public Ruudukko(int leveys, int korkeus) {
        this.arpoja = new Random();
        this.sallitutVarit = new ArrayList();
        this.LEVEYS = leveys;
        this.KORKEUS = korkeus;
        ruudut = new Ruutu[leveys][korkeus];
        koordinaatit = new Koordinaatit(0, 0);

        for (int i = 0; i < this.KORKEUS; i++) {
            for (int j = 0; j < this.LEVEYS; j++) {
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                ruudut[koordinaatit.getX()][koordinaatit.getY()] = new Ruutu(Vari.TYHJA);
            }
        }
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
        return ruudut[koordinaatit.getX()][koordinaatit.getY()];
    }

    /**
     * Metodi asettaa annetun ruudun annettuihin koordinaatteihin
     *
     * @param ruutu Ruutu joka halutaan sijoittaa jonnekin
     * @param koordinaatit Ruudun haluttu sijainti
     */
    public void setRuutu(Ruutu ruutu, Koordinaatit koordinaatit) {
        ruudut[koordinaatit.getX()][koordinaatit.getY()] = ruutu;
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
        Ruutu ruutu = ruudut[koordinaatit.getX()][koordinaatit.getY()];
        ruutu.setVari(Vari.TYHJA);
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
        } while (!ruudut[koordinaatit.getX()][koordinaatit.getY()].getVari().equals(Vari.TYHJA));
        arvoRuudunVari(ruudut[koordinaatit.getX()][koordinaatit.getY()]);
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
    private void arvoRuudunVari(Ruutu ruutu) {
        ruutu.setVari(sallitutVarit.get(arpoja.nextInt(sallitutVarit.size())));
    }

    /**
     * Metodi käy läpi ruudukon ruudut ja tarkastaa, onko ruudukossa tyhjiä
     * ruutuja
     *
     * @return Palauttaa false, jos ruudukosta löytyy tyhjä ruutu ja true, jos
     * ruudukko on täynnä eli tyhjiä ruutuja ei ole
     */
    public boolean onkoRuudukkoTaynna() {
        koordinaatit = new Koordinaatit(0, 0);
        for (int i = 0; i < this.KORKEUS; i++) {
            for (int j = 0; j < this.LEVEYS; j++) {
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                if (ruudut[koordinaatit.getX()][koordinaatit.getY()].getVari().equals(Vari.TYHJA)) {
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
        if (onkoSiirtoMahdollinenSarakkeissa()) {
            return true;
        }
        return onkoSiirtoMahdollinenRiveilla();
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
        Koordinaatit k = new Koordinaatit(0, 0);
        for (int i = 0; i < this.LEVEYS; i++) {
            k.setX(i);
            for (int j = 0; j < this.KORKEUS - 2; j++) {
                k.setY(j);
                if (this.ruudut[k.getX()][k.getY()].getVari().equals(this.ruudut[k.getX()][k.getY() + 1].getVari())
                        && this.ruudut[k.getX()][k.getY()].getVari().equals(this.ruudut[k.getX()][k.getY() + 2].getVari())) {
                    return true;
                } else if (!this.ruudut[k.getX()][k.getY()].getVari().varienYhdiste(this.ruudut[k.getX()][k.getY() + 1].getVari()).equals(Vari.TYHJA)
                        || !this.ruudut[k.getX()][k.getY() + 1].getVari().varienYhdiste(this.ruudut[k.getX()][k.getY() + 2].getVari()).equals(Vari.TYHJA)) {
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
        Koordinaatit k = new Koordinaatit(0, 0);
        for (int i = 0; i < this.KORKEUS; i++) {
            k.setY(i);
            for (int j = 0; j < this.LEVEYS - 2; j++) {
                k.setX(j);
                if (this.ruudut[k.getX()][k.getY()].getVari().equals(this.ruudut[k.getX() + 1][k.getY()].getVari())
                        && this.ruudut[k.getX()][k.getY()].getVari().equals(this.ruudut[k.getX() + 2][k.getY()].getVari())) {
                    return true;
                } else if (!this.ruudut[k.getX()][k.getY()].getVari().varienYhdiste(this.ruudut[k.getX() + 1][k.getY()].getVari()).equals(Vari.TYHJA)
                        || !this.ruudut[k.getX() + 1][k.getY()].getVari().varienYhdiste(this.ruudut[k.getX() + 2][k.getY()].getVari()).equals(Vari.TYHJA)) {
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
        koordinaatit = new Koordinaatit(0, 0);
        if (suunta.equals(Suunta.ALAS) || suunta.equals(Suunta.YLOS)) {
            for (int i = 0; i < this.LEVEYS; i++) {
                koordinaatit.setX(i);
                liikutaYlosTaiAlas(suunta, koordinaatit);
            }
        } else {
            for (int i = 0; i < this.KORKEUS; i++) {
                koordinaatit.setY(i);
                liikutaOikeaTaiVasen(suunta, koordinaatit);
            }
        }
        return poistaPerakkaisetSamat();
    }

    /**
     * Metodi liikuttaa ruudukon ruutuja ylös tai alas annetun suunnan
     * mukaisesti
     *
     * @param suunta Kertoo liikutetaanko ruutuja ylös vai alas
     * @param koordinaatit Kertoo mitä ruudukon saraketta ollaan tällä hetkellä
     * liikuttamassa
     */
    private void liikutaYlosTaiAlas(Suunta suunta, Koordinaatit koordinaatit) {
        for (int x = 0; x < this.KORKEUS; x++) {
            if (suunta.equals(Suunta.ALAS)) {
                liikutaAlas(koordinaatit);
            } else {
                liikutaYlos(koordinaatit);
            }
        }
    }

    /**
     * Metodi liikuttaa ruudukon tietyn sarakkeen ruutuja alaspäin
     *
     * @param koordinaatit Kertoo mitä saraketta ollaan tällä hetkellä
     * liikuttamassa
     */
    private void liikutaAlas(Koordinaatit koordinaatit) {
        for (int j = this.KORKEUS - 2; j >= 0; j--) {
            koordinaatit.setY(j);
            liikutaRuutua(koordinaatit, Suunta.ALAS);
        }
    }

    /**
     * Metodi liikuttaa ruudukon tietyn sarakkeen ruutuja ylöspäin
     *
     * @param koordinaatit Kertoo mitä saraketta ollaan tällä hetkellä
     * liikuttamassa
     */
    private void liikutaYlos(Koordinaatit koordinaatit) {
        for (int j = 1; j < this.KORKEUS; j++) {
            koordinaatit.setY(j);
            liikutaRuutua(koordinaatit, Suunta.YLOS);
        }
    }

    /**
     * Metodi liikuttaa ruudukon ruutuja oikealle tai vasemmalle annetun suunnan
     * mukaisesti
     *
     * @param suunta Kertoo liikutetaanko ruutuja oikealle vai vasemmalle
     * @param koordinaatit Kertoo, mitä ruudukon riviä ollaan tällä hetkellä
     * liikuttamassa
     */
    private void liikutaOikeaTaiVasen(Suunta suunta, Koordinaatit koordinaatit) {
        for (int x = 0; x < this.LEVEYS; x++) {
            if (suunta.equals(Suunta.OIKEA)) {
                liikutaOikea(koordinaatit);
            } else {
                liikutaVasen(koordinaatit);
            }
        }
    }

    /**
     * Metodi liikuttaa ruudukon tietyn rivin ruutuja oikealle
     *
     * @param koordinaatit Kertoo mitä riviä ollaan tällä hetkellä liikuttamassa
     */
    private void liikutaOikea(Koordinaatit koordinaatit) {
        for (int j = this.LEVEYS - 2; j >= 0; j--) {
            koordinaatit.setX(j);
            liikutaRuutua(koordinaatit, Suunta.OIKEA);
        }
    }

    /**
     * Metodi liikuttaa ruudukon tietyn rivin ruutuja vasemmalle
     *
     * @param koordinaatit Kertoo mitä riviä ollaan tällä hetkellä liikuttamassa
     */
    private void liikutaVasen(Koordinaatit koordinaatit) {
        for (int j = 1; j < this.LEVEYS; j++) {
            koordinaatit.setX(j);
            liikutaRuutua(koordinaatit, Suunta.VASEN);
        }
    }

    /**
     * Metodi liikuttaa annetuissa koordinaateissa olevaa ruutua yhden askelen
     * annettuun suuntaan, jos liikuttaminen on mahdollista Siirto onnistuu
     * vain, jos liikutettava ruutu ei ole tyhjä ja ruutu, johon ollaan
     * liikkumassa on tyhjä tai jos liikutettavan ruudun ja kohderuudun värit
     * ovat sellaiset, että ne voi yhdistää eli yhdiste on epätyhjä
     *
     * @param koordinaatit Kertoo mitä ruutua halutaan liikuttaa
     * @param suunta Kertoo mihin suuntaan ruutua halutaan liikuttaa
     */
    private void liikutaRuutua(Koordinaatit koordinaatit, Suunta suunta) {
        Ruutu eka = this.ruudut[koordinaatit.getX()][koordinaatit.getY()];
        koordinaatit.liikuta(suunta);
        Ruutu toka = this.ruudut[koordinaatit.getX()][koordinaatit.getY()];

        if (!eka.getVari().equals(Vari.TYHJA) && toka.getVari().equals(Vari.TYHJA)) {
            Vari vari = eka.getVari();
            vaihdaVarit(eka, toka, vari);
        } else if (!eka.getVari().varienYhdiste(toka.getVari()).equals(Vari.TYHJA)) {
            Vari vari = eka.getVari().varienYhdiste(toka.getVari());
            vaihdaVarit(eka, toka, vari);
        }
    }

    /**
     * Metodi vaihtaa kahden ruudun värit siten, että ensimmäisestä ruudusta
     * tulee tyhjä ja toisesta ruudusta tulee annetun värinen
     *
     * @param eka Ruutu, josta halutaan tehdä tyhjä
     * @param toka Ruutu, jonka väriksi halutaan asettaa annettu väri
     * @param vari Väri, joka halutaan asettaa ruudun toka väriksi
     */
    private void vaihdaVarit(Ruutu eka, Ruutu toka, Vari vari) {
        eka.setVari(Vari.TYHJA);
        toka.setVari(vari);
    }

    /**
     * Metodi lisää ruutuja poistettavien ruutujen listaan ja lopuksi tyhjentää
     * tämän listan.
     *
     * @return Palautetaan poistettujen ruutujen lukumäärä
     */
    private int poistaPerakkaisetSamat() {
        ArrayList<Ruutu> poistettavatRuudut = new ArrayList<>();
        sarakkeidenPerakkaisetSamat(poistettavatRuudut);
        rivienPerakkaisetSamat(poistettavatRuudut);
        return tyhjennaPoistettavatRuudut(poistettavatRuudut);
    }

    /**
     * Metodi lisää peräkkäisten ruutujen listaan samassa sarakkeessa peräkkäin
     * sijaitsevat samanväriset ruudut ja siirtää ne tarvittaessa poistettavien
     * ruutujen listaan
     *
     * @param poistettavatRuudut Lista poistettavista ruuduista
     */
    private void sarakkeidenPerakkaisetSamat(ArrayList<Ruutu> poistettavatRuudut) {
        koordinaatit = new Koordinaatit(0, 0);
        ArrayList<Ruutu> perakkaisetRuudut = new ArrayList<>();
        for (int i = 0; i < this.LEVEYS; i++) {
            for (int j = 0; j < this.KORKEUS; j++) {
                koordinaatit.setX(i);
                koordinaatit.setY(j);
                perakkaisetRuudut = perakkaisetSamatListaan(koordinaatit, perakkaisetRuudut, poistettavatRuudut);
            }
            perakkaisetPoistettaviksiJosRiittavanMontaSamaa(perakkaisetRuudut, poistettavatRuudut);
            perakkaisetRuudut = new ArrayList<>();
        }
    }

    /**
     * Metodi lisää peräkkäisten ruutujen listaan samalla rivillä peräkkäin
     * sijaitsevat samanväriset ruudut ja siirtää nämä poistettavien ruutujen
     * listaan jos niitä on tarpeeksi monta peräkkäin
     *
     * @param poistettavatRuudut Lista poistettavista ruuduista
     */
    private void rivienPerakkaisetSamat(ArrayList<Ruutu> poistettavatRuudut) {
        koordinaatit = new Koordinaatit(0, 0);
        ArrayList<Ruutu> perakkaisetRuudut = new ArrayList<>();
        for (int i = 0; i < this.KORKEUS; i++) {
            for (int j = 0; j < this.LEVEYS; j++) {
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                perakkaisetRuudut = perakkaisetSamatListaan(koordinaatit, perakkaisetRuudut, poistettavatRuudut);
            }
            perakkaisetPoistettaviksiJosRiittavanMontaSamaa(perakkaisetRuudut, poistettavatRuudut);
            perakkaisetRuudut = new ArrayList<>();
        }
    }

    /**
     * Metodi lisää listaan peräkkäiset samanväriset ruudut
     *
     * @param koordinaatit Tieto siitä minkä ruudun viereisiä ruutuja ollaan
     * tutkimassa
     * @param perakkaisetRuudut Lista perääkkäisistä samanväristä ruuduista
     * @param poistettavatRuudut Lista ruuduista, joita ollaan poistamassa eli
     * vähintään kolmesta peräkkäisestä samanväristä ruudusta
     * @return Palauttaa listan peräkkäisistä samanväristä ruuduista
     */
    private ArrayList<Ruutu> perakkaisetSamatListaan(Koordinaatit koordinaatit, ArrayList<Ruutu> perakkaisetRuudut, ArrayList<Ruutu> poistettavatRuudut) {
        Ruutu ruutu = this.getRuutu(koordinaatit);
        if (perakkaisetRuudut.isEmpty() || perakkaisetRuudut.get(perakkaisetRuudut.size() - 1).getVari().equals(ruutu.getVari())) {
            perakkaisetRuudut.add(ruutu);
        } else {
            perakkaisetPoistettaviksiJosRiittavanMontaSamaa(perakkaisetRuudut, poistettavatRuudut);
            perakkaisetRuudut = new ArrayList<>();
            perakkaisetRuudut.add(ruutu);
        }
        return perakkaisetRuudut;
    }

    /**
     * Metodi tutkii peräkkäisten ruutujen listan ja jos se sisältää vähintään
     * kolme ruutua, siirtää kyseiset ruudut poistettavien ruutujen listalle
     *
     * @param perakkaisetRuudut Sisältää ruudukossa peräkkäin sijaitsevia
     * samanvärisiä ruutuja
     * @param poistettavatRuudut Sisältää ruudut, jotka halutaan poistaa
     */
    private void perakkaisetPoistettaviksiJosRiittavanMontaSamaa(ArrayList<Ruutu> perakkaisetRuudut, ArrayList<Ruutu> poistettavatRuudut) {
        if (perakkaisetRuudut.size() >= 3) {
            poistettavatRuudut.addAll(perakkaisetRuudut);
        }
    }

    /**
     * Metodi käy läpi poistettavien ruutujen listan ja tyhjentää sen ruudut.
     * Poistettavista ruuduista saa pisteitä niiden värin perusteella
     *
     * @param poistettavatRuudut Lista poistettavista ruuduista
     * @return Palauttaa poistettujen ruutujen värin perusteella määräytyvän
     * pistemäärän
     */
    private int tyhjennaPoistettavatRuudut(ArrayList<Ruutu> poistettavatRuudut) {
        int pisteet = 0;
        for (Ruutu ruutu : poistettavatRuudut) {
            pisteet += ruutu.getVari().varinPisteet();
            ruutu.setVari(Vari.TYHJA);
        }
        return pisteet;
    }
}
