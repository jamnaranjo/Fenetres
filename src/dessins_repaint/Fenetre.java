/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessins_repaint;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements ActionListener {
    private JPanel panneauFond;    
    private Panneau panneauDessin;
    private JButton boutonRect;
    private JButton boutonOvale;
    
    public Fenetre(String s) {
        super(s);
        
        panneauFond = new JPanel(new BorderLayout());
        boutonRect = new JButton("RECTANGLE");
        boutonRect.addActionListener(this);
        boutonOvale = new JButton("OVALE");
        boutonOvale.addActionListener(this);
        
        panneauDessin = new Panneau();
        panneauDessin.setPreferredSize(new Dimension(250, 150));
        
        panneauFond.add(boutonRect, BorderLayout.NORTH);
        panneauFond.add(boutonOvale, BorderLayout.SOUTH);
        panneauFond.add(panneauDessin, BorderLayout.CENTER);
        
        add(panneauFond);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boutonRect) {
            panneauDessin.setRect();
        } else if (e.getSource() == boutonOvale) {
            panneauDessin.setOvale();
        }
        panneauDessin.repaint();
    }
}
