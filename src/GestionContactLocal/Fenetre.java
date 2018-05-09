/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionContactLocal;

import MesUtilitairesMG.Colonne;
import MesUtilitairesMG.Contact;
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements ActionListener{
    
    private JDesktopPane panneauFond;
    private FenetreInterneContact fenetreInterne;
    
    private JMenuBar barreMenu;
    private JMenu menuTables;
    private JMenuItem itemContact;
    private JMenuItem itemVersement;
    private JMenuItem itemSecteur;
    
    private Vector<Contact> lignes;
    private Vector<Colonne> colonnes;
    
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());

        panneauFond = new JDesktopPane();
        panneauFond.setLayout(new FlowLayout());
        panneauFond.setPreferredSize(new Dimension(1000, 500));
        
        initializeMenu();
        
        /*panneauFond = new JPanel();
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
        getContentPane().add(panneauFond);*/

        add(panneauFond);
        pack();
        setVisible(true);
    }
    
    private void initializeMenu() {
        barreMenu = new JMenuBar();
        menuTables = new JMenu("Tables");
        menuTables.setMnemonic(KeyEvent.VK_T);
        itemContact = new JMenuItem("Contact");
        itemContact.setMnemonic(KeyEvent.VK_C);
        itemVersement = new JMenuItem("Versement");
        itemVersement.setMnemonic(KeyEvent.VK_V);
        itemSecteur = new JMenuItem("Secteur");
        itemSecteur.setMnemonic(KeyEvent.VK_S);
        
        itemContact.addActionListener(this);
        itemVersement.addActionListener(this);
        itemSecteur.addActionListener(this);
        
        menuTables.add(itemContact);
        menuTables.add(itemVersement);
        menuTables.add(itemSecteur);
        barreMenu.add(menuTables);
        
        setJMenuBar(barreMenu);        
    }
    
    public void setContenusTable(Vector<Contact> lignes,
                                Vector<Colonne> colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemContact) {
            if(fenetreInterne == null  || fenetreInterne.isClosed() == true) {
                fenetreInterne = new FenetreInterneContact(
                                                    "CONTACTS",
                                                    Controleur.getContacts(),
                                                    Controleur.getColonnes());
                panneauFond.add(fenetreInterne);
            }
        } else if(e.getSource() == itemVersement) {
            JOptionPane.showMessageDialog(panneauFond,
                                        "Gestion de versements non realisée",
                                        "Information",
                                        JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource() == itemSecteur) {
            JOptionPane.showMessageDialog(panneauFond,
                                        "Gestion de secteurs non realisée",
                                        "Information",
                                        JOptionPane.INFORMATION_MESSAGE);        
        }
    }
}
