/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessins_trait_simple;

import fenetres.EcouteFenetre;
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
    private JPanel fond;
    private Panneau panneauFond1;
    private Panneau panneauFond2;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());
        
        fond = new JPanel(new FlowLayout());
        
        panneauFond1 = new Panneau();
        panneauFond1.setBackground(Color.yellow);
        panneauFond1.setPreferredSize(new Dimension(250, 150));
        
        panneauFond2 = new Panneau();
        panneauFond2.setBackground(Color.yellow);
        panneauFond2.setPreferredSize(new Dimension(250, 150));

        fond.add(panneauFond1);
        fond.add(panneauFond2);
        add(fond);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }
}
