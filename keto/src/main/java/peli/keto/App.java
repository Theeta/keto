package peli.keto;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import peli.gui.Kayttoliittyma;


public class App 
{
    public static void main( String[] args )
    {
        Peli peli = new Peli(5,5);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli, 100);
        try {
            SwingUtilities.invokeAndWait(kayttoliittyma);
//        SwingUtilities.invokeLater(kayttoliittyma);
//        
//        while (kayttoliittyma.getPaivitettava() == null) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//            }
//        }
        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        peli.setPaivitettava(kayttoliittyma.getPaivitettava());
        
    }
}
