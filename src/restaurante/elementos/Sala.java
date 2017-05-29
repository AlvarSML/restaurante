/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.elementos;

import java.util.ArrayList;

/**
 *
 * @author alvar
 */
public class Sala {

    // Atributo
    private String nom;
    private ArrayList<Mesa> mesas = new ArrayList<>(); //todas las mesas    
    private byte tMesas; //todas las mesas creadas
    private int maxComen; //numero maximo ce comensales que caben 

    // Metodos encap
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMaxComen() {
        return maxComen;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    
    
    
    // Metodos

    public void nuevaMesa(byte com, Forma form) { // se introducen los comensales y forma
        Mesa m = new Mesa(tMesas,form);
        this.mesas.add(m);
        tMesas++;
        this.maxComen+= com;
    }

    public void mesasVacias() { //se ejecutara para actualizar las mesasa vacias en metodos
        byte ocupadas = 0;
        
        for (int i = 0; i < tMesas; i++) { //(WIP)
            if (!mesas.get(i).isOcupada()) {
                System.out.printf("La mesa %d esta libre para %d", mesas.get(i).getNum(), mesas.get(i).getComensales());
            } else {
                ocupadas++;
            }
        }
        
        if (ocupadas == tMesas) {
            System.out.println("Todas las mesas estan ocupadas");
        }

    }

    // Constructor
    public Sala(String s) {
        this.nom = s;
        this.tMesas = 0;
        //añadir comprobador de nombres
    }
}
