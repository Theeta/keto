
package peli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import peli.huipputulokset.Tulos;
import peli.huipputulokset.Tuloslista;
import peli.keto.Peli;

/**
 * Luokka sisältää metodit huipputulosten esittämiseksi ikkunassa.
 * @author noora
 */
public class TulosIkkuna implements ActionListener {
    private Tuloslista lista;
    
    /**
     * Konstruktorissa asetetaan tuloslistaksi kyseisen pelin tuloslista.
     * @param peli Käynnissä oleva peli
     */
    public TulosIkkuna(Peli peli){
        this.lista = peli.getTuloslista();
    }
    
    /**
     * Metodia käytetään muuttamaan tuloslistan sisältämä tieto ruudulla esitettävään muotoon.
     * @return Palauttaa tuloslistan esittevässä muodossa
     */
    private String tulostenTulostus(){
        String palautus = "";
        int n = 1;
        for (Tulos t : lista.getLista()){
            palautus += n + ": " + t.getNimi() +" "+ t.getPisteet() + "\n";
            n++;
        }
        return palautus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, tulostenTulostus(), "Tulokset", JOptionPane.PLAIN_MESSAGE);
    }
    
}
