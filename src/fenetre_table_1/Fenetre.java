/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetre_table_1;

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
                    Vector<String> colonnes,
                    Vector<Vector<Object>> lignes) {
        super(s);
        addWindowListener(new EcouteFenetre());
        
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setPreferredSize(new Dimension(500, 120));
        
        table = new JTable(lignes, colonnes);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        defileur = new JScrollPane(table);
        defileur.getViewport().setBackground(Color.pink);
        panneauFond.add(defileur);
        getContentPane().add(panneauFond);
        pack();
        setVisible(true);
    }
}
