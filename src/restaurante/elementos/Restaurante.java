/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.elementos;

import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alvar
 */
public class Restaurante {

    //Atributos
    private String nom;
    private ArrayList<Sala> salas = new ArrayList<>(); //Las clases Restaurante almacenan las salas
    private ArrayList<Reserva> reservas = new ArrayList<>(); //Cada restaurante gestiona sus reservas
    private byte nEmpleados;

    private byte tSala; //todas las salas creadas

    //Metodos encapsulamiento
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public byte getnEmpleados() {
        return nEmpleados;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    //Metodos
    public void nuevaSala(String s) { // s = nombre de sala n = numero de sala 
        Sala nsala = new Sala(s);
        salas.add(nsala);
    }
    
    //recoje una cadena con una longitud minima
    public String recCadena(String s) { 
        String n = new String();
        Scanner in = new Scanner(System.in);

        System.out.printf("Introduce un %s: ", s);
        n = in.nextLine();

        if (n.length() < 1) {
            System.out.printf("%s demasiado corto", s);
            n = recCadena(s);
        }

        return n;
    }
    
    // recoje un telefono simple, sin prefijo (xxx xxx xxx)
    public byte recTelef() {
        Scanner in = new Scanner(System.in);
        byte tel;

        tel = in.nextByte();

        if (tel > 999999999 || tel < 100000000) {
            System.out.println("Telefono incorrecto");
            tel = recTelef();

        }

        return tel;
    }

    // se intruduce el sueldo y se comprueba que sea correcto
    public float recSueldo() {
        Scanner in = new Scanner(System.in);
        float su;

        System.out.printf("Introduce el sueldo: ");
        su = in.nextFloat();
        
        // comprobacion anti jordi cruz
        if (su < 650) {
            System.out.println("Sueldo demasiado bajo");
            su = recSueldo();
        }

        return su;
    }

    // se introducen los comensales y se comprueba que exista una de tamaño suficiente
    public byte introComensales() { //(WIP)
        Scanner in = new Scanner(System.in);
        byte com;
        int max;

        System.out.println("Introduce el numero de comensales");
        com = in.nextByte();

        // Comprobacion
        // Primero se saca el numero maximo de comensales en una sala del restaurante
        max = 0; // (no hay salas con personas negativas)

        for (Sala s : salas) {
            for (Mesa m : s.getMesas()) {

                if (m.getComensales() > max) {
                    max = m.getComensales();
                }
            }
        }

        if (com > max) {
            System.out.println("No hay espacio en este respaurante");
            return -1; //al encontrar un -1 el metodo nueva reserva cancelara la reserva            
        } else {
            System.out.printf("Hay espacio para %d comensales\n", com);
            return com;
        }

    }
    
    // se introduce la fecha por partes, se comprueba y se pasa a gregorian calendar
    public GregorianCalendar introFecha() {
        Scanner in = new Scanner(System.in);
        GregorianCalendar fecha;
        GregorianCalendar fechaActual = new GregorianCalendar();

        int day, month, year, hor, min;
        String hora;

        System.out.printf("Introduce el año: ");
        year = in.nextInt();
        System.out.printf("Introduce el mes: ");
        month = in.nextInt();
        System.out.printf("Introduce el dia: ");
        day = in.nextInt();

        System.out.printf("Introduce la hora (HH:MM): ");
        hora = in.next();

        try {
            hor = Integer.parseInt(hora.substring(0, 2));
            min = Integer.parseInt(hora.substring(3, 5));
            fecha = new GregorianCalendar(year, month, day, hor, min);
        } catch (InputMismatchException ie) {
            System.out.println(ie.getMessage());
            fecha = introFecha();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fecha = introFecha();
        }

        // comprobacion de la fecha
        if (fecha.before(fechaActual)) {
            System.out.println("La fecha es anterior a la actual");
            fecha = introFecha();
        }

        if ((fecha.get(GregorianCalendar.HOUR_OF_DAY) < 12 && fecha.get(GregorianCalendar.MINUTE) < 30)) {
            //comprobacion para comer
            System.out.println("Es demasiado pronto para comer");
            fecha = introFecha();
        } else if (fecha.get(GregorianCalendar.HOUR_OF_DAY) > 16 && (fecha.get(GregorianCalendar.HOUR_OF_DAY) < 20 && fecha.get(GregorianCalendar.MINUTE) < 30)) {
            System.out.println("Es demasiado tarde para comer y pronto para cenar");
            fecha = introFecha();
        } else if (fecha.get(GregorianCalendar.HOUR_OF_DAY) > 23 && fecha.get(GregorianCalendar.MINUTE) < 30) {
            System.out.println("Es demasiado tarde  para cenar");
            fecha = introFecha();
        }

        return fecha;

    }
    
    // comprueba que una mesa este libre en un margen de una hora
    public boolean estaLibre(String sala, byte mesa, GregorianCalendar f) {
        boolean resp = true;

        
        if (reservas.size() >= 1) {
            for (Reserva r : reservas) {
                resp = (r.getSala().equals(sala)
                        && r.getMesa() == mesa
                        && abs(r.getFecha().getTimeInMillis() - f.getTimeInMillis()) > 3600000
                        && r.getFecha().get(GregorianCalendar.YEAR) == f.get(GregorianCalendar.YEAR)
                        && r.getFecha().get(GregorianCalendar.DAY_OF_YEAR) == f.get(GregorianCalendar.DAY_OF_YEAR));

            }
        }
        return resp;
    }

    //devuelve un string con la sala y la mesa
    public String[] introMesaSala(int n, GregorianCalendar f) {
        int dif = 99; // diferencia entre el numero de comensales y la capacidad de la mesa

        String[] sm = new String[2]; // 0 = sala 1 = mesa

        //recorre cada mesa de cada sala buscando la que mejor se ajuste a los comensales
        for (Sala s : salas) {
            for (Mesa m : s.getMesas()) {

                //(WIP)
                if (m.getComensales() > n) {
                    if (estaLibre(s.getNom(), m.getNum(), f)) {
                        if (m.getComensales() - n < dif) {
                            dif = m.getComensales() - n;
                            sm[1] = Integer.toString(m.getNum());
                            sm[0] = s.getNom();
                        }
                    }
                }

            }
        }

        return sm;
    }

    // Metodos reservas se introduce el codigo del empleado que la realiza
    public void nuevaReserva(int cod) throws IOException {
        Reserva r = new Reserva(cod); // (WIP) posiblemente lo pasara el maitre    
        GregorianCalendar fech;

        // primero el numero de comensales
        int com = this.introComensales();

        if (com <= 0) {

            this.menuRest();
        }

        // se introduce la fecha y hora
        fech = this.introFecha();

        // se busca una mesa disponible en una sala
        String[] mesa = this.introMesaSala(com, fech);

        if (mesa[0] == null || mesa[1] == null) {
            System.out.println("No hay mesas disponibles");
            this.menuRest();
        }
        
        // si todo sale bien se pide el nombre del cliente
        
        String cliente = recCadena("Nombre del cliente");
        
        // se pasan los datos a la reserva
        r.escribeReserva(com, fech, mesa, cliente);

        reservas.add(r);
    }

    //Menu
    
    // el metodo menuRest() se usaria para administrar los elementos del restaurante
    public void menuRest() throws IOException {
        Scanner in = new Scanner(System.in);
        byte op = 0;

        System.out.println("----- MENU RESTAURANTE -----");
        System.out.println("1. Nueva sala");
        System.out.println("2. Ver salas");
        System.out.println("3. Nueva reserva");
        System.out.println("4. Ver reservas");
        System.out.println("0. Salir");

        try {
            System.out.printf("--> ");
            op = in.nextByte();

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            menuRest();
        }

        switch (op) {
            case 1:
                System.out.println("Introduce el nombre de la sala");
                String sala = in.next();
                this.nuevaSala(sala);
                this.menuRest();
                break;
            case 2:
                System.out.println("--- Salas ---");

                for (Sala s : salas) {
                    System.out.printf("%s mesas: %d \n", s.getNom(), s.getMesas().size());
                }

                this.menuRest();
                break;
            case 3:

                System.out.println("Introduce el codigo de empleado");
                this.nuevaReserva(in.nextInt());
                this.menuRest();
                break;
            case 4:
                System.out.println("--- Reservas ---");

                if (reservas.size() > 0) {
                    reservas.get(0).start();
                } else {
                    System.out.println("No hay reservas");
                }
                this.menuRest();
                break;
            case 0:
                System.out.println("Estas seguro? [s/n]");
                if (in.next().equals("s")) {
                    System.out.println("Adios");
                    System.exit(0);
                } else {
                    this.menuRest();
                }
                break;
            default:
                System.out.println("Intro incorrecta");
                this.menuRest();
        }

    }

    //Constructor
    public Restaurante(String n) {
        this.nom = n;
    }

}
