/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamique_checkboxes;

import fenetres.EcouteFenetre;
import utilitairesMG.graphique.FlowLayoutMG;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements ActionListener {
    
    private JPanel panneauFond;
    
    private JPanel panneauSpin;
    private JLabel spinLabel;
    private JSpinner spinner;
    private int nombreCheckboxes = 5;
    
    private JPanel panneauExec;
    private JButton boutonExec;
    
    private JScrollPane scrollCheckboxes;
    private JPanel panneauCheckboxes;

    private JPanel panneauEtat;
    private JButton boutonEtat;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());
        panneauFond = new JPanel(new GridLayout(4, 1));
    
        panneauSpin = new JPanel(new FlowLayout(FlowLayout.CENTER));
        spinLabel = new JLabel("Nombre de JCheckBox à créer");
        spinner = new JSpinner(new SpinnerNumberModel(nombreCheckboxes, 0, 50, 1));
        
        panneauSpin.add(spinLabel);
        panneauSpin.add(spinner);
        
        panneauExec = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boutonExec = new JButton("EXECUTER");
        boutonExec.addActionListener(this);
        panneauExec.add(boutonExec);
    
        //panneauCheckboxes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panneauCheckboxes = new JPanel(new FlowLayoutMG());
        resetPanneauCheckboxes();
        scrollCheckboxes = new JScrollPane(panneauCheckboxes);

        panneauEtat = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boutonEtat = new JButton("ETAT");
        boutonEtat.addActionListener(this);
        panneauEtat.add(boutonEtat);
        
        panneauFond.add(panneauSpin);
        panneauFond.add(panneauExec);
        panneauFond.add(scrollCheckboxes);
        panneauFond.add(panneauEtat);
        add(panneauFond);
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boutonExec) {
            nombreCheckboxes = (Integer)spinner.getValue();
            resetPanneauCheckboxes();
        } else if(e.getSource() == boutonEtat) {
            imprimerEtat();
        }
    }

    private void resetPanneauCheckboxes() {
        panneauCheckboxes.removeAll();
        
        for(int i = 0; i < nombreCheckboxes; i++) {
            panneauCheckboxes.add(new JCheckBox("Case " + (i+1)));
        }
        
        panneauCheckboxes.validate();
        panneauCheckboxes.revalidate();
        panneauCheckboxes.repaint();
    }

    private void imprimerEtat() {
        for(Component cb : panneauCheckboxes.getComponents()) {
            if(((JCheckBox)cb).isSelected()) {
                System.out.println(((JCheckBox)cb).getText() + " selectionnée");
            } else {
                System.out.println(((JCheckBox)cb).getText() + " non selectionnée");
            }
        }
    }
    
}
