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
    private JLabel tit2 = new JLabel("Acciones");
    
    private JButton emp = new JButton("Nuevo empleado");
    private JButton emp2 = new JButton("Nuevo ...");
    private JButton emp3 = new JButton("Nuevo ...");
    private JButton emp4 = new JButton("Nuevo ...");
    
    
    public void inicio(){
        
        //frame
        frm.setBounds(200, 200, 400, 400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnl.setLayout(null);

        // se añade el panel al frame
        frm.add(pnl);
        frm.setVisible(true);
        
        // elementos
        titulo.setBounds(100, 10, 200, 20);
        pnl.add(titulo);
        
        tit2.setBounds(10,30,100,20);
        pnl.add(tit2);
        
        emp.setBounds(10,50,150,30);
        pnl.add(emp);
        
        emp2.setBounds(10,100,150,30);
        pnl.add(emp2);
        
        emp3.setBounds(10,150,150,30);
        pnl.add(emp3);
        
        emp4.setBounds(10,200,150,30);
        pnl.add(emp4);

        
    }
}
