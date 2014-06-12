
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
}
