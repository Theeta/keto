
package peli.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import peli.keto.Peli;

/**
 * Luokka sisältää pelin muuttuvien komponenttien piirtämisessä käytetyt metodit.
 * @author noora
 */
public class Piirtoalusta extends JPanel implements Paivitettava {
    
    private Peli peli;
    private int ruudunLeveys;
    
    /**
     * Konstruktorille annetaan käynnissä oleva peli ja yhden peliruudukon ruudun leveys.
     * @param peli Kertoo kyseisen pelin
     * @param ruudunLeveys Kertoo yhden peliruudukon ruudun leveyden
     */
    public Piirtoalusta(Peli peli, int ruudunLeveys){
        this.peli = peli;
        this.ruudunLeveys = ruudunLeveys;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        piirraAlapalkki(g);
        piirraRuudukko(g);
        if (peli.onkoPeliPaattynyt()){
            piirraLopputeksti(g);
        }
    }

    @Override
    public void paivita() {
        super.repaint();
    }

    /**
     * Metodi huolehtii peliruudukon piirtämisestä
     * @param g 
     */
    private void piirraRuudukko(Graphics g) {
        for (int i = 0; i < peli.getRuudukko().getLeveys(); i++) {
            for (int j = 0; j < peli.getRuudukko().getKorkeus(); j++) {
                g.setColor(peli.getRuudukko().getRuutu(i, j).getVari().varinVari());
                g.fill3DRect(i*ruudunLeveys, j*ruudunLeveys, ruudunLeveys, ruudunLeveys, true);
                g.setColor(Color.BLACK);
                g.drawRect(i*ruudunLeveys, j*ruudunLeveys, ruudunLeveys, ruudunLeveys);
                
            }
        }
    }
    
    /**
     * Metodi huolehtii peliruudukon alla olevan palkin piirtämisestä.
     * Palkki sisältää päivittyvän tiedon pisteistä.
     * @param g 
     */
    private void piirraAlapalkki(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, peli.getRuudukko().getLeveys() * ruudunLeveys, (peli.getRuudukko().getKorkeus() + 1) * ruudunLeveys);
        g.setColor(Color.BLACK);
        g.setFont(new Font("a", Font.BOLD, 20));
        g.drawString("Pisteet: " + peli.getPisteet(), 30, peli.getRuudukko().getKorkeus() * ruudunLeveys + 30);
        
    }

    /**
     * Metodi huolehtii lopputekstin piirtämisestä, kun peli on päättynyt.
     * @param g 
     */
    private void piirraLopputeksti(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("b", Font.BOLD, 40));
        g.drawString("Se on loppu nyt", ruudunLeveys, ruudunLeveys);
    }
}
