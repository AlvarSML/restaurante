/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.elementos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author alvar
 */
public class Factura {
    // Atributos

    private final int NUMFACT;
    private final Date FECHAHORA;
    private final String REST, COMEDOR, MESA, NIF;
    private float importe, total;
    private ArrayList<Plato> pls = new ArrayList<>();
    private File factura;
    private static int facts;

    // Metodos
    public void meterPlato(Plato p) {
        pls.add(p);
    }

    public void generarFactura() throws IOException {

        File fact = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String nom = String.valueOf(NUMFACT) + REST;

        try {

            fact = new File(nom);

            if (!fact.createNewFile()) {
                System.out.println("La factura ya existe");
            } else {
                System.out.println("Se ha creado la factura");

                fw = new FileWriter(fact, true);
                bw = new BufferedWriter(fw);

                
                // escritura de la factura
                bw.write("\t\t" + REST + "\n");
                bw.write(String.valueOf("Fecha ->"+FECHAHORA + "\n"));
                bw.write("DNI ->" + NIF+ "\n");
                bw.write("******************************\n\n");

                for (Plato pl : pls) {
                    bw.write(pl.getNombre() + ".............." + pl.getPrecio() + "\n");

                }
                
                // falta poner el total con IVA
                 
                this.factura = fact;

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
           

        }
        bw.close();
   }

    // Cosntructores
    public Factura(String res, String com, String mesa, String ni) {
        this.NUMFACT = facts;
        this.REST = res;
        this.COMEDOR = com;
        this.MESA = mesa;
        this.NIF = ni;
        this.FECHAHORA = new Date();        
        facts++;
    }

}
