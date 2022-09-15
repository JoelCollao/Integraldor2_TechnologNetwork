/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoEmpresa;
import Modelo.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrang
 */
public class EmpresaDAO implements metodoEmpresa {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empresa emp;
    @Override
    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empresa> listarEmpresas() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Empresa> empresas = new ArrayList<>();
        try{
            String sql = "Select * from empresa";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                emp = new Empresa();
                emp.setLocacion(rs.getString("LOC"));
                emp.setRuc(rs.getString("RUC"));
                emp.setRazon_social(rs.getString("razon_social"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setCorreo(rs.getString("correo"));
                emp.setCuenta(rs.getString("cuenta"));
                emp.setNro_cuenta(rs.getString("nro_cuenta"));
                emp.setCci(rs.getString("cci"));
                empresas.add(emp);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return empresas;
    }
    
    @Override
    public ArrayList<Empresa> listarEmpresaporLocacion(String loc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Empresa> empresas = new ArrayList<>();
        try{
            String sql = "Select * from empresa where LOC='"+loc+"';";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                emp = new Empresa();
                emp.setLocacion(rs.getString("LOC"));
                emp.setRuc(rs.getString("RUC"));
                emp.setRazon_social(rs.getString("razon_social"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setCorreo(rs.getString("correo"));
                emp.setCuenta(rs.getString("cuenta"));
                emp.setNro_cuenta(rs.getString("nro_cuenta"));
                emp.setCci(rs.getString("cci"));
                empresas.add(emp);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return empresas;
    }
    
}
