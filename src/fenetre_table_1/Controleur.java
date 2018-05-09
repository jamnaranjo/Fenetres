/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetre_table_1;

import java.util.Vector;

/**
 *
 * @author jalvaro
 */
public class Controleur {
    
    public static Vector<String> creerListeColonnes() {
        Vector<String> colonnes = new Vector<String>();

        colonnes.add("NUMERO");
        colonnes.add("NOM");
        colonnes.add("ADRESSE");
        colonnes.add("CODE_POSTAL");
        colonnes.add("VILLE");
        colonnes.add("CODE_SECTEUR");

        return colonnes;
    }
    
    public static Vector<Vector<Object>> creerListeLignes() {
        Vector<Vector<Object>> lignes = new Vector<Vector<Object>>();
        Vector<Object> ligne;
        
        ligne = new Vector<Object>();
        ligne.add(new Integer(100));
        ligne.add("AIGLE");
        ligne.add("Rue des couronnes");
        ligne.add("94000");
        ligne.add("CRETEIL");
        ligne.add("1");
        lignes.add(ligne);
        
        ligne = new Vector<Object>();
        ligne.add("101");
        ligne.add("VAUTOUR");
        ligne.add("AVenue du centre-ville");
        ligne.add("94100");
        ligne.add("SAINT MAUR");
        ligne.add("3");
        lignes.add(ligne);
        
        ligne = new Vector<Object>();
        ligne.add("103");
        ligne.add("MERLE");
        ligne.add("Rue Aristide Briant");
        ligne.add("92120");
        ligne.add("VANVES");
        ligne.add("3");
        lignes.add(ligne);

        return lignes;
    }
    
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                            Fenetre fenetre = new Fenetre(
                                "Fenetre table 1",
                                creerListeColonnes(),
                                creerListeLignes());
                }
            }
        );
    }
}