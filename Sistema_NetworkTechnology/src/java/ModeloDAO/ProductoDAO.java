
package ModeloDAO;

import Configuracion.Conexion;
import Modelo.Producto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import Interfaces.metodoProducto;


public class ProductoDAO implements metodoProducto {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto art;

    @Override
    public void agregar(Producto pro) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            String sql="insert into producto(pro_codigo, pro_descripcion, pro_precio_unitario, pro_stock, cat_codigo, pro_img) "
           // + "values('"+pro.getPro_codigo()+"', '"+pro.getPro_descripcion()+"', "+pro.getPro_precio_unitario()+", "+pro.getPro_stock()+", "+pro.getCat_codigo()+","+pro.getPro_img()+")";
            + "values(?,?,?,?,?,?)";
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, pro.getPro_codigo());
        System.out.println("SQL codigo: "+pro.getPro_codigo());
        ps.setString(2, pro.getPro_descripcion());
        System.out.println("SQL descripcion: "+pro.getPro_descripcion());
        ps.setDouble(3, pro.getPro_precio_unitario());
        System.out.println("SQL precio :"+pro.getPro_precio_unitario());
        ps.setInt(4, pro.getPro_stock());
        System.out.println("SQL Stock: "+pro.getPro_stock());
        ps.setInt(5, pro.getCat_codigo());
        System.out.println("SQL Categoria: "+pro.getCat_codigo());
        ps.setBlob(6, pro.getPro_img());
        System.out.println("SQL Imagen: "+pro.getPro_img());
        //ps.setBinaryStream(6, pro.getPro_img());
        ps.executeUpdate();
        }
        catch(SQLException ex){ 
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void editar(Producto prod) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql;
        try {
            sql="update producto set pro_codigo='"+prod.getPro_codigo()+"', pro_descripcion='"+prod.getPro_descripcion()+"', pro_precio_unitario='"+prod.getPro_precio_unitario()+"', pro_stock='"+prod.getPro_stock()+"', cat_codigo='"+prod.getCat_codigo()+"' where pro_codigo='"+prod.getPro_codigo()+"'";                
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void actualizar_stock(String pro_codigo, int nuevo_stock){
        String sql;
        try {
            sql="update producto set pro_stock='"+nuevo_stock+"' where pro_codigo='"+pro_codigo+"'";                
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean eliminar(String pro_codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Producto listarProducto(String pro_codigo){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //ArrayList<Producto>productos = new ArrayList<>();
        Producto pro = new Producto();
        try{
            String sql = "Select * from producto where pro_codigo='"+pro_codigo+"';";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                pro.setPro_codigo(rs.getString("pro_codigo"));
                pro.setPro_descripcion(rs.getString("pro_descripcion"));
                pro.setPro_precio_unitario(rs.getDouble("pro_precio_unitario"));
                pro.setPro_stock(rs.getInt("pro_stock"));
                pro.setCat_codigo(rs.getInt("cat_codigo"));
                pro.setPro_img(rs.getBinaryStream("pro_img"));
                //productos.add(pro);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return pro;
    }

    @Override
    public ArrayList<Producto> listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Producto> productos = new ArrayList<>();
        try{
            String sql = "Select * from producto";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto pro = new Producto();
                pro.setPro_codigo(rs.getString("pro_codigo"));
                pro.setPro_descripcion(rs.getString("pro_descripcion"));
                pro.setPro_precio_unitario(rs.getDouble("pro_precio_unitario"));
                pro.setPro_stock(rs.getInt("pro_stock"));
                pro.setCat_codigo(rs.getInt("cat_codigo"));
                pro.setPro_img(rs.getBinaryStream("pro_img"));
                productos.add(pro);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return productos;
    }
    
    public void listar_imagen(String procod, HttpServletResponse response){
     String sql = "Select * from producto where pro_codigo='"+procod+"';";
        InputStream inputstream=null;
        OutputStream outputstream=null;
        BufferedInputStream bufferedinputstream=null;
        BufferedOutputStream bufferedoutputstream=null;
     try{
        outputstream=response.getOutputStream();
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        rs = ps.executeQuery();
        if(rs.next()){
            inputstream= rs.getBinaryStream("pro_img");
        }
        bufferedinputstream= new BufferedInputStream(inputstream);
        bufferedoutputstream=new BufferedOutputStream(outputstream);
        int i=0;
        while((i=bufferedinputstream.read())!=-1){
            bufferedoutputstream.write(i);
        }
     }
     catch(Exception e){
         
     }
    }

    @Override
    public ArrayList<Producto> listarProductosporCategoria(int cat_codigo) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Producto>lista = new ArrayList<>();
        try{
            String sql = "Select * from producto where cat_codigo='"+cat_codigo+"';";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
               Producto pro = new Producto();
                pro.setPro_codigo(rs.getString("pro_codigo"));
                pro.setPro_descripcion(rs.getString("pro_descripcion"));
                pro.setPro_precio_unitario(rs.getDouble("pro_precio_unitario"));
                pro.setPro_stock(rs.getInt("pro_stock"));
                pro.setCat_codigo(rs.getInt("cat_codigo"));
                pro.setPro_img(rs.getBinaryStream("pro_img"));
                lista.add(pro);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lista;
    }
    
}
