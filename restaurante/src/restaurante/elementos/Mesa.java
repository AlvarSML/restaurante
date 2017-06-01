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
public class Mesa {
    // Atributos

    private byte num, comensales;
    private final Forma FORMA;
    private boolean ocupada;

    //Metodos encap
    public byte getNum() {
        return num;
    }

    public byte getComensales() {
        return comensales;
    }

    public Forma getFORMA() {
        return FORMA;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setComensales(byte comensales) {
        this.comensales = comensales;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    //Metodos
    public void newFactura() {
        //se creara un fichero
    }

    //Constructor
    public Mesa(byte num, Forma f) {
        this.num = num;
        this.FORMA = f;
        this.ocupada = false;

        if (f == Forma.CUADRADA) {
            this.comensales = 4;
        } else if (f == Forma.RECTANGULAR) {
            this.comensales = 6;
        } else if (f == Forma.REDONDA) {
            this.comensales = 8;
        }
    }
}
