/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package souris;

import javax.swing.SwingUtilities;

/**
 *
 * @author jalvaro
 */
public class SourisMain {
    
    public static void main(String args[]) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Fenetre maFenetre = new Fenetre();
                maFenetre.setVisible(true);
            }
        });
    }
}
