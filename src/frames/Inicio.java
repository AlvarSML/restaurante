/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import restaurante.elementos.bdd;

/**
 *
 * @author alvar
 */
// prueba de ventana
public class Inicio extends JFrame implements ActionListener {

    private JFrame frm = new JFrame("Inicio");
    private JPanel pnl = new JPanel();;

    private JLabel titulo = new JLabel("Inicio Restaurante");
    private JLabel usu = new JLabel("Usuario: ");
    private JLabel pas = new JLabel("Contraseña: ");
    private JTextField usuario = new JTextField();
    private JPasswordField passwd = new JPasswordField();
    
    private JButton entrar = new JButton("entrar");

    public void inicio() {
        
        //frame
        frm.setBounds(200, 200, 400, 170);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnl.setLayout(null);

        // se añade el panel al frame
        frm.add(pnl);
        frm.setVisible(true);

        // creacion de los elementos
        titulo.setBounds(100, 10, 180, 20);
        pnl.add(titulo);
        
        usu.setBounds(10, 50, 150, 20);
        pnl.add(usu);
        
        pas.setBounds(10, 70, 150, 20);
        pnl.add(pas);
        
        usuario.setBounds(100, 50, 100, 20);
        pnl.add(usuario);

        passwd.setBounds(100, 70, 100, 20);
        pnl.add(passwd);
        
        entrar.setBounds(220,70,70,20);
        pnl.add(entrar);       
        
        // configuracion boton
        entrar.setActionCommand("intro");
        entrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //login
        if (e.getActionCommand().equals("intro")) {
            String pass = new String(passwd.getPassword());
            bdd.login(usuario.getText(),pass);
           
        }
        
    }

}
