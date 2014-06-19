
package peli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka tarjoaa metodin pelin lopettamiseen.
 * @author noora
 */
class LopetaPeliKuuntelija implements ActionListener {

    public LopetaPeliKuuntelija() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
