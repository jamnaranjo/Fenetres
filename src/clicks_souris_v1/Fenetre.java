/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicks_souris_v1;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements MouseListener {
    private Panneau panneauDessin;
    
    public Fenetre(String s) {
        super(s);
                
        panneauDessin = new Panneau();
        panneauDessin.setPreferredSize(new Dimension(250, 150));                
        add(panneauDessin);
        addMouseListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        panneauDessin.setPosXY(e.getX(), e.getY());
        panneauDessin.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
