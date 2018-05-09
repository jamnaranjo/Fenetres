/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetre_table_2;

import MesUtilitairesMG.Colonne;
import MesUtilitairesMG.Contact;
import java.util.Vector;

/**
 *
 * @author jalvaro
 */
public class Controleur {
    
    public static Vector<Colonne> creerListeColonnes() {
        Vector<Colonne> colonnes = new Vector<Colonne>();

        colonnes.add(new Colonne("NUMERO", 5, "java.lang.Integer"));
        colonnes.add(new Colonne("NOM", 20, "java.lang.String"));
        colonnes.add(new Colonne("ADRESSE", 50, "java.lang.String"));
        colonnes.add(new Colonne("CODE_POSTAL", 5, "java.lang.String"));
        colonnes.add(new Colonne("VILLE", 20, "java.lang.String"));
        colonnes.add(new Colonne("CODE_SECTEUR", 10, "java.lang.Integer"));

        return colonnes;
    }
    
    public static Vector<Contact> creerListeContacts() {
        Vector<Contact> contacts = new Vector<Contact>();
        
        contacts.add(new Contact(new Integer(100), "AIGLE", "Rue des couronnes",
                                "94000", "CRETEIL", new Integer(1)));
        contacts.add(new Contact(new Integer(101), "VAUTOUR",
                                "Avenue du centre-ville", "94100", "SAINT MAUR",
                                new Integer(3)));
        contacts.add(new Contact(new Integer(103), "MERLE",
                                "Rue Aristide Briant", "92120", "VANVES",
                                new Integer(3)));
        return contacts;        
    }
    
    /*public static Vector<Vector<Object>> creerListeLignes() {
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
        ligne.add(new Integer(101));
        ligne.add("VAUTOUR");
        ligne.add("Avenue du centre-ville");
        ligne.add("94100");
        ligne.add("SAINT MAUR");
        ligne.add("3");
        lignes.add(ligne);
        
        ligne = new Vector<Object>();
        ligne.add(new Integer(103));
        ligne.add("MERLE");
        ligne.add("Rue Aristide Briant");
        ligne.add("92120");
        ligne.add("VANVES");
        ligne.add("3");
        lignes.add(ligne);

        return lignes;
    }*/
    
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                            Fenetre fenetre = new Fenetre(
                                "Fenetre table 1",
                                creerListeColonnes(),
                                creerListeContacts());
                }
            }
        );
    }
}