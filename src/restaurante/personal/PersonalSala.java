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
public abstract class PersonalSala extends Empleado{
    /// Esta clase solo divide a los empleados, por lo que solo se podran crear instancias
    /// de alguna de sus clases hijas
    
    // Atributos
    
    private static byte numPerSala;
    
    // Constructores

    public PersonalSala(byte cd, String nom, String ape, String dn, byte tel, float suel) {
        super(cd, nom, ape, dn, tel, suel);
    }
    
  
    
}
