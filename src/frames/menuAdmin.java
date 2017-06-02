/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.*;

/**
 *
 * @author DAW122
 */
public class menuAdmin extends JFrame{
    
    private JFrame frm = new JFrame("Menu");
    private JPanel pnl = new JPanel();
    //elementos
    private JLabel titulo = new JLabel("Menu");
    
    public void inicio(){
        
        //frame
        frm.setBounds(200, 200, 400, 170);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnl.setLayout(null);

        // se añade el panel al frame
        frm.add(pnl);
        frm.setVisible(true);
        
        // elementos
        titulo.setBounds(100, 10, 100, 20);
        pnl.add(titulo);
    }
}
