/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicks_souris_v2;

import clicks_souris_v1.*;
import dessins_repaint.*;
import layout_cases_gridlayout.*;
import layout_cases_borderlayout.*;

/**
 *
 * @author jalvaro
 */
public class Main {
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                            Fenetre fenetre = new Fenetre(
                                "Click de souris v2");
                }
            }
        );
    }
}