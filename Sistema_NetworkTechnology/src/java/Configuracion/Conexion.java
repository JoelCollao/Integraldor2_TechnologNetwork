/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost/bd_venta";
    String usuario="root";
    String password="";
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url,usuario,password);
        }catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
            System.out.print(ex);
        }   
    }
    public Connection getConnection() {
        return con;
    }
  
}
