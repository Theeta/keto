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
        Peli peli = new Peli(5,5, "tuloslista");
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli, 100);
        try {
            SwingUtilities.invokeAndWait(kayttoliittyma);

        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        peli.setPaivitettava(kayttoliittyma.getPaivitettava());
        
    }
}
