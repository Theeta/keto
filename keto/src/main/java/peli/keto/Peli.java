package peli.keto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.domain.Ruudukko;
import peli.domain.Suunta;
import peli.domain.Vari;
import peli.gui.Paivitettava;
import peli.huipputulokset.Tuloslista;

/**
 * Luokka tarjoaa metodeja peliolioiden käsittelyyn
 *
 * @author noora
 */
public class Peli implements ActionListener {

    private Ruudukko ruudut;
    private Paivitettava paivitettava;
    private final Tuloslista tuloslista;
    private boolean paattynyt;
    private boolean alkanut;

    private final int leveys;
    private final int korkeus;
    private int pisteet;
    private String pelaajanNimi;

    /**
     * Konstruktorille annetaan peliruudukon haluttu koko ruutuina korkeus- ja
     * leveyssuunnassa. Konstruktori luo uuden, halutunkokoisen ruudukon ja
     * asettaa pistemäärän nollaksi, lisää ensimmäisenä arvottavat värit listaan
     * ja luo tuloslistan
     *
     * @param leveys Keroo kuinka monta ruutua leveä peliruudukko on
     * @param korkeus Kertoo kuinka monta ruutua korkea peliruudukko on
     * @param tiedostopolku Kertoo tuloslistan sijainnin
     */
    public Peli(int leveys, int korkeus, String tiedostopolku) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudut = new Ruudukko(leveys, korkeus);
        ruudut.lisaaSallittuVari(Vari.SININEN);
        ruudut.lisaaSallittuVari(Vari.PUNAINEN);
        this.pisteet = 0;
        this.tuloslista = new Tuloslista(10, tiedostopolku);
        this.pelaajanNimi = "pelaaja";
        this.paattynyt = false;
        this.alkanut = false;
    }

    /**
     * Metodia käytetään pelissä tapahtuviin siirtoihin. Siirron aikana
     * liikutetaan kaikkia ruutuja annettuun suuntaan, päivitetään pisteet ja
     * tarkastetaan, päättyikö peli. Jos peli ei päättynyt, ruudukkoon arvotaan
     * uusi ruutu.
     *
     * @param suunta Kertoo, mihin suuntaan peliruudukon ruutuja halutaan
     * liikuttaa
     */
    public void siirto(Suunta suunta) {
        if (this.paattynyt) {
            return;
        }
        this.pisteet += this.ruudut.liikutaKaikkiRuudut(suunta);
        lisaaTarvittaessaSallittuVari();
        lopetaPeliTarvittaessa();

        if (!this.paattynyt) {
            this.ruudut.arvoUusiRuutu();
        }
    }

    /**
     * Metodi lisää tarvittaessa sallittujen värien listalle uuden värin. Tämä
     * tapahtuu aina kun pelissä ylitetään tietty pistemäärä
     */
    private void lisaaTarvittaessaSallittuVari() {
        if (pisteet > 50) {
            this.ruudut.lisaaSallittuVari(Vari.KELTAINEN);
            if (pisteet > 100) {
                this.ruudut.lisaaSallittuVari(Vari.VALKOINEN);

            }
        }
    }

    /**
     * Metodi lopettaa pelin, jos ruudukko on täynnä ja mahdollisia siirtoja ei
     * enää ole. Pelin loputtua tulos lisätään tuloslistaan
     */
    private void lopetaPeliTarvittaessa() {
        if (this.ruudut.onkoRuudukkoTaynna() && !this.ruudut.onkoSiirtoMahdollinen()) {
            this.paattynyt = true;
            this.tuloslista.lisaaListalle(this.pelaajanNimi, this.pisteet);
        }
    }

    /**
     * Metodi kertoo onko peli päättynyt
     *
     * @return Palauttaa päättynyt-muuttujan arvon
     */
    public boolean onkoPeliPaattynyt() {
        return this.paattynyt;
    }

    /**
     * Metodin avulla luodaan uusi peli, jonka leveys ja korkeus ovat samat kuin
     * edellisellä pelillä. Metodi luo uuden halutunkokoisen ruudukon ja nollaa
     * pistemäärän.
     * @param nimi Pelaajan antama nimi
     */
    public void uusiPeli(String nimi) {
        this.ruudut = new Ruudukko(leveys, korkeus);
        ruudut.lisaaSallittuVari(Vari.SININEN);
        ruudut.lisaaSallittuVari(Vari.PUNAINEN);
        this.pelaajanNimi = nimi;
        this.pisteet = 0;
        this.paivitettava.paivita();
        this.paattynyt = false;
        this.alkanut = true;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public Ruudukko getRuudukko() {
        return this.ruudut;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void setPisteet(int luku) {
        this.pisteet = luku;
    }

    public boolean isAlkanut() {
        return alkanut;
    }

    public Tuloslista getTuloslista() {
        return tuloslista;
    }

    public String getPelaajanNimi() {
        return pelaajanNimi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.paivitettava.paivita();
    }
}
