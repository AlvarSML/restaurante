/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.io.IOException;
import java.util.ArrayList;
import restaurante.elementos.Forma;
import restaurante.elementos.Reserva;
import restaurante.elementos.Restaurante;
import restaurante.elementos.Sala;

/**
 *
 * @author alvar
 */
public class ProyRestaurante {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        
        // pruebas
        Restaurante r = new Restaurante("R1");
        r.nuevaSala("sala1");
        
        ArrayList<Sala> s = r.getSalas();        
        
        s.get(0).nuevaMesa((byte) 5, Forma.CUADRADA);
        
        r.menuRest();
        
       
    }

}
