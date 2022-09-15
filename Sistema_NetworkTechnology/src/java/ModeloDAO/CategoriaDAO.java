/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.metodoCategoria;
import Modelo.Categoria;
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
public class CategoriaDAO implements metodoCategoria{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Categoria cat;

    @Override
    public boolean agregar(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(int cat_codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int cat_codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria listar(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> listarTodoCategoria() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Categoria>lista = new ArrayList<>();
        try{
            String sql = "Select * from categorias";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                cat = new Categoria();
                cat.setCat_codigo(rs.getInt("cat_codigo"));
                cat.setCat_nombre(rs.getString("cat_nombre"));
                lista.add(cat);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lista;
    
    }
    
}
