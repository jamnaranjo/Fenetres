/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesUtilitairesMG;

import java.util.Vector;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author jalvaro
 */
public class ModeleColonneTable extends DefaultTableColumnModel {

    private int tailleCaractere = 10;
    private int nombreCaracteresMin = 8;
    private int nombreCaracteresMax = 20;
    private Vector<Colonne> listeColonnes;
    
    public ModeleColonneTable(Vector<Colonne> listeColonnes,
                                int tailleCaractere) {
        this.listeColonnes = listeColonnes;
        this.tailleCaractere = tailleCaractere;
        creerColonnes();
    }
    
    public ModeleColonneTable(Vector<Colonne> listeColonnes) {
        this.listeColonnes = listeColonnes;
        creerColonnes();
    }
  
    public void creerColonnes() {
        TableColumn colonne;

        String nomColonne;
        int nombreCaracteresColonne;
        String typeColonne;
        int nombreCaracteresAff;

        for(int index = 0; index < listeColonnes.size(); index++) {
            colonne = new TableColumn(index);
            nomColonne = listeColonnes.elementAt(index).getNom();
            nombreCaracteresColonne = 
                    listeColonnes.elementAt(index).getLongueur();
            typeColonne = listeColonnes.elementAt(index).getType();
            colonne.setHeaderValue(nomColonne);
            
            nombreCaracteresAff = nombreCaracteresColonne;
            if(nombreCaracteresAff > nombreCaracteresMax) {
                nombreCaracteresAff = nombreCaracteresMax;
            }
            if (nombreCaracteresAff < nombreCaracteresMin) {
                nombreCaracteresAff = nombreCaracteresMin;
            }
            colonne.setPreferredWidth(nombreCaracteresAff * tailleCaractere);
            addColumn(colonne);
        }
    }


    public void setNombreCaracteresMin(int nombreCaracteresMin) {
        this.nombreCaracteresMin = nombreCaracteresMin;
    }

    public void setNombreCaracteresMax(int nombreCaracteresMax) {
        this.nombreCaracteresMax = nombreCaracteresMax;
    }
    
    public void setTailleColonne(int c, int taille) {
        getColumn(c).setPreferredWidth(taille * tailleCaractere);
    }
}
