
package peli.domain;

import java.util.Random;

/**
 * Luokan oliot ovat peliruudukon ruutuja, joilla on ominaisuutena väri.
 * Luokka tarjoaa metodeja tämän ominaisuuden käsittelyyn.
 * 
 * @author noora
 */
public class Ruutu {
    
    private Vari vari;
    
    /**
     * Konstruktori asettaa uudelle ruudulle annetun värin.
     * @param vari Kertoo ruudun värin
     */
    public Ruutu(Vari vari){
        this.vari = vari;
    }
    public void setVari(Vari vari){
        this.vari = vari;
    }
    public Vari getVari(){
        return this.vari;
    }
    
    /**
     * Metodi arpoo ruudulle värin, joka voi olla sininen, keltainen tai punainen.
     */
    public void arvoRuudunVari(){
        Random arpoja = new Random();
        int luku = arpoja.nextInt(10);
        if (luku < 3){
            setVari(Vari.SININEN);
        } else if (luku > 7){
            setVari(Vari.KELTAINEN);
        } else {
            setVari(Vari.PUNAINEN);
        }
    }
    
}
