/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamique_ajoute_boutton;

import fenetres.EcouteFenetre;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements ActionListener {
    
    private JScrollPane defileur;
    private JPanel panneauFond;
    private JButton bAjoute;
    private int numeroBouton = 1;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());
        
        panneauFond = new JPanel(new FlowLayout());
        
        bAjoute = new JButton("AJOUTE");
        bAjoute.addActionListener(this);
        
        panneauFond.add(bAjoute);
        defileur = new JScrollPane(panneauFond);
        add(defileur);
        
        //setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bAjoute) {
            JButton bNouveau = new JButton("BOUTON " + numeroBouton);
            bNouveau.addActionListener(this);
            panneauFond.add(bNouveau);
            numeroBouton++;
        } else {
            panneauFond.remove((JButton)e.getSource());
        }
        panneauFond.validate();
        panneauFond.revalidate();
        panneauFond.repaint();
    }
    
}
