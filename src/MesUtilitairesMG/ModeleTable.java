/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesUtilitairesMG;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jalvaro
 */
public class ModeleTable extends AbstractTableModel {
    protected Vector<Vector<Object>> listeLignes;
    protected Vector<Colonne> listeColonnes;
    protected Vector<Vector<Object>> listeLignesSupprimes;
    
    // ' ' - ligne pas modifiée
    // 'M' - ligne modifiée
    // 'I' - ligne inserée
    private Vector<Character> modificationLignes;

    public ModeleTable() {
        listeLignesSupprimes = new Vector<Vector<Object>>();
    }
    
    public ModeleTable(Vector<Vector<Object>> listeLignes,
                        Vector<Colonne> listeColonnes) {
        this.listeColonnes = listeColonnes;
        this.listeLignes = listeLignes;        
        listeLignesSupprimes = new Vector<Vector<Object>>();
    }
        
    public int getRowCount() {
        // +1 rends une ligne blanche à la fin pour des nouvelles insertions
        return listeLignes.size() + 1;
    }
    
    public int getColumnCount() {
        return listeColonnes.size();
    }
    
    public Object getValueAt(int lig, int col) {
        if(lig < this.listeLignes.size()) {
            return listeLignes.get(lig).get(col);
        } else {
            // for final insertion line
            return null;
        }
    }
    
    public void setValueAt(Object valeur, int lig, int col) {
        if(lig < listeLignes.size()) {
            listeLignes.elementAt(lig).setElementAt(valeur, col);
            setLigneModifiee(lig);
        } else {
            if(valeur != null) {
                Vector<Object> ligne = new Vector<Object>();
                for(int iCol = 0; iCol < listeColonnes.size(); iCol++) {
                    ligne.addElement(null);
                }
                listeLignes.addElement(ligne);
                ligne.setElementAt(valeur, col);
                ajouteLigneInseree();
            }
        }
    }
    
    public Class getColumnClass(int col) {
        try {
            return Class.forName(listeColonnes.elementAt(col).getType());
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
    
    public String getColumnName(int col) {
        return listeColonnes.elementAt(col).getNom();
    }

    public Vector<Vector<Object>> getListeLignes() {
        return listeLignes;
    }

    public void setListeLignes(Vector<Vector<Object>> listeLignes) {
        this.listeLignes = listeLignes;
        initModificationLignes();
    }

    public Vector<Colonne> getListeColonnes() {
        return listeColonnes;
    }

    public void setListeColonnes(Vector<Colonne> listeColonnes) {
        this.listeColonnes = listeColonnes;
    }
    
    public Vector<Character> getModificationLignes() {
        return modificationLignes;
    }
    
    public boolean isCellEditable(int lig, int col) {
        return true;
    }
    
    public String modificationLignesToString() {
        return modificationLignes.toString();
    }
    
    public void setLigneModifiee(int indexLigne) {
        if(modificationLignes.get(indexLigne) != 'I') {
            modificationLignes.setElementAt('M', indexLigne);
        }
    }
    
    public void ajouteLigneInseree() {
        modificationLignes.add('I');
    }
    
    public void setLigneSuprimee(int indexLigne) {
        listeLignesSupprimes.add(listeLignes.get(indexLigne));
        listeLignes.remove(indexLigne);
        modificationLignes.remove(indexLigne);
    }
    
    public Vector<Vector<Object>> getListeLignesSupprimes() {
        return listeLignesSupprimes;
    }
    
    public void restaurerSupprimes() {
        for(int i = listeLignesSupprimes.size()-1; i >= 0; i--) {
            listeLignes.add(listeLignesSupprimes.get(i));
            listeLignesSupprimes.remove(i);
            modificationLignes.add(' ');
        }
    }
    
    private void initModificationLignes() {
        modificationLignes = new Vector<Character>();

        if(listeLignes != null) {
            for(int i = 0; i < listeLignes.size(); i++) {
                modificationLignes.add(' ');
            }
        }
    }
}
