package peli.domain;

public class Koordinaatit {

    private int x;
    private int y;

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
