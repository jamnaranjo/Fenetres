/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout_cases_gridlayout;

import layout_cases_borderlayout.*;

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
                                "JButtonLabel");
                }
            }
        );
    }
}