package peli.domain;

import java.util.Random;

public class Ruudukko {

    private Ruutu[][] ruudut;
    private final int LEVEYS;
    private final int KORKEUS;

    public Ruudukko(int leveys, int korkeus) {
        this.LEVEYS = leveys;
        this.KORKEUS = korkeus;
        ruudut = new Ruutu[leveys][korkeus];

        for (int i = 0; i < this.KORKEUS; i++) {
            for (int j = 0; j < this.LEVEYS; j++) {
                ruudut[j][i] = new Ruutu(Vari.TYHJA);
            }
        }
    }

    public int getLeveys() {
        return this.LEVEYS;
    }

    public int getKorkeus() {
        return this.KORKEUS;
    }

    public Ruutu getRuutu(int x, int y) {
        return ruudut[x][y];
    }

    public void tulostaRuudut() {
        for (int i = 0; i < this.KORKEUS; i++) {
            for (int j = 0; j < this.LEVEYS; j++) {
                System.out.print(ruudut[j][i].getVari().tulostus() + " ");
            }
            System.out.println("");
        }
    }

    public void arvoUusiRuutu() {
        Random arpoja = new Random();
        int x, y;
        do {
            x = arpoja.nextInt(this.LEVEYS);
            y = arpoja.nextInt(this.KORKEUS);
        } while (!ruudut[x][y].getVari().equals(Vari.TYHJA));
        ruudut[x][y].arvoRuudunVari();
    }
    
    public boolean onkoRuudukkoTaynna(){
        for (int i = 0; i < this.KORKEUS; i++){
            for (int j = 0; j < this.LEVEYS; j++){
                if (ruudut[j][i].getVari().equals(Vari.TYHJA)){
                    return false;
                }
            }
        }
        return true;
    }
}
