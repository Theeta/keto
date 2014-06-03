
package peli.keto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.domain.Ruudukko;
import peli.domain.Suunta;
import peli.gui.Paivitettava;

/**
 * Luokka tarjoaa metodeja peliolioiden käsittelyyn
 * @author noora
 */
public class Peli implements ActionListener {
    private Ruudukko ruudut;
    private Paivitettava paivitettava;
    private int leveys;
    private int korkeus;
    private int pisteet;

    /**
     * Konstruktorille annetaan peliruudukon haluttu koko ruutuina korkeus- ja leveyssuunnassa.
     * Konstruktori luo uuden, halutunkokoisen ruudukon ja asettaa pistemäärän nollaksi.
     * @param leveys Keroo kuinka monta ruutua leveä peliruudukko on
     * @param korkeus Kertoo kuinka monta ruutua korkea peliruudukko on
     */
    public Peli(int leveys, int korkeus){
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudut = new Ruudukko(leveys, korkeus);
        this.pisteet = 0;
    }

    /**
     * Metodia käytetään pelissä tapahtuviin siirtoihin.
     * Siirron aikana liikutetaan kaikkia ruutuja annettuun suuntaan, päivitetään pisteet ja tarkastetaan, päättyikö peli.
     * Jos peli ei päättynyt, ruudukkoon arvotaan uusi ruutu.
     * @param suunta Kertoo, mihin suuntaan peliruudukon ruutuja halutaan liikuttaa
     */
    public void siirto(Suunta suunta){
        this.setPisteet(this.getPisteet() + this.ruudut.liikutaKaikkiRuudut(suunta));
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        this.paivitettava.paivita();
    }
    
}
