/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessins_repaint;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Panneau extends JPanel {
    
    private boolean dessinRect = false;
    private boolean dessinOvale = false;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(dessinRect) {
            g.drawRect(65, 45, 120, 60);
        }
        if(dessinOvale) {
            g.drawOval(65, 45, 120, 60);
        }
    }
    
    public void setRect() {
        dessinRect = true;
        dessinOvale = false;
    }
    
    public void setOvale() {
        dessinRect = false;
        dessinOvale = true;
    }
}