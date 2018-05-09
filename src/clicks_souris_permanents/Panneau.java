/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicks_souris_permanents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Panneau extends JPanel implements MouseListener {

    private int MAX_POINTS = 5;
    
    private Vector<Point> points;    
    private Color drawingColor;
    
    public Panneau() {
        super();
        points = new Vector<Point>();
        drawingColor = Color.yellow;
        addMouseListener(this);
    }

    public void setDrawingColor(Color drawingColor) {
        this.drawingColor = drawingColor;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(drawingColor);
        for(Point p : points) {
            g.fillRect(p.x - 4, p.y - 4, 8, 8);
        }
    }
    
    private void addPoint(Point p) {
        if(points.size() == MAX_POINTS) {
            points.clear();
        }
        points.add(p);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
       addPoint(new Point(e.getX(), e.getY()));
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