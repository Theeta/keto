/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peli.domain;

/**
 *
 * @author mikko&noora
 */
public class Peliruudukko {

    /**
     * Peliruudukko sisältää taulukollisen ruutuja ja mahdollistaa ruutujen
     * hakemisen ja tarjoaa rajapinnan ruutujen hakemiseen ja asettamiseen.
     * Ruutuja voidaan etsiä ja asettaa koordinaattien perusteella ruudukon
     * ollessa käännettynä eri suuntiin.
     */
    private final Ruutu[][] ruudut;
    private final int LEVEYS;
    private final int KORKEUS;

    public Peliruudukko(int leveys, int korkeus) {
        this.ruudut = new Ruutu[leveys][korkeus];
        this.LEVEYS = leveys;
        this.KORKEUS = korkeus;
    }

    public Ruutu[][] getRuudut() {
        return this.ruudut;
    }

    public int ruudukonLeveysAsennossa(Suunta asento) {
        switch (asento) {
            case YLOS:
                return LEVEYS;
            case ALAS:
                return LEVEYS;
            case OIKEA:
                return KORKEUS;
            case VASEN:
                return KORKEUS;
        }
        return -1;
    }

    public int ruudukonKorkeusAsennossa(Suunta asento) {
        switch (asento) {
            case YLOS:
                return KORKEUS;
            case ALAS:
                return KORKEUS;
            case OIKEA:
                return LEVEYS;
            case VASEN:
                return LEVEYS;
        }
        return -1;
    }

    public void setRuutu(Koordinaatit koordinaatit, Suunta suunta, Ruutu ruutu) {
        setRuutu(koordinaatit.getX(), koordinaatit.getY(), suunta, ruutu);
    }

    public void setRuutu(Koordinaatit koordinaatit, Ruutu ruutu) {
        setRuutu(koordinaatit, Suunta.YLOS, ruutu);
    }

    public void setRuutu(int x, int y, Suunta suunta, Ruutu ruutu) {
        switch (suunta) {
            case YLOS:
                ruudut[x][y] = ruutu;
                return;
            case ALAS:
                ruudut[LEVEYS - x - 1][KORKEUS - y - 1] = ruutu;
                return;
            case VASEN:
                ruudut[y][LEVEYS - x - 1] = ruutu;
                return;
            case OIKEA:
                ruudut[KORKEUS - y - 1][x] = ruutu;
        }
    }

    /**
     * Palauttaa parametrina annetuissa koordinaateissa sijaitsevan ruudun,
     * taulukon ollessa ylöspäin eli oletusasennossa.
     *
     * @param koordinaatit
     * @return
     */
    public Ruutu getRuutu(Koordinaatit koordinaatit) {
        return getRuutu(koordinaatit, Suunta.YLOS);
    }

    /**
     * Palauttaa parametrina annetuissa koordinaateissa sijaitsevan ruudun,
     * taulukon ollessa ylöspäin eli oletusasennossa.
     *
     * @param x
     * @param y
     * @return
     */
    public Ruutu getRuutu(int x, int y) {
        return getRuutu(x, y, Suunta.YLOS);
    }

    /**
     * Palauttaa parametrina annetuissa koordinaateissa sijaitsevan ruudun,
     * taulukon osoittaessa parametreina annettuun suuntaan. Parametrina
     * annettujen koordinaattien tulee olla siis suhteessa parametrina annettuun
     * taulukon asentoon.
     *
     * @param koordinaatit
     * @param suunta
     * @return
     */
    public Ruutu getRuutu(Koordinaatit koordinaatit, Suunta suunta) {
        return getRuutu(koordinaatit.getX(), koordinaatit.getY(), suunta);
    }

    /**
     * Palauttaa parametrina annetuissa koordinaateissa sijaitsevan ruudun,
     * taulukon osoittaessa parametreina annettuun suuntaan. Parametrina
     * annettujen koordinaattien tulee olla siis suhteessa parametrina annettuun
     * taulukon asentoon.
     *
     * @param x
     * @param y
     * @param suunta
     * @return
     */
    public Ruutu getRuutu(int x, int y, Suunta suunta) {
        switch (suunta) {
            case YLOS:
                return ruudut[x][y];
            case ALAS:
                return ruudut[LEVEYS - x - 1][KORKEUS - y - 1];
            case VASEN:
                return ruudut[y][LEVEYS - x - 1];
            case OIKEA:
                return ruudut[KORKEUS - y - 1][x];
        }
        return null;
    }

}
