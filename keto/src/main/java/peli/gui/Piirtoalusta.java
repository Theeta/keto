package peli.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import peli.domain.Koordinaatit;
import peli.domain.Vari;
import peli.keto.Peli;

/**
 * Luokka sisältää pelin muuttuvien komponenttien piirtämisessä käytetyt
 * metodit.
 *
 * @author noora
 */
public class Piirtoalusta extends JPanel implements Paivitettava {

    private final Peli peli;
    private final int ruudunLeveys;
    private Image alkuteksti;
    private Image tausta;
    private final Map<Vari, Image> kukat;

    /**
     * Konstruktorille annetaan käynnissä oleva peli ja yhden peliruudukon
     * ruudun leveys. Konstruktori myös lataa tarvittavat kuvat.
     *
     * @param peli Kertoo kyseisen pelin
     * @param ruudunLeveys Kertoo yhden peliruudukon ruudun leveyden
     */
    public Piirtoalusta(Peli peli, int ruudunLeveys) {
        this.peli = peli;
        this.ruudunLeveys = ruudunLeveys;
        this.kukat = new EnumMap(Vari.class);
        lataaKuvat();
        this.setPreferredSize(new Dimension(501, 630));
    }

    /**
     * Metodi lataa pelissä tarvittavat kuvat. Kukat laitetaan konstruktorissa luotuun enumMapiin.
     */
    private void lataaKuvat() {
        try {
            this.alkuteksti = ImageIO.read(this.getClass().getResource("/alkuteksti.png"));
            this.tausta = ImageIO.read(this.getClass().getResource("/tausta.png"));
            this.kukat.put(Vari.TYHJA, ImageIO.read(this.getClass().getResource("/tyhja_kukka.png")));
            this.kukat.put(Vari.KELTAINEN, ImageIO.read(this.getClass().getResource("/keltainen_kukka.png")));
            this.kukat.put(Vari.LIILA, ImageIO.read(this.getClass().getResource("/liila_kukka.png")));
            this.kukat.put(Vari.ORANSSI, ImageIO.read(this.getClass().getResource("/oranssi_kukka.png")));
            this.kukat.put(Vari.PUNAINEN, ImageIO.read(this.getClass().getResource("/punainen_kukka.png")));
            this.kukat.put(Vari.SININEN, ImageIO.read(this.getClass().getResource("/sininen_kukka.png")));
            this.kukat.put(Vari.VAALEANKELTAINEN, ImageIO.read(this.getClass().getResource("/vaaleankeltainen_kukka.png")));
            this.kukat.put(Vari.VAALEANLIILA, ImageIO.read(this.getClass().getResource("/vaaleanliila_kukka.png")));
            this.kukat.put(Vari.VAALEANORANSSI, ImageIO.read(this.getClass().getResource("/vaaleanoranssi_kukka.png")));
            this.kukat.put(Vari.VAALEANPUNAINEN, ImageIO.read(this.getClass().getResource("/vaaleanpunainen_kukka.png")));
            this.kukat.put(Vari.VAALEANSININEN, ImageIO.read(this.getClass().getResource("/vaaleansininen_kukka.png")));
            this.kukat.put(Vari.VAALEANVIHREA, ImageIO.read(this.getClass().getResource("/vaaleanvihrea_kukka.png")));
            this.kukat.put(Vari.VALKOINEN, ImageIO.read(this.getClass().getResource("/valkoinen_kukka.png")));
            this.kukat.put(Vari.VIHREA, ImageIO.read(this.getClass().getResource("/vihrea_kukka.png")));
        } catch (IOException ex) {
            System.out.println("kuvien lataus ei onnistunut");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!peli.isAlkanut()) {
            piirraAlkukuva(g);
            return;
        }
        piirraAlapalkki(g);
        piirraRuudukko(g);
        if (peli.onkoPeliPaattynyt()) {
            piirraLopputeksti(g);
        }
    }

    @Override
    public void paivita() {
        super.repaint();
    }

    /**
     * Metodi huolehtii peliruudukon piirtämisestä
     *
     * @param g
     */
    private void piirraRuudukko(Graphics g) {
        Koordinaatit koordinaatit = new Koordinaatit(0, 0);
        for (int i = 0; i < peli.getRuudukko().getLeveys(); i++) {
            for (int j = 0; j < peli.getRuudukko().getKorkeus(); j++) {
                koordinaatit.setX(i);
                koordinaatit.setY(j);
                g.drawImage(kukat.get(peli.getRuudukko().getRuutu(koordinaatit).getVari()), koordinaatit.getX() * ruudunLeveys, koordinaatit.getY() * ruudunLeveys, this);
            }
        }
    }

    /**
     * Metodi huolehtii peliruudukon alla olevan palkin piirtämisestä. Palkki
     * sisältää päivittyvän tiedon pelaajasta, pisteistä ja huipputuloksesta.
     *
     * @param g
     */
    private void piirraAlapalkki(Graphics g) {
        g.drawImage(tausta, 0, 0, this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("a", Font.BOLD, 20));
        g.drawString("Pelaaja: " + peli.getPelaajanNimi(), 30, peli.getRuudukko().getKorkeus() * ruudunLeveys + 30);
        g.drawString("Pisteet: " + peli.getPisteet(), 30, peli.getRuudukko().getKorkeus() * ruudunLeveys + 60);
        if (!peli.getTuloslista().getLista().isEmpty()) {
            g.drawString("Huipputulos: " + peli.getTuloslista().getLista().get(0).getNimi() + " " + peli.getTuloslista().getLista().get(0).getPisteet(), 30, peli.getRuudukko().getKorkeus() * ruudunLeveys + 90);
        }
    }

    /**
     * Metodi huolehtii lopputekstin piirtämisestä, kun peli on päättynyt.
     *
     * @param g
     */
    private void piirraLopputeksti(Graphics g) {
        g.setColor(new Color((float) 0.9, (float) 0.9, (float) 0.9, (float) 0.7));
        g.fillRect(0, 0, peli.getRuudukko().getLeveys() * ruudunLeveys, peli.getRuudukko().getLeveys() * ruudunLeveys);
        g.setColor(Color.BLACK);
        g.setFont(new Font("b", Font.BOLD, 40));
        g.drawString("Se on loppu nyt", ruudunLeveys, ruudunLeveys * 2);
    }

    /**
     * Metodi huolehtii aloituskuvan piirtämisestä ennen kuin peli on aloitettu.
     * @param g 
     */
    private void piirraAlkukuva(Graphics g) {
        g.drawImage(tausta, 0, 0, this);
        g.drawImage(alkuteksti, 0, 0, this);
    }
}
