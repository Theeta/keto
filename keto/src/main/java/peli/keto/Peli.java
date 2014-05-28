
package peli.keto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.domain.Ruudukko;
import peli.domain.Suunta;
import peli.gui.Paivitettava;

public class Peli implements ActionListener {
    private Ruudukko ruudut;
    private Paivitettava paivitettava;
    private int leveys;
    private int korkeus;
    
    public Peli(int leveys, int korkeus){
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudut = new Ruudukko(leveys, korkeus);
    }

    public void siirto(Suunta suunta){
        this.ruudut.liikutaKaikkiRuudut(suunta);
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        }
    }
    
    public boolean onkoPeliPaattynyt(){
        return this.ruudut.onkoRuudukkoTaynna();
    }
    
    public void uusiPeli() {
        this.ruudut = new Ruudukko(leveys, korkeus);
        this.paivitettava.paivita();
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
    public Ruudukko getRuudukko() {
        return this.ruudut;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.paivitettava.paivita();
    }
    
}
