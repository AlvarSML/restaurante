/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.*;
import javax.swing.JPanel;
import restaurante.bdd;

/**
 *
 * @author alvar
 */
public class nMesa {
    
    private JFrame frm = new JFrame("Reserva");
    private JPanel pnl = new JPanel();
    
    private JLabel titulo = new JLabel("Nueva mesa");
    
    private JLabel forma = new JLabel("Forma");
    private JComboBox tforma = new JComboBox();
    
    
    
    public nMesa() {
        //frame
        frm.setBounds(200, 200, 400, 400);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pnl.setLayout(null);

        // se añade el panel al frame
        frm.add(pnl);
        frm.setVisible(true);

        // elementos
        titulo.setBounds(70, 20, 100, 20);
        pnl.add(titulo);
        
        forma.setBounds(20, 60, 100, 20);
        pnl.add(forma);
        
        tforma.setBounds(20, 80, 120, 20);
        pnl.add(tforma);
        tforma.setModel(new DefaultComboBoxModel(new bdd().formas()));
    }
}
