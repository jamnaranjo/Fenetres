/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionContactLocal;

import MesUtilitairesMG.Colonne;
import MesUtilitairesMG.Contact;
import java.util.Vector;

/**
 *
 * @author jalvaro
 */
public class ContactDAO {
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
}
