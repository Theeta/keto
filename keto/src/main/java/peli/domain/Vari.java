
package peli.domain;

import java.awt.Color;

/**
 * Enumia käytetään värien ilmaisemiseen ja se tarjoaa metodeja värin esittämiseen graafisessa muodossa sekä värien sekoittamiseen.
 * @author noora
 */
public enum Vari {
    TYHJA,
    SININEN,
    PUNAINEN,
    LIILA,
    KELTAINEN,
    VIHREA,
    ORANSSI;
    
    /**
     * Metodi kertoo millä värikoodilla kukin väri esitetään ruudulla.
     * @return Palauttaa värin ilmaisemiseen käytettävän värikoodin.
     */
    public Color varinVari() {
        switch (this){
            case TYHJA: return Color.WHITE;
            case SININEN: return Color.BLUE;
            case PUNAINEN: return Color.RED;
            case LIILA: return Color.MAGENTA;
            case KELTAINEN: return Color.YELLOW;
            case VIHREA: return Color.GREEN;
            case ORANSSI: return Color.ORANGE;
            default: return Color.WHITE;
        }
    }
    
    /**
     * Metodia käytetään kahden värin yhdistämiseen.
     * @param vari Kertoo mihin väriin jotakain väriä yritetään yhdistää.
     * @return Palautetaan tyhjä, jos kyseisten värien yhdistäminen ei tuota uutta väriä ja muuten palautetaan yhdistelmäväri.
     */
    public Vari varienYhdiste(Vari vari){
        switch (this){
            case TYHJA: return Vari.TYHJA;
            case SININEN: if (vari.equals(Vari.PUNAINEN)){
                return Vari.LIILA;
            } else if (vari.equals(Vari.KELTAINEN)){
                return Vari.VIHREA;
            } else {
                return Vari.TYHJA;
            }
            case PUNAINEN: if (vari.equals(Vari.SININEN)){
                return Vari.LIILA;
            } else if (vari.equals(Vari.KELTAINEN)){
                return Vari.ORANSSI;
            } else {
                return Vari.TYHJA;
            }
            case LIILA: return Vari.TYHJA;
            case KELTAINEN: if (vari.equals(Vari.SININEN)){
                return Vari.VIHREA;
            } else if (vari.equals(Vari.PUNAINEN)){
                return Vari.ORANSSI;
            } else {
                return Vari.TYHJA;
            }
            case VIHREA: return Vari.TYHJA;
            case ORANSSI: return Vari.TYHJA;
            default: return Vari.TYHJA;
        }
    }
}
