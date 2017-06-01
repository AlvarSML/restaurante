/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.elementos;

/**
 *
 * @author alvar
 */
public class Plato {
    
    // Atributos
    private String nombre;
    private float precio;
    private static int platos;
    private final int num;
    
    // Metodos

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public static int getPlatos() {
        return platos;
    }

    public int getNum() {
        return num;
    }
    
    
    // Constructor
    public Plato(float pre){
        this.precio = pre;
        this.num = platos;
        platos++;
    }
    
    public Plato(float pre, String nom){
        this.precio = pre;
        this.nombre = nom;
        this.num = platos;
        platos++;
    }
}
