
package peli.gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import peli.keto.Peli;

/**
 * Luokka sisältää metodin, jonka avulla käyttäjä voi antaa nimensä ja aloittaa uuden pelin
 * @author noora
 */
public class UusiPeliKuuntelija implements ActionListener {
    
    private Peli peli;
    
    public UusiPeliKuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField nimiKentta = new JTextField(5);
        nimiKentta.setText(peli.getPelaajanNimi());
        JPanel paneeli = new JPanel();
        paneeli.add(new JLabel("Nimi: "));
        paneeli.add(nimiKentta);
        
        int tulos = JOptionPane.showConfirmDialog(null, paneeli, "Uusi peli", JOptionPane.OK_CANCEL_OPTION);
        if (tulos == JOptionPane.OK_OPTION){
            String nimi;
            try {
                if (nimiKentta.getText().contains(":")){
                    JOptionPane.showMessageDialog(null, "Nimi ei saa sisältää kaksoispistettä (:)");
                    return;
                }
                if (nimiKentta.getText().isEmpty()){
                    nimi = "pelaaja";
                } else {
                    nimi = nimiKentta.getText();
                }
                peli.uusiPeli(nimi);
            }
            catch (HeadlessException ex){
            }
        }
    }
    
}
