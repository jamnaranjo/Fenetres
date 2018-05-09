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
public class Controleur {
    private static Fenetre fenetre;
    private static ContactDAO contactDAO;
    
    public static Vector<Contact> getContacts() {
        return contactDAO.creerListeContacts();
    }
    
    public static Vector<Colonne> getColonnes() {
        return contactDAO.creerListeColonnes();
    }
    
    public static void montrerBilanTable(Vector<Contact> listeContacts,
                                    Vector<Contact> listeSupprimes,
                                    Vector<Contact> listeModifies,
                                    Vector<Contact> listeInseres) {
        System.out.println("\n");
        System.out.println("Liste de contacts: ");
        for(Contact c : listeContacts) {
            System.out.println("\t" + c);
        }
        System.out.println("Liste de contacts suprimés: ");
        for(Contact c : listeSupprimes) {
            System.out.println("\t" + c);
        }
        System.out.println("Liste de contacts modifiés: ");
        for(Contact c : listeModifies) {
            System.out.println("\t" + c);
        }
        System.out.println("Liste de contacts inserés: ");
        for(Contact c : listeInseres) {
            System.out.println("\t" + c);
        }
        System.out.println("\n");
    }
    
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                            fenetre = new Fenetre(
                                                "Projet GestionContactLocal");
                }
            }
        );
    }
}