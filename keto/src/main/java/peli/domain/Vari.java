
package peli.domain;

import java.awt.Color;

public enum Vari {
    TYHJA,
    SININEN,
    PUNAINEN,
    LIILA;
    
    public Color varinVari() {
        switch (this){
            case TYHJA: return Color.WHITE;
            case SININEN: return Color.BLUE;
            case PUNAINEN: return Color.RED;
            case LIILA: return Color.GRAY;
            default: return Color.WHITE;
        }
    }
}
