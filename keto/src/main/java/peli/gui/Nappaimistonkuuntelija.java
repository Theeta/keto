package peli.gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import peli.keto.Peli;

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
                peli.liikuYlos();
                component.repaint();
                break;
            case KeyEvent.VK_DOWN:
                peli.liikuAlas();
                component.repaint();
                break;
            case KeyEvent.VK_LEFT:
                peli.liikuVasen();
                component.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                peli.liikuOikea();
                component.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
