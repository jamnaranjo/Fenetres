/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dessins_repaint;

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
                                "Rectangles et ovales");
                }
            }
        );
    }
}