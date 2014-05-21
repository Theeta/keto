
package peli.domain;

import java.util.Random;

public class Ruutu {
    
    private Vari vari;
    
    public Ruutu(Vari vari){
        this.vari = vari;
    }
    public void setVari(Vari vari){
        this.vari = vari;
    }
    public Vari getVari(){
        return this.vari;
    }
    
    public void arvoRuudunVari(){
        Random arpoja = new Random();
        if (arpoja.nextInt() < 0.8){
            setVari(Vari.PUNAINEN);
        } else {
            setVari(Vari.SININEN);
        }
    }
    
}
