/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicks_souris_permanents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame {
    private Panneau panneauDessinGauche;
    private Panneau panneauDessinDroite;
    
    public Fenetre(String s) {
        super(s);
        
        this.setLayout(new FlowLayout());
                
        panneauDessinGauche = new Panneau();
        panneauDessinGauche.setBackground(Color.white);
        panneauDessinGauche.setDrawingColor(Color.black);
        panneauDessinGauche.setPreferredSize(new Dimension(250, 150));                

        panneauDessinDroite = new Panneau();
        panneauDessinDroite.setBackground(Color.black);
        panneauDessinDroite.setDrawingColor(Color.white);
        panneauDessinDroite.setPreferredSize(new Dimension(250, 150));                
  
        add(panneauDessinGauche);
        add(panneauDessinDroite);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
