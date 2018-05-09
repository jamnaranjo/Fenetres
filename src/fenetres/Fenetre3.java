/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetres;

import javax.swing.*;

/**
 *
 * @author jalvaro
 */
public class Fenetre3 {

    public static void main(String args[]) {
        System.out.println("main(): " + Thread.currentThread().getName());
        /*Fenetre maFenetre;
        EcouteFenetre ecouteur;

        ecouteur = new EcouteFenetre();        
        maFenetre = new Fenetre("Troisième fenêtre");

        maFenetre.addWindowListener(ecouteur);
        maFenetre.setVisible(true);*/
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FenetreAutoContenue maFenetre2 = new FenetreAutoContenue("Fenetre autocontenue");
                maFenetre2.setVisible(true);
            }});
    }
}
