/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw122
 */
public class bdd {

    private static Connection Conexion;

    public void MySQLConnection(String user, String pass, String db_name) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            System.out.println("*Conectado*");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("*Desconectado*");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean login(String usuario, String pass) {
        boolean log = false;

        try {
            String sel = "SELECT * FROM empleado where id = '" + usuario + "' and passwd = md5('" + pass + "')";
            Statement st = Conexion.createStatement();
            ResultSet a = st.executeQuery(sel);

            if (a.next()) {
                log = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return log;
    }

    public static int tipoEmpleado(int id) {

        try {
            String sel = "SELECT tipo FROM empleado WHERE id =" + id;
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery(sel);
            rs.last();
            return rs.getInt("tipo");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 99;
        }

    }

    public static void crearEmpleado(int res, String nom, String ape, String dni, String ss, String fechae, float sueldo, int tipo, int rango, String encargado, String exp, String tit, String passwd) {

        try {
            String ins = "INSERT INTO empleado (restaurante,nombre,apellido,dni,ss,fechae,sueldo,passwd,tipo) values (" + res + ",'" + nom + "'" + ",'" + ape + "'" + ",'" + dni + "'" + ",'" + ss + "'" + ",'" + fechae + "'" + "," + sueldo + ", md5('" + passwd + "'),'" + tipo + "');";
            String sel = "SELECT id FROM empleado";

            Statement st = Conexion.createStatement();
            Statement st2 = Conexion.createStatement();

            st.executeUpdate(ins);
            ResultSet rs = st2.executeQuery(sel);
            rs.last();

            int idemp = rs.getInt("id");
            System.out.println(idemp);

            switch (tipo) {
                case 0:
                    //crear cocinero
                    rango = 5;
                    System.out.println("Creando cocinero");
                    crearCocinero(crearPerCocina(idemp, rango));
                    break;
                case 1:
                    //crear camarero
                    System.out.println("Creando camarero");
                    crearCamarero(crearPerSala(idemp), exp, encargado);
                    break;
                case 2:
                    System.out.println("Creando Sumiller");
                    //crear sumiller
                    crearSumiller(crearPerSala(idemp), tit);
                    break;
                case 3:
                    //crear percocina
                    crearPerCocina(idemp, rango);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void crearCamarero(int idsal, String exp, String en) {
        try {
            String ins = "INSERT into camarero (personal,experiencia,encargado) VALUES (" + idsal + ",'" + exp + "'" + en + ")";
            if (en.equals("Nadie")) {
                ins = "INSERT into camarero (personal,experiencia) VALUES (" + idsal + ",'" + exp + "')";
            }

            System.out.println(ins);
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void crearCocinero(int idco) {

        try {
            String ins = "INSERT into cocinero (personal) VALUES (" + idco + ")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);
            System.out.println("Cocinero creado");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void crearSumiller(int persal, String tit) {
        try {
            String ins = "INSERT into sumiller (personal,titulos) VALUES (" + persal + ",'" + tit + "')";
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void crearMaitre(int idsal) {
        try {
            String ins = "INSERT into maitre (personal,titulos) VALUES (" + idsal + ")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int crearPerCocina(int id, int rango) {
        System.out.println("creando percocina");
        int idper = 0;
        try {
            String ins = "INSERT into percocina (empleado,rango) VALUES (" + id + "," + rango + ")";
            String sel = "SELECT * FROM percocina";
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);
            ResultSet rs = st.executeQuery(sel);
            rs.last();
            idper = rs.getInt("id");
            System.out.println("El id del cocinero sera: " + idper);
            System.out.println("Percocina creado");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return idper;
    }

    public static int crearPerSala(int id) {
        int idsal = 0;
        try {
            String ins = "INSERT into persala (empleado) VALUES (" + id + ")";
            String sel = "SELECT * FROM persala";
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);
            ResultSet rs = st.executeQuery(sel);
            rs.last();
            idsal = rs.getInt("id");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return idsal;
    }

    public static void crearSala(String nombre, int restaurante) {
        try {
            String ins = "insert into sala (nombre,restaurante) values ('" + nombre + "'," + restaurante + ");";
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void crearMesa(int forma, int sala, int cantidad) {
        try {
            String ins = "insert into mesa (forma,sala) values (" + forma + "," + sala + ");";
            Statement st = Conexion.createStatement();

            for (int i = 0; i < cantidad; i++) {
                st.executeUpdate(ins);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void crearReserva(int mesa, int sala, int restaurante, String fecha, String nombre, int personas, int id) {
        try {
            String ins = "insert into reserva (mesa,sala,restaurante,fecha,cliente,comensales,empleado) values ("+mesa+","+sala+","+restaurante+","+fecha+","+nombre+","+personas+","+id+");";
            Statement st = Conexion.createStatement();
            st.executeUpdate(ins);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //obtener datos
    public static String[] rangos() {
        List<String> ran = new ArrayList<>();

        try {
            String sel = "Select descripcion from rangos";
            Statement st = Conexion.createStatement();
            ResultSet a = st.executeQuery(sel);

            while (a.next()) {
                ran.add(a.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        String[] s = new String[ran.size()];
        s = ran.toArray(s);

        return s;

    }

    public String[] restaurantes() {
        List<String> res = new ArrayList<>();

        try {
            String sel = "Select * from restaurante";
            Statement st = Conexion.createStatement();
            ResultSet a = st.executeQuery(sel);

            while (a.next()) {
                res.add(a.getString(2));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        String[] s = new String[res.size()];
        s = res.toArray(s);

        return s;

    }

    public String[] encargado() {
        List<String> res = new ArrayList<>();

        try {
            String sel = "Select id from camarero";
            Statement st = Conexion.createStatement();
            ResultSet a = st.executeQuery(sel);

            while (a.next()) {
                res.add(a.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        String[] s = new String[res.size()];
        s = res.toArray(s);

        return s;

    }

    public String[] formas() {
        List<String> res = new ArrayList<>();

        try {
            String sel = "Select * from forma";
            Statement st = Conexion.createStatement();
            ResultSet a = st.executeQuery(sel);

            while (a.next()) {
                res.add(a.getString(2));
                System.out.println(a.getString(2));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        String[] s = new String[res.size()];
        s = res.toArray(s);

        return s;

    }
}
