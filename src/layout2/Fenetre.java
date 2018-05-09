/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import fenetres.EcouteFenetre;
import java.awt.BorderLayout;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame {
    private JPanel panneauFond;
    
    private JPanel panneauNord;
    private JPanel panneauSud;
    private JPanel panneauEst;
    private JPanel panneauOuest;
    private JPanel panneauCentre;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        
        panneauNord = new JPanel();
        panneauNord.setBackground(Color.white);
        panneauSud = new JPanel();
        panneauSud.setBackground(Color.white);
        panneauEst = new JPanel();
        panneauEst.setBackground(Color.black);
        panneauOuest = new JPanel();
        panneauOuest.setBackground(Color.black);
        panneauCentre = new JPanel();
        panneauCentre.setBackground(Color.pink); 
    
        panneauFond.add(panneauNord, BorderLayout.NORTH);
        panneauFond.add(panneauSud, BorderLayout.SOUTH);
        panneauFond.add(panneauEst, BorderLayout.EAST);
        panneauFond.add(panneauOuest, BorderLayout.WEST);
        panneauFond.add(panneauCentre, BorderLayout.CENTER);
    
        add(panneauFond);
        //add();
        setBounds(400, 400, 300, 200);
        setVisible(true);
    }

    /*
     * Alternative : on epargne panneauFond en ajoutant les differents panneaux
     * directement à this
     */
    /*public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());
        this.setLayout(new BorderLayout());
        
        panneauNord = new JPanel();
        panneauNord.setBackground(Color.white);
        panneauSud = new JPanel();
        panneauSud.setBackground(Color.white);
        panneauEst = new JPanel();
        panneauEst.setBackground(Color.black);
        panneauOuest = new JPanel();
        panneauOuest.setBackground(Color.black);
        panneauCentre = new JPanel();
        panneauCentre.setBackground(Color.pink); 
    
        add(panneauNord, BorderLayout.NORTH);
        add(panneauSud, BorderLayout.SOUTH);
        add(panneauEst, BorderLayout.EAST);
        add(panneauOuest, BorderLayout.WEST);
        add(panneauCentre, BorderLayout.CENTER);
    
        setBounds(400, 400, 300, 200);
        setVisible(true);
    }*/  
}
