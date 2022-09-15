/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoCarrito;
import Modelo.Carrito;
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

/**
 *
 * @author mrang
 */
public class CarritoDAO implements metodoCarrito {

    public ArrayList<Carrito> listarCarrito = new ArrayList();
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Carrito c;

    @Override
    public ArrayList<Carrito> listarCarrito() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Carrito> carrito = new ArrayList<>();
        try {
            String sql = "Select * from carrito";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Carrito car = new Carrito();
                car.setItem(rs.getInt("item"));
                car.setFoto(rs.getBinaryStream("car_producto"));
                car.setCodigo_producto(rs.getString("pro_codigo"));
                car.setDescripcion_producto(rs.getString("car_descripcion"));
                car.setCantidad(rs.getInt("car_cantidad"));
                car.setPrecio_unitario_producto(rs.getDouble("car_precio_unit"));
                car.setSubtotal(rs.getDouble("car_sub_total"));
                carrito.add(car);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carrito;
    }

    @Override
    public Carrito listarCarritoporDescripcion(String descripcion_producto) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Carrito car = new Carrito();
        try {
            String sql = "Select * from carrito where car_descripcion='" + descripcion_producto + "';";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                car.setItem(rs.getInt("item"));
                car.setCodigo_producto(rs.getString("pro_codigo"));
                car.setFoto(rs.getBinaryStream("car_producto"));
                car.setDescripcion_producto(rs.getString("car_descripcion"));
                car.setCantidad(rs.getInt("car_cantidad"));
                car.setPrecio_unitario_producto(rs.getDouble("car_precio_unit"));
                car.setSubtotal(rs.getDouble("car_sub_total"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return car;
    }

    public void listar_imagen(String car_descripcion, HttpServletResponse response) {
        String sql = "Select * from producto where pro_descripcion='" + car_descripcion + "';";
        InputStream inputstream = null;
        OutputStream outputstream = null;
        BufferedInputStream bufferedinputstream = null;
        BufferedOutputStream bufferedoutputstream = null;
        try {
            outputstream = response.getOutputStream();
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputstream = rs.getBinaryStream("pro_img");
            }
            bufferedinputstream = new BufferedInputStream(inputstream);
            bufferedoutputstream = new BufferedOutputStream(outputstream);
            int i = 0;
            while ((i = bufferedinputstream.read()) != -1) {
                bufferedoutputstream.write(i);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public boolean buscarProducto(String descripcion_producto) {
        boolean result = false;
        try {
            String sql = "Select * from carrito where car_descripcion='" + descripcion_producto + "';";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void agregarCarrito(Carrito carrito) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //listarCarrito = new ArrayList();
        try {
            String sql = "insert into Carrito(item, pro_codigo, car_descripcion, car_producto, car_cantidad, car_precio_unit, car_sub_total) "
                    + "values('" + carrito.getItem() + "', '" + carrito.getCodigo_producto() + "', '" + carrito.getDescripcion_producto() + "', '" + carrito.getFoto() + "', '" + carrito.getCantidad() + "','" + carrito.getPrecio_unitario_producto() + "'," + carrito.getSubtotal() + ")";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void eliminarCarrito() {
        try {
            String sql = "delete from carrito";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean eliminarItem(int item) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String sql = "delete from carrito where item='" + item + "'";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean actualizarCantidad(String descripcion_producto, int cantidad, double subtotal) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String sql = "update carrito set car_cantidad=" + cantidad + ",car_sub_total=" + subtotal + " where car_descripcion='" + descripcion_producto + "'";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
