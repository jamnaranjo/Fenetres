/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author jalvaro
 */
public class FenetreAutoContenue extends JFrame implements WindowListener {
    
    public FenetreAutoContenue(String titre) {
        super(titre);
        System.out.println("FenetreAutoContenue(): " + Thread.currentThread().getName());
        setBounds(100, 100, 300, 300);
        addWindowListener(this);
    }
    
    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing(event " + e.hashCode() + "), thread " + Thread.currentThread().getName());
        System.exit(0);
    }
    
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated(event " + e.hashCode() + "), thread " + Thread.currentThread().getName());
    }
    
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed(event " + e.hashCode() + "), thread " + Thread.currentThread().getName());
    }
    
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated(event " + e.hashCode() + "), thread " + Thread.currentThread().getName());
    }
    
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified(event " + e.hashCode() + "), thread " + Thread.currentThread().getName());
    }
    
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified(event " + e.hashCode() + "), thread " + Thread.currentThread().getName());
    }
    
    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpenened(event " + e.hashCode() + "), thread " + Thread.currentThread().getName());
    }
}
