/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicks_souris_v1;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Panneau extends JPanel {

    private boolean start = true;
    private int posX;
    private int posY;
    
    public void setPosXY(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        start = false;
    }
    
    public void paintComponent(Graphics g) {
        System.out.println("paintComponent");
        super.paintComponent(g);
        if(start == false) {
            g.fillRect(posX - 4, posY - 4, 8, 8);
        }
    }

}