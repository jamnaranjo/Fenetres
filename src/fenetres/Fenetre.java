/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import javax.swing.JFrame;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame {
    
    public Fenetre() {
        super();
        System.out.println("Fenetre(): " + Thread.currentThread().getName());
        setBounds(400, 400, 300, 200);
    }
}
