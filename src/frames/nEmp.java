/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import javax.swing.*;
import restaurante.bdd;

/**
 *
 * @author DAW122
 */
public class nEmp extends JFrame implements ActionListener {

    private JFrame frm = new JFrame("Menu");
    private JPanel pnl = new JPanel();

    private JComboBox desp = new JComboBox();

    private JLabel titulo = new JLabel("Nuevo empleado");
    private JLabel tipo = new JLabel("Tipo");

    private JLabel res = new JLabel("Restaurante");
    private JComboBox tres = new JComboBox();

    private JLabel nom = new JLabel("Nombre");
    private JTextField tnom = new JTextField();

    private JLabel ape = new JLabel("Apellidos");
    private JTextField tape = new JTextField();

    private JLabel dni = new JLabel("DNI");
    private JTextField tdni = new JTextField();

    private JLabel ss = new JLabel("Seguridad social");
    private JTextField tss = new JTextField();

    private JLabel fecha = new JLabel("Fecha entrada");
    private JTextField tfecha = new JTextField();

    private JLabel sueldo = new JLabel("Sueldo");
    private JTextField tsueldo = new JTextField();

    private JLabel horario = new JLabel("Horario");
    private JTextField thorario = new JTextField();

    private JLabel rango = new JLabel("Rango");
    private JComboBox trango = new JComboBox();

    private JLabel exp = new JLabel("Experiencia");
    private JTextField texp = new JTextField();

    private JLabel encargado = new JLabel("Encargado");
    private JComboBox tencargado = new JComboBox();

    private JLabel titulos = new JLabel("Titulos");
    private JTextField ttitulos = new JTextField();

    private JLabel passwd = new JLabel("Contraseña");
    private JPasswordField tpasswd = new JPasswordField();

    private JButton intro = new JButton("Intro");

    public nEmp() {
        //frame
        frm.setBounds(200, 200, 400, 400);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pnl.setLayout(null);

        // se añade el panel al frame
        frm.add(pnl);
        frm.setVisible(true);

        // elementos
        titulo.setBounds(100, 10, 200, 20);
        pnl.add(titulo);

        tipo.setBounds(10, 30, 100, 20);
        pnl.add(tipo);

        res.setBounds(150, 30, 100, 20);
        pnl.add(res);

        tres.setBounds(150, 50, 100, 20);
        pnl.add(tres);
        tres.setModel(new DefaultComboBoxModel(new bdd().restaurantes()));

        desp.setBounds(10, 50, 100, 20);
        pnl.add(desp);
        desp.setModel(new DefaultComboBoxModel(new String[]{"Cocinero", "Camarero", "Sumiller", "Personal cocina"}));
        desp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    if (e.getItem().toString().equals("Camarero")) {
                        trango.setEnabled(false);
                        texp.setEnabled(false);
                        tencargado.setEnabled(false);
                    }
                }

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().toString().equals("Camarero")) {
                        trango.setEnabled(true);
                        texp.setEnabled(true);
                        tencargado.setEnabled(true);
                    }
                }

                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    if (e.getItem().toString().equals("Sumiller")) {

                    }
                }

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().toString().equals("Sumiller")) {

                    }
                }

            }

        });
        desp.addActionListener(this);

        //FORMULARIO
        nom.setBounds(10, 80, 100, 20);
        pnl.add(nom);

        tnom.setBounds(10, 100, 100, 20);
        pnl.add(tnom);

        ape.setBounds(10, 120, 100, 20);
        pnl.add(ape);

        tape.setBounds(10, 140, 100, 20);
        pnl.add(tape);

        dni.setBounds(10, 160, 100, 20);
        pnl.add(dni);

        tdni.setBounds(10, 180, 100, 20);
        pnl.add(tdni);

        ss.setBounds(10, 200, 100, 20);
        pnl.add(ss);

        tss.setBounds(10, 220, 100, 20);
        pnl.add(tss);

        fecha.setBounds(10, 240, 100, 20);
        pnl.add(fecha);

        tfecha.setBounds(10, 260, 100, 20);
        pnl.add(tfecha);

        sueldo.setBounds(10, 280, 100, 20);
        pnl.add(sueldo);

        tsueldo.setBounds(10, 300, 100, 20);
        pnl.add(tsueldo);

        horario.setBounds(150, 80, 100, 20);
        pnl.add(horario);

        thorario.setBounds(150, 100, 100, 20);
        pnl.add(thorario);

        rango.setBounds(150, 120, 100, 20);
        pnl.add(rango);

        trango.setBounds(150, 140, 100, 20);              
        trango.setModel(new DefaultComboBoxModel(new bdd().rangos()));
        pnl.add(trango);
        trango.setEnabled(false);

        exp.setBounds(150, 160, 100, 20);
        pnl.add(exp);

        texp.setBounds(150, 180, 100, 20);
        pnl.add(texp);
        texp.setEnabled(false);

        encargado.setBounds(150, 200, 100, 20);
        pnl.add(encargado);

        tencargado.setBounds(150, 220, 100, 20);
        tencargado.setModel(new DefaultComboBoxModel(new bdd().encargado()));
        tencargado.addItem("Nadie");
        tencargado.setEnabled(false);
        pnl.add(tencargado);

        titulos.setBounds(150, 240, 100, 20);
        pnl.add(titulos);

        ttitulos.setBounds(150, 260, 100, 20);
        pnl.add(ttitulos);

        intro.setBounds(80, 330, 100, 20);
        pnl.add(intro);
        intro.setActionCommand("intro");
        intro.addActionListener(this);

        passwd.setBounds(150, 280, 100, 20);
        pnl.add(passwd);

        tpasswd.setBounds(150, 300, 100, 20);
        pnl.add(tpasswd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == intro) {
            String enc = tencargado.getSelectedItem().toString();
            String pass = Arrays.toString(tpasswd.getPassword());
            
            bdd.crearEmpleado(Integer.parseInt(tres.getSelectedItem().toString()), tnom.getText(), tape.getText(), tdni.getText(), tss.getText(), tfecha.getText(), Float.parseFloat(tsueldo.getText()), desp.getSelectedIndex(), trango.getSelectedIndex(), enc, texp.getText(), ttitulos.getText(), pass);
            
        }

    }

}
