package peli.gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import peli.domain.Suunta;
import peli.keto.Peli;

/**
 * Luokka tarjoaa metodit näppäimistönpainallusten kuunteluun.
 * @author noora
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Peli peli;
    private Component component;

    public Nappaimistonkuuntelija(Peli peli, Component component) {
        this.peli = peli;
        this.component = component;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                peli.siirto(Suunta.YLOS);
                component.repaint();
                break;
            case KeyEvent.VK_DOWN:
                peli.siirto(Suunta.ALAS);
                component.repaint();
                break;
            case KeyEvent.VK_LEFT:
                peli.siirto(Suunta.VASEN);
                component.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                peli.siirto(Suunta.OIKEA);
                component.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
