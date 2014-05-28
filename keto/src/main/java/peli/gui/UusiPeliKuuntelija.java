
package peli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.keto.Peli;

public class UusiPeliKuuntelija implements ActionListener {
    
    private Peli peli;
    
    public UusiPeliKuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.uusiPeli();
    }
    
}
