/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.io.IOException;
import java.util.Scanner;
import restaurante.elementos.bdd;

/**
 *
 * @author alvar
 */
public class ProyRestaurante {
    
    
    public static void login(bdd base) throws Exception {
        Scanner in = new Scanner(System.in);
        
        System.out.printf("Usuario >> ");
        String usu = in.next();
        
        System.out.printf("Contraseña >> ");
        String passw = in.next();
        
        if(bdd.login(usu,passw)){
            System.out.println("Conectado!");
        } else {
            System.out.println("Error!");
            login(base);
        }
        
        //hola
        
    }
    
    public static void main(String[] args) throws IOException, Exception {
        bdd db = new bdd();
        db.MySQLConnection("root","123456","restaurante");
        
        login(db);
        // pruebas asdas
        /*
        Restaurante r = new Restaurante("R1");
        r.nuevaSala("sala1");
        
        ArrayList<Sala> s = r.getSalas();        
        
        s.get(0).nuevaMesa((byte) 5, Forma.CUADRADA);
        
        r.menuRest();
        */
       
    }
    

}
