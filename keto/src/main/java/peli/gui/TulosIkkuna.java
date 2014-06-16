
package peli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import peli.huipputulokset.Tulos;
import peli.huipputulokset.Tuloslista;
import peli.keto.Peli;

public class TulosIkkuna implements ActionListener {
    private Tuloslista lista;
    
    public TulosIkkuna(Peli peli){
        this.lista = peli.getTuloslista();
    }
    
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
