

package peli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import peli.keto.Peli;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Peli peli;
    private int ruudunLeveys;
    private JMenuBar menubar;
    private Piirtoalusta piirtoalusta;
    
    public Kayttoliittyma(Peli peli, int ruudunLeveys) {
        this.peli = peli;
        this.ruudunLeveys = ruudunLeveys;
        
    }

    @Override
    public void run() {
        frame = new JFrame("Keto");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container contentPane) {
        piirtoalusta = new Piirtoalusta(peli, ruudunLeveys);
        contentPane.add(piirtoalusta);
        
        frame.addKeyListener(new Nappaimistonkuuntelija(peli, piirtoalusta));
        
        JMenu menu = new JMenu("Peli");
        menubar = new JMenuBar();
        menubar.add(menu);
        
        JMenuItem uusiPeli = new JMenuItem("Uusi peli");
        uusiPeli.addActionListener(new PeliKuuntelija(peli));
        menu.add(uusiPeli);
        
        frame.setJMenuBar(menubar);
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
    public Paivitettava getPaivitettava() {
        return this.piirtoalusta;
    }
}