/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout3;

import fenetres.EcouteFenetre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements ActionListener{
    
    private JPanel panneauFond;
    
    private JPanel panneauCentre;
    private JButton monBouton1;
    private JButton monBouton2;
    
    private JPanel panneauSud;
    private JLabel message;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());
        
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        
        panneauCentre = new JPanel();
        panneauCentre.setBackground(Color.yellow);
        
        monBouton1 = new JButton("FAUCON");
        monBouton2 = new JButton("BONDREE APIVORE");
        
        monBouton1.addActionListener(this);
        monBouton2.addActionListener(this);
        
        panneauCentre.add(monBouton1);
        panneauCentre.add(monBouton2);
        
        unifieTailleComposants(panneauCentre);
        
        panneauSud = new JPanel();
        panneauSud.setBackground(Color.white);
        
        message = new JLabel(" ");
        panneauSud.add(message);
        
        panneauFond.add(panneauCentre, BorderLayout.CENTER);
        panneauFond.add(panneauSud, BorderLayout.SOUTH);
        add(panneauFond);
        
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == monBouton1) {
            message.setText(" Vous avez choisi le bouton "
                    + e.getActionCommand() + "."); 
        } else {
            message.setText("Elle mange sans doute des abeilles !");
        }
    }
    
    private void unifieTailleComposants(Container racine) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        synchronized(racine.getTreeLock()) {
            Component[] components = racine.getComponents();
            for(Component c : components) {
                if(c.getPreferredSize().width > maxWidth) {
                    maxWidth = c.getPreferredSize().width;
                }
                if(c.getPreferredSize().height > maxHeight) {
                    maxHeight = c.getPreferredSize().height;
                }
            }
            for(Component c : components) {
                c.setPreferredSize(new Dimension(maxWidth, maxHeight));
            }
        }
    }
}
