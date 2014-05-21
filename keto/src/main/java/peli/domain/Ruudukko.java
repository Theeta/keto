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
    
    public void liikutaRuutua(Koordinaatit koordinaatit, Suunta suunta){
        Ruutu eka = this.ruudut[koordinaatit.getX()][koordinaatit.getY()];
        koordinaatit.liikuta(suunta);
        Ruutu toka = this.ruudut[koordinaatit.getX()][koordinaatit.getY()];
        
        if (!eka.getVari().equals(Vari.TYHJA) && toka.getVari().equals(Vari.TYHJA)){
            Vari vari = eka.getVari();
            eka.setVari(Vari.TYHJA);
            toka.setVari(vari);
        }
    }
    
    public void liikutaRuutujaAlas(){
        Koordinaatit koordinaatit = new Koordinaatit(0,0);
        
        for (int i = 0; i < this.LEVEYS; i++){
            koordinaatit.setX(i);
            
            for (int x = 0; x < this.KORKEUS; x++){
                for (int j = this.KORKEUS -2; j >= 0; j--){
                    koordinaatit.setY(j);
                    liikutaRuutua(koordinaatit, Suunta.ALAS);
                }
            }
            
        }
    }
}
