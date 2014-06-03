package peli.domain;

/**
 * Luokkan olioita käytetään kappaleen sijainnin ilmaisemiseen kaksiuloitteisessa koordinaatistossa
 * ja se sisältää metodeja tämän paikkatiedon käsittelyyn
 * 
 * @author noora
 */
public class Koordinaatit {

    private int x;
    private int y;

    /**
     * 
     * @param x x-koordinaatti olion luontihetkellä
     * @param y y-koordinaatti olion luontihetkellä
     */
    public Koordinaatit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Metodi muuttaa kappaleen koodinaatteja siten, että se liikkuu parametrina annettuun suuntaan
     * @param suunta Kertoo mihin suuntaan halutaan liikkua
     */
    public void liikuta(Suunta suunta) {
        switch (suunta) {
            case YLOS:
                y--;
                break;
            case ALAS:
                y++;
                break;
            case OIKEA:
                x++;
                break;
            case VASEN:
                x--;
                break;
        }
    }
}
