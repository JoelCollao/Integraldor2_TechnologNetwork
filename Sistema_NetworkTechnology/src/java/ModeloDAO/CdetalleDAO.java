/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoCdetalle;
import Modelo.Cdetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mrang
 */
public class CdetalleDAO implements metodoCdetalle{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public ArrayList<Cdetalle> detalle(String nroComprobante) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Cdetalle>lista = new ArrayList<>();
        String sql= "select * from det_comprobante where comprobante_cabe_numero='"+nroComprobante+"';";
        try{
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Cdetalle cdetalle = new Cdetalle();
            cdetalle.setNro_comprobante(rs.getString("comprobante_cabe_numero"));
            cdetalle.setCod_producto(rs.getString("pro_codigo"));
            cdetalle.setCantidad(rs.getInt("comprobante_deta_cantidad"));
            cdetalle.setMonto(rs.getDouble("monto"));
            lista.add(cdetalle);
        }
        
        }
        catch(SQLException ex){
            
        }
        return lista;
    }
    
    @Override
    public ArrayList<Cdetalle> listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Cdetalle>lista = new ArrayList<>();
        String sql= "select * from det_comprobante";
        try{
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Cdetalle cdetalle = new Cdetalle();
            cdetalle.setItem(rs.getInt("item"));
            cdetalle.setNro_comprobante(rs.getString("comprobante_cabe_numero"));
            cdetalle.setCod_producto(rs.getString("pro_codigo"));
            cdetalle.setCantidad(rs.getInt("comprobante_deta_cantidad"));
            cdetalle.setMonto(rs.getDouble("monto"));
            lista.add(cdetalle);
        }
        
        }
        catch(SQLException ex){
            
        }
        return lista;
    }

    @Override
    public void agregar(Cdetalle cdetalle) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql="insert into det_comprobante(item, comprobante_cabe_numero, pro_codigo, comprobante_deta_cantidad, monto)"
                + "values('"+cdetalle.getItem()+"','"+cdetalle.getNro_comprobante()+"','"+cdetalle.getCod_producto()+"','"+cdetalle.getCantidad()+"','"+cdetalle.getMonto()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);   
            ps.executeUpdate();
        
        }
        catch(SQLException ex){
        }
    }
    
}
