package peli.domain;

import java.util.ArrayList;
import java.util.Random;

public class Ruudukko {

    private final Ruutu[][] ruudut;
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

    public Ruutu getRuutu(Koordinaatit koordinaatit) {
        return ruudut[koordinaatit.getX()][koordinaatit.getY()];
    }

    public void setRuutu(Ruutu ruutu, Koordinaatit koordinaatit) {
        ruudut[koordinaatit.getX()][koordinaatit.getY()] = ruutu;
    }
    
    public void poistaRuutu(Koordinaatit koordinaatit){
        Ruutu ruutu = ruudut[koordinaatit.getX()][koordinaatit.getY()];
        ruutu.setVari(Vari.TYHJA);
    }

    public void arvoUusiRuutu() {
        if (!onkoRuudukkoTaynna()){
            Random arpoja = new Random();
        int x, y;
        do {
            x = arpoja.nextInt(this.LEVEYS);
            y = arpoja.nextInt(this.KORKEUS);
        } while (!ruudut[x][y].getVari().equals(Vari.TYHJA));
        ruudut[x][y].arvoRuudunVari();
        }
    }

    public boolean onkoRuudukkoTaynna() {
        for (int i = 0; i < this.KORKEUS; i++) {
            for (int j = 0; j < this.LEVEYS; j++) {
                if (ruudut[j][i].getVari().equals(Vari.TYHJA)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void liikutaRuutua(Koordinaatit koordinaatit, Suunta suunta) {
        Ruutu eka = this.ruudut[koordinaatit.getX()][koordinaatit.getY()];
        koordinaatit.liikuta(suunta);
        Ruutu toka = this.ruudut[koordinaatit.getX()][koordinaatit.getY()];

        if (!eka.getVari().equals(Vari.TYHJA) && toka.getVari().equals(Vari.TYHJA)) {
            Vari vari = eka.getVari();
            eka.setVari(Vari.TYHJA);
            toka.setVari(vari);
        }
    }

    public void liikutaKaikkiRuudut(Suunta suunta) {
        Koordinaatit koordinaatit = new Koordinaatit(0, 0);

        if (suunta.equals(Suunta.ALAS) || suunta.equals(Suunta.YLOS)) {
            for (int i = 0; i < this.LEVEYS; i++) {
                koordinaatit.setX(i);
                liikutaYlosTaiAlas(suunta, koordinaatit);
            }
        } else {
            for (int i = 0; i < this.KORKEUS; i++) {
                koordinaatit.setY(i);
                liikutaOikeaTaiVasen(suunta, koordinaatit);
            }
        }
        poistaPerakkaisetSamat();
    }

    private void liikutaOikeaTaiVasen(Suunta suunta, Koordinaatit koordinaatit) {
        for (int x = 0; x < this.LEVEYS; x++) {
            if (suunta.equals(Suunta.OIKEA)){
                liikutaOikea(koordinaatit);
            } else {
                liikutaVasen(koordinaatit);
            }
        }
    }

    private void liikutaYlosTaiAlas(Suunta suunta, Koordinaatit koordinaatit) {
        for (int x = 0; x < this.KORKEUS; x++) {
            if (suunta.equals(Suunta.ALAS)){
                liikutaAlas(koordinaatit);
            } else {
                liikutaYlos(koordinaatit);
            }
        }
    }

    private void liikutaAlas(Koordinaatit koordinaatit) {
        for (int j = this.KORKEUS - 2; j >= 0; j--) {
            koordinaatit.setY(j);
            liikutaRuutua(koordinaatit, Suunta.ALAS);
        }
    }

    private void liikutaYlos(Koordinaatit koordinaatit) {
        for (int j = 1; j < this.KORKEUS; j++) {
            koordinaatit.setY(j);
            liikutaRuutua(koordinaatit, Suunta.YLOS);
        }
    }

    private void liikutaOikea(Koordinaatit koordinaatit) {
        for (int j = this.LEVEYS - 2; j >= 0; j--) {
            koordinaatit.setX(j);
            liikutaRuutua(koordinaatit, Suunta.OIKEA);
        }
    }

    private void liikutaVasen(Koordinaatit koordinaatit) {
        for (int j = 1; j < this.LEVEYS; j++) {
            koordinaatit.setX(j);
            liikutaRuutua(koordinaatit, Suunta.VASEN);
        }
    }
    
    private void poistaPerakkaisetSamat(){
        ArrayList<Ruutu> poistettavatRuudut = new ArrayList<>();
        Koordinaatit koordinaatit = new Koordinaatit(0,0);
        sarakkeidenPerakkaisetSamat(koordinaatit, poistettavatRuudut);
        rivienPerakkaisetSamat(koordinaatit, poistettavatRuudut);        
        tyhjennaPoistettavatRuudut(poistettavatRuudut);
    }

    private void rivienPerakkaisetSamat(Koordinaatit koordinaatit, ArrayList<Ruutu> poistettavatRuudut) {
        ArrayList<Ruutu> perakkaisetRuudut = new ArrayList<>();
        for (int i = 0; i < this.KORKEUS; i++){
            for (int j = 0; j < this.LEVEYS; j++){
                koordinaatit.setX(j);
                koordinaatit.setY(i);
                perakkaisetRuudut = perakkaisetSamatListaan(koordinaatit, perakkaisetRuudut, poistettavatRuudut);
            }
            perakkaisetPoistettaviksiJosRiittavanMontaSamaa(perakkaisetRuudut, poistettavatRuudut);
            perakkaisetRuudut = new ArrayList<>();
        }
    }

    private void perakkaisetPoistettaviksiJosRiittavanMontaSamaa(ArrayList<Ruutu> perakkaisetRuudut, ArrayList<Ruutu> poistettavatRuudut) {
        if (perakkaisetRuudut.size() >= 3){
            poistettavatRuudut.addAll(perakkaisetRuudut);
        }
    }

    private void sarakkeidenPerakkaisetSamat(Koordinaatit koordinaatit, ArrayList<Ruutu> poistettavatRuudut) {
        ArrayList<Ruutu> perakkaisetRuudut = new ArrayList<>();
        for (int i = 0; i < this.LEVEYS; i++){
            for (int j = 0; j < this.KORKEUS; j++){
                koordinaatit.setX(i);
                koordinaatit.setY(j);
                perakkaisetRuudut = perakkaisetSamatListaan(koordinaatit, perakkaisetRuudut, poistettavatRuudut);
            }
            perakkaisetPoistettaviksiJosRiittavanMontaSamaa(perakkaisetRuudut, poistettavatRuudut);
            perakkaisetRuudut = new ArrayList<>();
        }
    }

    private void tyhjennaPoistettavatRuudut(ArrayList<Ruutu> poistettavatRuudut) {
        for (Ruutu ruutu : poistettavatRuudut){
            ruutu.setVari(Vari.TYHJA);
        }
    }

    private ArrayList<Ruutu> perakkaisetSamatListaan(Koordinaatit koordinaatit, ArrayList<Ruutu> perakkaisetRuudut, ArrayList<Ruutu> poistettavatRuudut) {
        Ruutu ruutu = this.getRuutu(koordinaatit);
        if (perakkaisetRuudut.isEmpty() || perakkaisetRuudut.get(perakkaisetRuudut.size()-1).getVari().equals(ruutu.getVari())){
            perakkaisetRuudut.add(ruutu);
        } else {
            perakkaisetPoistettaviksiJosRiittavanMontaSamaa(perakkaisetRuudut, poistettavatRuudut);
            perakkaisetRuudut = new ArrayList<>();
            perakkaisetRuudut.add(ruutu);
        }
        return perakkaisetRuudut;
    }
}
