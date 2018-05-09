/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionContactLocal;

import MesUtilitairesMG.Colonne;
import MesUtilitairesMG.Contact;
import MesUtilitairesMG.ModeleColonneTable;
import MesUtilitairesMG.ModeleTableContact;
import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author jalvaro
 */
public class FenetreInterneContact extends JInternalFrame
                                    implements ActionListener {
    
    private JPanel panneauFond;
    private JTable table;
    private JScrollPane defileur;
    
    private JMenuBar barreMenu;
    private JMenu menuEdition;
    private JMenuItem itemSupprimer;
    private JMenuItem itemRestaurer;
    
    public FenetreInterneContact(String s,
                                Vector<Contact> lignes,
                                Vector<Colonne> colonnes) {
        super(s, true, true, true, true);
 
        addInternalFrameListener(new EcouteFenetreInterneContact());
        
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setPreferredSize(new Dimension(863, 120));
        
        initializeMenu();
        
        if(lignes != null && colonnes != null) {
            table = new JTable();
            int tailleM = table.getFontMetrics(table.getFont())
                                .stringWidth("M");
            table.setModel(new ModeleTableContact(lignes, colonnes));
            table.setColumnModel(new ModeleColonneTable(colonnes, tailleM));
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            defileur = new JScrollPane(table);
            defileur.getViewport().setBackground(Color.pink);

            panneauFond.add(defileur);
        }
        add(panneauFond);
        setVisible(true);
        pack();
    }
    
    private void initializeMenu() {
        barreMenu = new JMenuBar();
        menuEdition = new JMenu("Edition");
        menuEdition.setMnemonic(KeyEvent.VK_E);
        itemSupprimer = new JMenuItem("Supprimer des lignes");
        itemSupprimer.setMnemonic(KeyEvent.VK_S);
        itemRestaurer = new JMenuItem("Restaurer les lignes supprimées");
        itemRestaurer.setMnemonic(KeyEvent.VK_R);
        itemRestaurer.setEnabled(false);
        
        itemSupprimer.addActionListener(this);
        itemRestaurer.addActionListener(this);
        
        menuEdition.add(itemSupprimer);
        menuEdition.add(itemRestaurer);
        barreMenu.add(menuEdition);
        
        setJMenuBar(barreMenu);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModeleTableContact modele = (ModeleTableContact)table.getModel();
        if(e.getSource() == itemSupprimer) {
            int[] lignesSelectionees = table.getSelectedRows();
            if(lignesSelectionees.length > 0) {
                boolean revalider = false;
                int ligneAddition = modele.getRowCount()-1;
                for(int i = 0; i < lignesSelectionees.length; i++) {
                    if(lignesSelectionees[i] == ligneAddition) {
                        continue;
                    }
                    int ligneASupprimer = Math.max(0, lignesSelectionees[i]-i);
                    modele.setLigneSuprimee(ligneASupprimer);
                    revalider = true;
                }
                if(revalider == true) {
                    itemRestaurer.setEnabled(true);
                    table.revalidate();
                }
            }
        }
        else if(e.getSource() == itemRestaurer) {
            modele.restaurerSupprimes();
            itemRestaurer.setEnabled(false);
            table.revalidate();
        }
    }
    
    private class EcouteFenetreInterneContact extends InternalFrameAdapter {
        public void internalFrameClosing(InternalFrameEvent e) {
            System.out.println("Closing!");
            
            ModeleTableContact modele = (ModeleTableContact)table.getModel();
            
            Controleur.montrerBilanTable(modele.getListeContacts(),
                                            modele.getListeContactsSupprimes(),
                                            modele.getListeContactsModifies(),
                                            modele.getListeContactsInseres());
            System.out.println("Modifications: " +
                    ((ModeleTableContact)table.getModel())
                        .modificationLignesToString());
        }
    }
}