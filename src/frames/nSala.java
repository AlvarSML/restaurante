/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import restaurante.bdd;

/**
 *
 * @author alvar
 */
public class nSala implements ActionListener {

    private JFrame frm = new JFrame("Nueva Sala");
    private JPanel pnl = new JPanel();

    private JLabel titulo = new JLabel("Nueva Sala");

    private JLabel rest = new JLabel("Restaurante");
    private JComboBox trest = new JComboBox();

    private JLabel nombre = new JLabel("Nombre");
    private JTextField tnombre = new JTextField();

    private JButton intro = new JButton("Intro");

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
        trest.setModel(new DefaultComboBoxModel(new bdd().restaurantes()));

        nombre.setBounds(20, 100, 100, 20);
        pnl.add(nombre);

        tnombre.setBounds(20, 120, 100, 20);
        pnl.add(tnombre);

        intro.setBounds(20, 160, 100, 20);
        pnl.add(intro);
        intro.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            if (e.getSource() == intro) {
                if (tnombre.getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "No has puesto nombre");
                } else {
                    bdd.crearSala(tnombre.getText(), trest.getSelectedIndex() + 1);
                    JOptionPane.showMessageDialog(null, "Sala creada!");
                    tnombre.setText("");
                }
            }
            
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
