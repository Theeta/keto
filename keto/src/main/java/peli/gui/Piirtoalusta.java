
package peli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import peli.keto.Peli;

public class Piirtoalusta extends JPanel implements Paivitettava {
    
    private Peli peli;
    private int ruudunLeveys;
    
    public Piirtoalusta(Peli peli, int ruudunLeveys){
        this.peli = peli;
        this.ruudunLeveys = ruudunLeveys;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        piirraRuudukko(g);
    }

    @Override
    public void paivita() {
        super.repaint();
    }

    private void piirraRuudukko(Graphics g) {
        for (int i = 0; i < peli.getRuudukko().getLeveys(); i++) {
            for (int j = 0; j < peli.getRuudukko().getKorkeus(); j++) {
                g.setColor(peli.getRuudukko().getRuutu(i, j).getVari().varinVari());
                g.fillRect(i*ruudunLeveys, j*ruudunLeveys, ruudunLeveys, ruudunLeveys);
                g.setColor(Color.BLACK);
                g.drawRect(i*ruudunLeveys, j*ruudunLeveys, ruudunLeveys, ruudunLeveys);
                
            }
        }
    }
    
}
