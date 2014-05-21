
package peli.domain;

public enum Vari {
    TYHJA,
    SININEN,
    PUNAINEN,
    LIILA;
    
    public String tulostus(){
        switch (this){
            case TYHJA: return " ";
            case SININEN: return "S";
            case PUNAINEN: return "P";
            case LIILA: return "L";
            default: return "-";
        }
    }
}
