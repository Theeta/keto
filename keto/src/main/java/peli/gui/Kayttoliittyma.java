

package peli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import peli.keto.Peli;

/**
 * Luokka tarjoaa metodeja käyttöliittymän piirtämiseen ruudulle.
 * @author noora
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Peli peli;
    private int ruudunLeveys;
    private JMenuBar menubar;
    private Piirtoalusta piirtoalusta;
    
    /**
     * Konstruktorissa uudelle käyttöliittymälle annetaan kyseinen peli ja yhden peliruudun haluttu leveys näytöllä.
     * @param peli Kertoo kyseisen käynnissäolevan pelin.
     * @param ruudunLeveys Kertoo minkä levyinen on yksi peliruudukon ruutu.
     */
    public Kayttoliittyma(Peli peli, int ruudunLeveys) {
        this.peli = peli;
        this.ruudunLeveys = ruudunLeveys;
        
    }

    @Override
    public void run() {
        frame = new JFrame("Keto");
        //frame.setPreferredSize(new Dimension(510, 660));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodi luo käyttöliittymän tarvitsemat komponentit, piirtoalustan, näppäimistonkuuntelijan ja menubarin.
     * @param contentPane 
     */
    private void luoKomponentit(Container contentPane) {
        piirtoalusta = new Piirtoalusta(peli, ruudunLeveys);
        contentPane.add(piirtoalusta);
        
        frame.addKeyListener(new Nappaimistonkuuntelija(peli, piirtoalusta));
        
        JMenu menu = new JMenu("Peli");
        menubar = new JMenuBar();
        menubar.add(menu);
        
        JMenuItem uusiPeli = new JMenuItem("Uusi peli");
        uusiPeli.addActionListener(new UusiPeliKuuntelija(peli));
        menu.add(uusiPeli);
        
        JMenuItem huipputulokset = new JMenuItem("Huipputulokset");
        huipputulokset.addActionListener(new TulosIkkuna(peli));
        menu.add(huipputulokset);
        
        JMenuItem lopetaPeli = new JMenuItem("Lopeta");
        lopetaPeli.addActionListener(new LopetaPeliKuuntelija());
        menu.add(lopetaPeli);
        
        frame.setJMenuBar(menubar);
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
    public Paivitettava getPaivitettava() {
        return this.piirtoalusta;
    }
}
