package peli.huipputulokset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tuloslista {

    private List<Tulos> lista;
    private int listanPituus;
    private File tiedosto;

    public Tuloslista(int listanPituus, String tiedostopolku) {
        this.lista = new ArrayList<>();
        this.listanPituus = listanPituus;
        this.tiedosto = new File(tiedostopolku);
        try {
            lataaLista(this.tiedosto);
        } catch (FileNotFoundException ex) {
            System.out.println("tiedostoa ei löytynyt");
        }
    }

    public List<Tulos> getLista() {
        return lista;
    }

    private void lataaLista(File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        String rivi = null;
        while (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
            try {
                String[] palat = rivi.split(":");
                this.lisaaListalle(palat[0], Integer.parseInt(palat[1]));
            } catch (Exception e) {
                e.printStackTrace();
                //System.out.println("joo ei toimi tuloslista");
            }
        }
    }

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

    private void tallennaLista(File tiedosto) {
        System.out.println("Tallennetaan lista");
        try {
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            //kirjoittaja.write("# Tää on highscorelista, ei oo kiva jos muokkaat\n");
            for (Tulos tulos : lista) {
                kirjoittaja.write(tulos.getNimi() + ":" + tulos.getPisteet() + "\n");
            }
            kirjoittaja.close();
        } catch (IOException ex) {
        }

    }
}
