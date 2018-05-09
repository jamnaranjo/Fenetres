/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout_cases_gridlayout;

import fenetres.EcouteFenetre;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jalvaro
 */
public class Fenetre extends JFrame implements ActionListener {

    public JPanel panneauFond;
    
    public JPanel panneauCase1;
    public JCheckBox check1;
    public JLabel label1;
    
    public JPanel panneauCase2;
    public JCheckBox check2;
    public JLabel label2;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());

        panneauFond = new JPanel();
        panneauFond.setLayout(new GridLayout(2, 1));
        
        panneauCase1 = new JPanel();
        check1 = new JCheckBox("Case 1 non séléctionnée");
        check1.addActionListener(this);
        check1.setToolTipText("État de la première case");
        panneauCase1.add(check1);
        
        panneauCase2 = new JPanel();
        check2 = new JCheckBox("Case 2 non séléctionnée");
        check2.addActionListener(this);
        check2.setToolTipText("État de la deuxième case");
        panneauCase2.add(check2);
        
        panneauFond.add(check1);
        panneauFond.add(check2);
        add(panneauFond);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check1) {
            if(check1.isSelected()) {
                check1.setText("Case 1 sélectionnée");
            } else {
                check1.setText("Case 1 non séléctionnée");
            }
        } else if (e.getSource() == check2) {
            if(check2.isSelected()) {
                check2.setText("Case 2 sélectionnée");
            } else {
                check2.setText("Case 2 non sélectionnée");
            }
        }
    }
}
