
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.personal;

/**
 *
 * @author alvar
 */
public class Cocinero extends PersonalCocina{
     // Atributos
    private String especialidad;
    private Empleado encargado;
    // Constructores

    public Cocinero(byte cd, String nom, String ape, String dn, byte tel, float suel) {
        super(cd, nom, ape, dn, tel, suel);
    }
}
