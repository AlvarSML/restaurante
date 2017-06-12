/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.*;


/**
 *
 * @author alvar
 */
public class nSala {
    
    private JFrame frm = new JFrame("Reserva");
    private JPanel pnl = new JPanel();
    
    private JLabel titulo = new JLabel("Nueva Sala");
    
    private JLabel rest = new JLabel("Restaurante");
    private JComboBox trest = new JComboBox();
    
    private JLabel forma = new JLabel("Forma");
    private JComboBox tforma = new JComboBox();
    
    public nSala() {
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
        
        rest.setBounds(20, 60, 100, 20);
        pnl.add(rest);
        
        trest.setBounds(20, 80, 100, 20);
        pnl.add(trest);
        
        forma.setBounds(20, 100, 100, 20);
        pnl.add(forma);
        
        tforma.setBounds(20, 120, 100, 20);
        pnl.add(tforma);
        
        
    }
}
