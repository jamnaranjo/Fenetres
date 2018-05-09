/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import fenetres.EcouteFenetre;
import java.awt.Dimension;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements ActionListener {
    private JPanel panneauFond;
    private JButton bouton1;
    private JButton bouton2;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());
        panneauFond = new JPanel();
        panneauFond.setBackground(Color.black);
        bouton1 = new JButton("BLANC");
        bouton1.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 40));
        bouton2 = new JButton("Couleur initiale : NOIR");
        bouton1.addActionListener(this);
        bouton2.addActionListener(this);
        ajusterTailleBoutons();
        panneauFond.add(bouton1);
        panneauFond.add(bouton2);
        add(panneauFond);
        pack();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        pack();
        if (e.getSource() == bouton1) {
            panneauFond.setBackground(Color.white);
        } else {
            panneauFond.setBackground(Color.black);
        }
    }
    
    private void ajusterTailleBoutons() {
        int maxWidth;
        int maxHeight;
        
        maxWidth = bouton1.getPreferredSize().width >
            bouton2.getPreferredSize().width ?
                bouton1.getPreferredSize().width :
                bouton2.getPreferredSize().width;
        maxHeight = bouton1.getPreferredSize().height >
            bouton2.getPreferredSize().height ?
                bouton1.getPreferredSize().height :
                bouton2.getPreferredSize().height;
        bouton1.setPreferredSize(new Dimension(maxWidth, maxHeight));
        bouton2.setPreferredSize(new Dimension(maxWidth, maxHeight));
    }
}
