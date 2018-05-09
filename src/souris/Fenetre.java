/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package souris;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JFrame;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame
        implements MouseListener, MouseWheelListener, MouseMotionListener {
    
    private static String[] titres = {
        "Déplacement vertical", "Déplacement horizontal"};
    private int titreIndexActuel = 0;
    private Point emplacement;
    private MouseEvent pressed;
    
    public Fenetre() {
        super();
        this.setTitle(titres[titreIndexActuel]);
        this.addWindowListener(new EcouteFenetre());
        this.addMouseListener(this);
        this.addMouseWheelListener(this);
        this.addMouseMotionListener(this);
        setBounds(400, 400, 300, 200);
        setLocation(100, 200);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Fenetre.mouseClicked");
        alternerTitre();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Fenetre.mousePressed");
        pressed = e;
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Fenetre.mouseReleased");
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Fenetre.mouseEntered");
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Fenetre.mouseExited");
    }

    // TODO: bug, le nouvel emplacement n'est pas correctement calculé
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Point location  = getLocation();
        
        if (titreIndexActuel % 2 == 0) {
            // movement vertical
            setLocation(location.x, location.y + e.getUnitsToScroll());
        }
        else {
            //movement horizontal
            setLocation(location.x + e.getUnitsToScroll(), location.y);
        }
    }

    //TODO: bug, le déplacement "saute" à l'improviste
    @Override
    public void mouseDragged(MouseEvent e) {
        Component component = e.getComponent();
        emplacement = component.getLocation(emplacement);
        int x = emplacement.x - pressed.getX() + e.getX();
        int y = emplacement.y - pressed.getY() + e.getY();
        component.setLocation(x, y);
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
       
    private void alternerTitre() {
        titreIndexActuel = (titreIndexActuel + 1) % 2;
        this.setTitle(titres[titreIndexActuel]);
    }
}