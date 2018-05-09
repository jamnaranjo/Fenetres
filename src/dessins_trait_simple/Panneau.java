/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessins_trait_simple;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Panneau extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(15, 10, 100, 50);
    }
}
