/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesUtilitairesMG;

/**
 *
 * @author jalvaro
 */
public class Colonne {
    private String nom;
    private int longueur;
    private String type;
    
    public Colonne(String nom, int longueur, String type) {
        this.nom = nom;
        this.longueur = longueur;
        this.type = type;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public String getType() {
        return this.type;
    }
    
    public int getLongueur() {
        return this.longueur;
    }
    
    public String toStrign() {
        return "Nom      " + nom + "\n" +
               "Longueur " + longueur + "\n" +
               "Type     " + type + "\n\n";
    }
    
}
