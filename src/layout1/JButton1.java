/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout1;

/**
 *
 * @author jalvaro
 */
public class JButton1 {
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                            Fenetre fenetre = new Fenetre(
                                "JButton1 : 2 boutons");
                }
            }
        );
    }
}