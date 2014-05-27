
package peli.keto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.domain.Ruudukko;
import peli.gui.Paivitettava;

public class Peli implements ActionListener {
    private Ruudukko ruudut;
    private Paivitettava paivitettava;
    
    public Peli(int leveys, int korkeus){
        this.ruudut = new Ruudukko(leveys, korkeus);
    }
    public void tulostaTilanne(){
        this.ruudut.tulostaRuudut();
        System.out.println("------------");
    }
    public void siirto(){
        liikuOikea();
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        }
    }
    
    public void liikuAlas(){
        this.ruudut.liikutaRuutujaAlas();
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        }
    }
    
    public void liikuYlos(){
        this.ruudut.liikutaRuutujaYlos();
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        }
    }
    
    public void liikuVasen(){
        this.ruudut.liikutaRuutujaVasen();
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        }
    }
    
    public void liikuOikea(){
        this.ruudut.liikutaRuutujaOikea();
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        }
    }
    
    public boolean onkoPeliPaattynyt(){
        return this.ruudut.onkoRuudukkoTaynna();
    }
    
    public void uusiPeli() {
        
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
