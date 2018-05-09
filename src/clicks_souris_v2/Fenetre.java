/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicks_souris_v2;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame {
    private Panneau panneauDessin;
    
    public Fenetre(String s) {
        super(s);
                
        panneauDessin = new Panneau();
        panneauDessin.setPreferredSize(new Dimension(250, 150));                
        add(panneauDessin);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
