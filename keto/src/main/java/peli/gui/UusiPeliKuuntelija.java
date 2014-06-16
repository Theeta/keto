
package peli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import peli.keto.Peli;

public class UusiPeliKuuntelija implements ActionListener {
    
    private Peli peli;
    
    public UusiPeliKuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        JTextField kokoKentta = new JTextField(5);
//        kokoKentta.setText("5");
        JTextField nimiKentta = new JTextField(5);
        nimiKentta.setText("pelaaja");
        JPanel paneeli = new JPanel();
//        paneeli.add(new JLabel("Pelin koko: "));
//        paneeli.add(kokoKentta);
        paneeli.add(new JLabel("Nimi: "));
        paneeli.add(nimiKentta);
        
        int tulos = JOptionPane.showConfirmDialog(null, paneeli, "Uusi peli", JOptionPane.OK_CANCEL_OPTION);
        if (tulos == JOptionPane.OK_OPTION){
            String nimi;
            try {
                if (nimiKentta.getText().contains(":")){
                    nimi = nimiKentta.getText().replace(":", " ");
                }
                if (nimiKentta.getText().isEmpty()){
                    nimi = "pelaaja";
                } else {
                    nimi = nimiKentta.getText();
                }
                peli.uusiPeli(nimi);
            }
            catch (Exception ex){
                System.out.println("Ei saatu uutta peliä");
            }
        }
    }
    
}
