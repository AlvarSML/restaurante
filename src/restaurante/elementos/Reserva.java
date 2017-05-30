/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.elementos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.GregorianCalendar;

/**
 *
 * @author alvar
 */
public class Reserva extends Thread implements GestionReserva {

    //Atributos
    private final GregorianCalendar momentoRes; //fechaRes = cuando se va a comer  momentoRes = cuando se hace la reserva
    private final int codEmpleado;
    private final String nFile = "res1"; //archivo por defecto, se podra cambiar
    private final File fich = new File(nFile);

    private GregorianCalendar fecha;
    private int comensales, mesa;
    private String sala, cliente;

    @Override
    public boolean existeFichero(String f) throws IOException {
        return this.fich.exists();
    }

    @Override
    public String leeReservas(String nomF) throws IOException {
        String texto = new String();
        BufferedReader br = null;
        FileReader fr = null;

        if (!existeFichero(nomF)) {
            System.out.println("No hay archivo de reservas");
        } else {
            try {

                fr = new FileReader(this.fich);
                br = new BufferedReader(fr);

                String l = new String();
                while ((l = br.readLine()) != null) {
                    texto += br.readLine() + "\n";
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                fr.close();
            }
        }
        return texto;

    }

    @Override
    public void run() {
        
        String s = new String();
        
        try {
            s = this.leeReservas(nFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(s);

    }

    // Metodos encapsulamiento
    public String getnFile() {
        return nFile;
    }

    public File getFich() {
        return fich;
    }

    public GregorianCalendar getMomentoRes() {
        return momentoRes;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public int getComensales() {
        return comensales;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public int getMesa() {
        return mesa;
    }

    public String getSala() {
        return sala;
    }
   
   @Override
   public void escribeReserva(int comensales, GregorianCalendar fech, String[] s, String cliente) throws IOException {

        this.comensales = comensales;
        this.mesa = Integer.parseInt(s[1]);
        this.sala = s[0];

        String reg = new String();

        FileWriter fw = new FileWriter(this.fich, true);

        this.fecha = fech;

        // Generacion de el registro (dia + comensales + hora)
        String hh = Integer.toString(fech.get(GregorianCalendar.HOUR_OF_DAY));
        String mm = Integer.toString(fech.get(GregorianCalendar.MINUTE));
        
        if (hh.length() == 1) {
           hh = "0" + hh;
        }
        
        if (mm.length() == 1) {
           mm = "0" + mm;
        }
        
        reg += Integer.toString(fech.get(GregorianCalendar.YEAR))
                + " - " + Integer.toString(fech.get(GregorianCalendar.MONTH))
                + " - " + Integer.toString(fech.get(GregorianCalendar.DAY_OF_MONTH))
                + ";" + comensales + ";"+ hh + ":" + mm
                + ";" + this.codEmpleado
                + ";" + sala + ";" + mesa
                + ";" + cliente ;

        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(reg + "\n ");
        }
    }   

    public Reserva(int cod) {
        this.momentoRes = new GregorianCalendar();
        this.codEmpleado = cod;
    }


}
