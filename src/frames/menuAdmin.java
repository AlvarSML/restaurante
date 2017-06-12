/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author DAW122
 */
public class menuAdmin extends JFrame implements ActionListener {
    
    private int id;
    
    private JFrame frm = new JFrame("Menu");
    private JPanel pnl = new JPanel();

    //elementos
    private JLabel titulo = new JLabel("Menu");
    private JLabel tit2 = new JLabel("Acciones");
    
    private JButton emp = new JButton("Nuevo empleado");
    private JButton res = new JButton("Nueva reserva WIP");
    private JButton sal = new JButton("Nueva sala WIP");
    private JButton mes = new JButton("Nuevo mesa WIP");
    
    public menuAdmin(int n) {
        
        this.id = n;
        
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
        
        tit2.setBounds(10, 30, 100, 20);
        pnl.add(tit2);
        
        emp.setBounds(10, 50, 150, 30);
        pnl.add(emp);
        emp.addActionListener(this);
        
        res.setBounds(10, 100, 150, 30);
        pnl.add(res);
        res.addActionListener(this);
        
        sal.setBounds(10, 150, 150, 30);
        pnl.add(sal);
        sal.addActionListener(this);
        
        mes.setBounds(10, 200, 150, 30);
        pnl.add(mes);
        mes.addActionListener(this);
        
        if (n != 9) {
            emp.setEnabled(false);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == emp) {            
            nEmp nEmp = new nEmp();            
        } else if (e.getSource() == res){
            reserva reserva = new reserva(id);
        } else if (e.getSource() == sal){
            nSala n = new nSala();
        } else if (e.getSource() == mes){
            nMesa m = new nMesa();
        }
    }
    
}
