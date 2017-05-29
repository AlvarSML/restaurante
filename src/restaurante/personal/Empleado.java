/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.personal;

import java.util.Date;

/**
 *
 * @author alvar
 */
public abstract class Empleado {
    
    /// La clase Empleado es la mas basica y no se podran crear instancias, nadie
    /// sera solo un empleado, sino que tendra otra categoria como Chef, Cocinero,
    /// Maitre etc.
    
    // Atributos
    
    private String nombre, apellido, dni, seguridadSoc, dir, horario;
    private byte telefono;
    private float sueldo,cod;
    private Date fechaEn;
    
    private static byte numEmp;
    
    // Metodos encapsulacion

    public byte getCod() {
        return (byte) cod;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getSeguridadSoc() {
        return seguridadSoc;
    }

    public String getDir() {
        return dir;
    }

    public String getHorario() {
        return horario;
    }

    public byte getTelefono() {
        return telefono;
    }

    public float getSueldo() {
        return sueldo;
    }

    public Date getFechaEn() {
        return fechaEn;
    }

    public static byte getNumEmp() {
        return numEmp;
    }

    public void setCod(byte cod) {
        this.cod = cod;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSeguridadSoc(String seguridadSoc) {
        this.seguridadSoc = seguridadSoc;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setTelefono(byte telefono) {
        this.telefono = telefono;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
    // Constructor
    
    public Empleado(byte cd, String nom, String ape, String dn, byte tel, float suel){
        numEmp++;
        this.cod = cd;
        this.nombre = nom;
        this.apellido = ape;
        this.dni = dn;
        this.telefono = tel;
        this.sueldo = suel;
        this.fechaEn = new Date();
    }
    
   
    
}
