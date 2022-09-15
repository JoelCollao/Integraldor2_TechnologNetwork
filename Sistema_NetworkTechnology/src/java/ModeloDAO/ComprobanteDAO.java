/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoComprobante;
import Modelo.Comprobante;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mrang
 */
public class ComprobanteDAO implements metodoComprobante {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Comprobante comprobante;

    @Override
    public void agregarComprobante(Comprobante comprobante) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try{
            String sql="insert into comprobante(comprobante_cabe_numero, comprobante_cabe_fecha, LOC, cli_codigo, comprobante_cabe_igv, comprobante_cabe_total) "
           // + "values('"+pro.getPro_codigo()+"', '"+pro.getPro_descripcion()+"', "+pro.getPro_precio_unitario()+", "+pro.getPro_stock()+", "+pro.getCat_codigo()+","+pro.getPro_img()+")";
            + "values(?,?,?,?,?,?)";
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, comprobante.getNro_comprobante());
        ps.setDate(2, Date.valueOf(comprobante.getFecha()));
        ps.setString(3, comprobante.getLocacion());
        ps.setString(4, comprobante.getCod_cliente());
        ps.setDouble(5, comprobante.getIgv());
        ps.setDouble(6, comprobante.getTotal());
        ps.executeUpdate();
        }
        catch(SQLException ex){ 
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Comprobante> listaComprobante() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql= "Select * from comprobante";
        ArrayList<Comprobante>lista = new ArrayList<>();
        try{
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                comprobante = new Comprobante();
                comprobante.setNro_comprobante(rs.getString("comprobante_cabe_numero"));
                comprobante.setFecha(rs.getString("comprobante_cabe_fecha"));
                comprobante.setLocacion(rs.getString("LOC"));
                comprobante.setCod_cliente(rs.getString("cli_codigo"));
                comprobante.setIgv(rs.getDouble("comprobante_cabe_igv"));
                comprobante.setTotal(rs.getDouble("comprobante_cabe_total"));
                lista.add(comprobante);
            }
        }
        catch(SQLException ex){
            
        }
    return lista;
    }
    
    @Override
    public ArrayList<Comprobante> listaComprobante(String nro_comprobante) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql= "Select * from comprobante where comprobante_cabe_numero='"+nro_comprobante+"';";
        ArrayList<Comprobante>lista = new ArrayList<>();
        try{
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                comprobante = new Comprobante();
                comprobante.setNro_comprobante(rs.getString("comprobante_cabe_numero"));
                comprobante.setFecha(rs.getString("comprobante_cabe_fecha"));
                comprobante.setLocacion(rs.getString("LOC"));
                comprobante.setCod_cliente(rs.getString("cli_codigo"));
                comprobante.setIgv(rs.getDouble("comprobante_cabe_igv"));
                comprobante.setTotal(rs.getDouble("comprobante_cabe_total"));
                lista.add(comprobante);
            }
        }
        catch(SQLException ex){
            
        }
    return lista;
    }
    
}
