package peli.keto;

import javax.swing.SwingUtilities;
import peli.gui.Kayttoliittyma;


public class App 
{
    public static void main( String[] args )
    {
        Peli peli = new Peli(6,6);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli, 100);
        SwingUtilities.invokeLater(kayttoliittyma);
        
        while (kayttoliittyma.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }

        peli.setPaivitettava(kayttoliittyma.getPaivitettava());
        
    }
}
