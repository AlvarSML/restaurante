/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alvar
 */

// prueba de ventana
public class Inicio {
    private JFrame main;
    private JPanel pmain;
    
    private JLabel titulo;
    
    public void inicio(){
        this.main = new JFrame("Inicio");
        this.main.setVisible(true);
        this.main.setBounds(100, 50, 200, 100);
        this.main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pmain = new JPanel();
        
        this.titulo = new JLabel("Inicio Restaurante");
        
        this.pmain.add(titulo);
        
        this.main.add(pmain);
        
    }
    
    public static void main(String[] args) throws IOException {
        new Inicio().inicio();
    }
    
    
}
