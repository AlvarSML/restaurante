/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import frames.Inicio;
import java.io.IOException;

/**
 *
 * @author alvar
 */
public class ProyRestaurante {

    public static void main(String[] args) throws IOException, Exception {
        bdd db = new bdd();
        db.MySQLConnection("root", "123456", "restaurante");
        Inicio inicio = new Inicio();

    }

}
