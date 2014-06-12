
package peli.keto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.domain.Ruudukko;
import peli.domain.Suunta;
import peli.domain.Vari;
import peli.gui.Paivitettava;
//import peli.huipputulokset.Tuloslista;

/**
 * Luokka tarjoaa metodeja peliolioiden käsittelyyn
 * @author noora
 */
public class Peli implements ActionListener {
    private Ruudukko ruudut;
    private Paivitettava paivitettava;
    //private Tuloslista tuloslista;
    private int leveys;
    private int korkeus;
    private int pisteet;
    private String pelaajanNimi;

    /**
     * Konstruktorille annetaan peliruudukon haluttu koko ruutuina korkeus- ja leveyssuunnassa.
     * Konstruktori luo uuden, halutunkokoisen ruudukon ja asettaa pistemäärän nollaksi.
     * @param leveys Keroo kuinka monta ruutua leveä peliruudukko on
     * @param korkeus Kertoo kuinka monta ruutua korkea peliruudukko on
     * @param tiedostopolku Kertoo tuloslistan sijainnin
     */
    public Peli(int leveys, int korkeus, String tiedostopolku){
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudut = new Ruudukko(leveys, korkeus);
        ruudut.lisaaSallittuVari(Vari.SININEN);
        ruudut.lisaaSallittuVari(Vari.PUNAINEN);
        this.pisteet = 0;
        //this.tuloslista = new Tuloslista(10, tiedostopolku);
        this.pelaajanNimi = "pelaaja";
    }

    /**
     * Metodia käytetään pelissä tapahtuviin siirtoihin.
     * Siirron aikana liikutetaan kaikkia ruutuja annettuun suuntaan, päivitetään pisteet ja tarkastetaan, päättyikö peli.
     * Jos peli ei päättynyt, ruudukkoon arvotaan uusi ruutu.
     * @param suunta Kertoo, mihin suuntaan peliruudukon ruutuja halutaan liikuttaa
     */
    public void siirto(Suunta suunta){
        this.pisteet += this.ruudut.liikutaKaikkiRuudut(suunta);
        lisaaTarvittaessaSallittuVari();
        
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        } else {
            lopetaPeli();
        }
    }

    /**
     * Metodi lisää tarvittaessa sallittujen värien listalle uuden värin. Tämä tapahtuu aina kun pelissä ylitetään tietty pistemäärä
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
     * Metodi tarkastaa, onko peli päättynyt eli onko ruudukko tullut täyteen ja onko mahdollisia siirtoja vielä jäljellä.
     * @return Palauttaa true, jos peli on päättynyt ja false, jos ei ole
     */
    public boolean onkoPeliPaattynyt(){
        if (this.ruudut.onkoRuudukkoTaynna() && !this.ruudut.onkoSiirtoMahdollinen()){
            return true;
        }
        return false;
    }
    
    /**
     * Metodin avulla luodaan uusi peli, jonka leveys ja korkeus ovat samat kuin edellisellä pelillä.
     * Metodi luo uuden halutunkokoisen ruudukon ja nollaa pistemäärän.
     */
    public void uusiPeli() {
        this.ruudut = new Ruudukko(leveys, korkeus);
        this.pisteet = 0;
        this.paivitettava.paivita();
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
    
    public void setPisteet(int luku){
        this.pisteet = luku;
    }

//    public Tuloslista getTuloslista() {
//        return tuloslista;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.paivitettava.paivita();
    }

    private void lopetaPeli() {
        //this.tuloslista.lisaaListalle(this.pelaajanNimi, this.pisteet);
    }
    
}
