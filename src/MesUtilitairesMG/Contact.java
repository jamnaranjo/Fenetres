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
public class Contact {
    
    private Integer numero;
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private Integer codeSecteur;
    
    public Contact(Integer numero, String nom, String adresse,
                    String codePostal, String ville, Integer codeSecteur) {
        this.numero = numero;
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.codeSecteur = codeSecteur;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodeSecteur() {
        return codeSecteur;
    }

    public void setCodeSecteur(Integer codeSecteur) {
        this.codeSecteur = codeSecteur;
    }
    
    public String toString() {
        return "(" + numero + ", " + nom + ", " + adresse + ", " + codePostal +
                ", " + ville + ", " + codeSecteur + ")";   
    }
}
