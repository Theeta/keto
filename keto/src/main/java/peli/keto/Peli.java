
package peli.keto;

import peli.domain.Ruudukko;

public class Peli {
    Ruudukko ruudut;
    
    public Peli(int leveys, int korkeus){
        this.ruudut = new Ruudukko(leveys, korkeus);
    }
    public void tulostaTilanne(){
        this.ruudut.tulostaRuudut();
        System.out.println("------------");
    }
    public void siirto(){
        liikuAlas();
        if (!onkoPeliPaattynyt()){
            this.ruudut.arvoUusiRuutu();
        }
    }
    
    public void liikuAlas(){
        this.ruudut.liikutaRuutujaAlas();
    }
    
    public boolean onkoPeliPaattynyt(){
        return this.ruudut.onkoRuudukkoTaynna();
    }
    
}
