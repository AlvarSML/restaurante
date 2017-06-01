/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.elementos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author daw122
 */
public class bdd {
    private static Connection Conexion;
    
    public void MySQLConnection(String user, String pass, String db_name) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + db_name, user, pass);
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
    
    public static boolean login(String usuario, String pass){
        boolean log = false;
        
        try {
            String sel = "SELECT md5(passwd) FROM empleado where id = '"+usuario+"' and passwd = md5('"+pass+"')";
            Statement st = Conexion.createStatement();
            ResultSet a = st.executeQuery(sel);
            
            if(a.next()){
                log = true;
            }
            
        } catch (SQLException ex){
            System.out.println(ex.getMessage()); 
        } 
        
        return log;
    }
    
    public static void crearEmpleado(int res, int id, String nom, String ape, String dni, String ss, String fechae, float sueldo, int tipo ){
        
        try {
            String ins = "IINSERT INTO empleado values ("+res+","+id+",'"+nom+"'";
            Statement st = Conexion.createStatement();
            st.executeQuery(ins);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
