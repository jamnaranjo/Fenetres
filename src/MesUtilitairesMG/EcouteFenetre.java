/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesUtilitairesMG;

//import fenetres.*;
import fenetre_table_1.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author jalvaro
 */
public class EcouteFenetre implements WindowListener {
    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing(event " + e.hashCode() + ")");
        System.exit(0);
    }
    
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated(event " + e.hashCode() + ")");
    }
    
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed(event " + e.hashCode() +")");
    }
    
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated(event " + e.hashCode() +")");
    }
    
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified(event " + e.hashCode() + ")");
    }
    
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified(event " + e.hashCode() + ")");
    }
    
    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpenened(event " + e.hashCode() + ")");
    }
    
}
