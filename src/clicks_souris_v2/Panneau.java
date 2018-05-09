/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicks_souris_v2;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Panneau extends JPanel implements MouseListener {

    private boolean start = true;
    private int posX;
    private int posY;
    
    public Panneau() {
        super();
        addMouseListener(this);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(start == false) {
            g.fillRect(posX - 4, posY - 4, 8, 8);
        }
    }

    private void setPosXY(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        start = false;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
       setPosXY(e.getX(), e.getY());
       repaint();
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