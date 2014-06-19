package peli.huipputulokset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Tuloslista sisältää listan huipputuloksista. Luokassa on metodeja tämän listan käsittelyyn.
 * @author noora
 */
public class Tuloslista {

    private List<Tulos> lista;
    private final int listanPituus;
    private final File tiedosto;

    public Tuloslista(int listanPituus, String tiedostopolku) {
        this.lista = new ArrayList<>();
        this.listanPituus = listanPituus;
        this.tiedosto = new File(tiedostopolku);
        try {
            lataaLista(this.tiedosto);
        } catch (FileNotFoundException ex) {
        }
    }

    public List<Tulos> getLista() {
        return lista;
    }

    /**
     * Metodi lataa tulostiedoston ja lisää sen sisällön listalle
     * @param tiedosto
     * @throws FileNotFoundException 
     */
    private void lataaLista(File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        String rivi = null;
        while (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
            try {
                String[] palat = rivi.split(":");
                this.lisaaListalle(palat[0], Integer.parseInt(palat[1]));
            } catch (NumberFormatException e) {
            }
        }
    }

    /**
     * Metodin avulla lisätään uusi tulos tuloslistaan
     * @param nimi
     * @param pisteet 
     */
    public void lisaaListalle(String nimi, int pisteet) {
        Tulos uusiTulos = new Tulos(nimi, pisteet);
        this.lista.add(uusiTulos);
        Collections.sort(lista);
        if (lista.size() > this.listanPituus) {
            lista.remove(lista.size() - 1);
        }
        Collections.sort(lista);
        tallennaLista(this.tiedosto);
    }

    /**
     * Metodin avulla tallennetaan tuloslista tiedostoon
     * @param tiedosto 
     */
    private void tallennaLista(File tiedosto) {
        try {
            try (FileWriter kirjoittaja = new FileWriter(tiedosto)) {
                for (Tulos tulos : lista) {
                    kirjoittaja.write(tulos.getNimi() + ":" + tulos.getPisteet() + "\n");
                }
            }
        } catch (IOException ex) {
        }

    }
    
    /**
     * Metodi tyhjentää tuloslistan ja poistaa tiedoston. Sitä käytetään testeissä
     */
    public void tyhjennaLista() {
        this.lista = new ArrayList<>();
        this.tiedosto.delete();
    }
}
