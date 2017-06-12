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
public class reserva extends JFrame {

    private JFrame frm = new JFrame("Reserva");
    private JPanel pnl = new JPanel();

    private JLabel titulo = new JLabel("Nueva reserva");

    private JLabel idper = new JLabel("Id");
    private JTextField idpr = new JTextField();

    private JLabel personas = new JLabel("Personas");
    private JTextField tpersonas = new JTextField();

    private JLabel fecha = new JLabel("Fecha");
    private JTextField tfecha = new JTextField();

    private JLabel hora = new JLabel("Hora");
    private JTextField thora = new JTextField();

    public reserva(int id) {
        //frame
        frm.setBounds(200, 200, 400, 400);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pnl.setLayout(null);

        // se añade el panel al frame
        frm.add(pnl);
        frm.setVisible(true);

        // elementos
        titulo.setBounds(frm.getWidth() / 3, 40, 100, 20);
        pnl.add(titulo);

        idper.setBounds(20, 60, 100, 20);
        pnl.add(idper);

        idpr.setBounds(20, 80, 100, 20);
        pnl.add(idpr);
        idpr.setText(String.valueOf(id));
        idpr.setEditable(false);
        
        personas.setBounds(20, 100, 100, 20);
        pnl.add(personas);
        
        tpersonas.setBounds(20, 120, 50, 20);
        pnl.add(tpersonas);
        
        fecha.setBounds(20,140,100,20);
        pnl.add(fecha);
        
        tfecha.setBounds(20, 160, 100, 20);
        pnl.add(tfecha);
        
        hora.setBounds(20, 180, 100, 20);
        pnl.add(hora);
        
        thora.setBounds(20, 200, 100, 20);
        pnl.add(thora);
    }

}
