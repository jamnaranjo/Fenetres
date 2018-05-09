/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetre_table_2;

import MesUtilitairesMG.Colonne;
import MesUtilitairesMG.Contact;
import MesUtilitairesMG.EcouteFenetre;
import MesUtilitairesMG.ModeleColonneTable;
import MesUtilitairesMG.ModeleTableContact;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame {
    private JPanel panneauFond;
    private JTable table;
    private JScrollPane defileur;
    
    public Fenetre(String s,
                    Vector<Colonne> colonnes,
                    Vector<Contact> lignes) {
        super(s);
        addWindowListener(new EcouteFenetre());
        
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setPreferredSize(new Dimension(863, 120));
        
        table = new JTable();
        int tailleM = table.getFontMetrics(table.getFont()).stringWidth("M");
        table.setModel(new ModeleTableContact(lignes, colonnes));
        table.setColumnModel(new ModeleColonneTable(colonnes, tailleM));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        defileur = new JScrollPane(table);
        defileur.getViewport().setBackground(Color.pink);
        panneauFond.add(defileur);
        getContentPane().add(panneauFond);
        pack();
        setVisible(true);
    }
}
