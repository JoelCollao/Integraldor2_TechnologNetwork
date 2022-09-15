
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoAdministrador;
import Modelo.Administrador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDAO implements metodoAdministrador{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Administrador admi;
    
    @Override
     public Administrador listar(String admin_cod){
           try{
            String sql ="Select * From administrador where admin_cod='"+admin_cod+"'";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                admi =new Administrador();
                admi.setAdmin_cod(rs.getString("admin_cod"));
                admi.setAdmin_nombre(rs.getString("admin_nombre"));
                admi.setAdmin_apepat(rs.getString("admin_apepat"));
                admi.setAdmin_apemat(rs.getString("admin_apemat"));
                admi.setAdmin_fec_ing(rs.getDate("admin_fec_ing").toString());
                admi.setAdmin_password(rs.getString("admin_password"));
                admi.setAdmin_estado(rs.getString("admin_estado"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admi;
    }

    @Override
    public void agregar(Administrador admi) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            String sql="insert into administrador(admin_cod, admin_nombre, admin_apepat, admin_apemat, admin_fec_ing, LOC, admin_password,admin_estado) "
           // + "values('"+pro.getPro_codigo()+"', '"+pro.getPro_descripcion()+"', "+pro.getPro_precio_unitario()+", "+pro.getPro_stock()+", "+pro.getCat_codigo()+","+pro.getPro_img()+")";
            + "values(?,?,?,?,?,?,?,?)";
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, admi.getAdmin_cod());
        ps.setString(2, admi.getAdmin_nombre());
        ps.setString(3, admi.getAdmin_apepat());
        ps.setString(4, admi.getAdmin_apemat());
        ps.setDate(5, Date.valueOf(admi.getAdmin_fec_ing()));
        ps.setString(6, admi.getAdmin_LOC());
        ps.setString(7, admi.getAdmin_password());
        ps.setString(8, admi.getAdmin_estado());
        ps.executeUpdate();
        }
        catch(SQLException ex){ 
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Administrador admin) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String sql="update administrador set admin_nombre='"+admin.getAdmin_nombre()+"', admin_apepat='"+admin.getAdmin_apepat()+"', admin_apemat='"+admin.getAdmin_apemat()+"', admin_fec_ing='"+admin.getAdmin_fec_ing()+"', LOC='"+admin.getAdmin_LOC()+"', admin_password='"+admin.getAdmin_password()+"', admin_estado='"+admin.getAdmin_estado()+"' where admin_cod='"+admin.getAdmin_cod()+"'";
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(String admin_cod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
        String sql= "delete from administrador where admin_cod='"+admin_cod+"'";
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
        //Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public Administrador listar(String admin_cod, String admin_pass) {
       try{
            String sql ="Select * From administrador where admin_cod='"+admin_cod+"' and admin_password='"+admin_pass+"'" ;
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                admi =new Administrador();
                admi.setAdmin_cod(rs.getString("admin_cod"));
                admi.setAdmin_nombre(rs.getString("admin_nombre"));
                admi.setAdmin_apepat(rs.getString("admin_apepat"));
                admi.setAdmin_apemat(rs.getString("admin_apemat"));
                admi.setAdmin_fec_ing(rs.getDate("admin_fec_ing").toString());
                admi.setAdmin_password(rs.getString("admin_password"));
                admi.setAdmin_estado(rs.getString("admin_estado"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admi;
    }

    @Override
    public Administrador recuperarClave(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int recuperarId(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Administrador> listarTodoAdministrador() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Administrador> administrador = new ArrayList<>();
        try{
            String sql = "Select * from administrador";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Administrador admin = new Administrador();
                admin.setAdmin_cod(rs.getString("admin_cod"));
                admin.setAdmin_nombre(rs.getString("admin_nombre"));
                admin.setAdmin_apepat(rs.getString("admin_apepat"));
                admin.setAdmin_apemat(rs.getString("admin_apemat"));
                admin.setAdmin_fec_ing(rs.getString("admin_fec_ing"));
                admin.setAdmin_LOC(rs.getString("LOC"));
                admin.setAdmin_password(rs.getString("admin_password"));
                admin.setAdmin_estado(rs.getString("admin_estado"));
                administrador.add(admin);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return administrador;
    }

    @Override
    public int nuevoAdministrador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
