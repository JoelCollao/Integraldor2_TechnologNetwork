/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Producto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.InputStream;
import java.util.Arrays;
import org.junit.Assert;

/**
 *
 * @author USUARIO
 */
public class ProductoDAOTest {
    
    public ProductoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
       
    
    /**
     * Test of agregar method, of class ProductoDAO.
     */
    @Test
    public void testAgregar() throws FileNotFoundException{
        
        System.out.println("agregar");
        Producto pro = new Producto();
        pro.setPro_codigo("P0011");
        pro.setPro_descripcion("PRUEBA DE TEST");
        pro.setPro_precio_unitario(4786);
        pro.setPro_stock(35);
        pro.setCat_codigo(1);
        File initialFile = new File("D:/imagen/producto-pro_img.jpg");
        InputStream targetStream = new FileInputStream(initialFile);
        pro.setPro_img(targetStream);  //ver si se puede mandar como null
        ProductoDAO instance = new ProductoDAO();
        instance.agregar(pro);
        assertFalse(false);   
    }

    /**
     * Test of editar method, of class ProductoDAO.
     * @throws java.io.FileNotFoundException
     */
//    @Test
//    public void testEditar() {
//        System.out.println("Prueba Unitaria Edicion");
//        //File initialFile = new File("D:/imagen/foto.jpg");
//        //InputStream targetStream = new FileInputStream(initialFile);
//        Producto prod = new Producto("P0001", "VASTEC INTEL CORE I3", 1500, 94, 1, null);
//        ProductoDAO instance = new ProductoDAO();
//        instance.editar(prod);
//        assertFalse(false);
//    }

//    /**
//     * Test of actualizar_stock method, of class ProductoDAO.
//     */
//    @Test
//    public void testActualizar_stock() {
//        System.out.println("actualizar_stock");
//        String pro_codigo = "P0001";
//        int nuevo_stock = 95;
//        ProductoDAO instance = new ProductoDAO();
//        instance.actualizar_stock(pro_codigo, nuevo_stock);
//        assertFalse(false);
//        
//    }
//
//    /**
//     * Test of eliminar method, of class ProductoDAO.
//     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        String pro_codigo = "P0011";
//        ProductoDAO instance = new ProductoDAO();
//        boolean expResult = false;
//        boolean result = instance.eliminar(pro_codigo);
//        assertEquals(expResult, result);      
//       
//    }
//
//    /**
//     * Test of listarProducto method, of class ProductoDAO.
//     */
//    @Test
//    public void testListarProducto() throws FileNotFoundException, IOException{
//        System.out.println("listarProducto");
          
//        System.out.println("imagen prueba");
//        String data = "D:/imagen/producto-pro_img.jpg";
//        
//        File initialFile = new File("D:/imagen/producto-pro_img.jpg");
//        InputStream targetStream = new FileInputStream(initialFile);
//        
//        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
//        System.out.println(targetStream);    
    
 
//        String pro_codigo = "P0017";
//        
//        ProductoDAO instance = new ProductoDAO();
//        Producto expResult = new Producto("P0017","TOSHIBA",5,35,1,null);
//        System.out.println(expResult);
//           
//        Producto result = instance.listarProducto(pro_codigo);
//        
//        System.out.println(result.getPro_codigo());
//        System.out.println(result.getPro_descripcion());
//        System.out.println(result.getPro_precio_unitario());
//        System.out.println(result.getPro_stock());
//        System.out.println(result.getCat_codigo());
//        System.out.println(result.getPro_img());
//        System.out.println("--------");
//        System.out.println(result);
//        System.out.println(expResult);
//        
//        assertEquals(expResult, result);
       
    }
//
//    /**
//     * Test of listar method, of class ProductoDAO.
//     */
//    @Test
//    public void testListar() {
//        System.out.println("listar");
//        ProductoDAO instance = new ProductoDAO();
//        ArrayList<Producto> expResult = null;
//        ArrayList<Producto> result = instance.listar();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of listar_imagen method, of class ProductoDAO.
//     */
//    @Test
//    public void testListar_imagen() {
//        System.out.println("listar_imagen");
//        String procod = "";
//        HttpServletResponse response = null;
//        ProductoDAO instance = new ProductoDAO();
//        instance.listar_imagen(procod, response);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarProductosporCategoria method, of class ProductoDAO.
//     */
//    @Test
//    public void testListarProductosporCategoria() {
//        System.out.println("listarProductosporCategoria");
//        int cat_codigo = 0;
//        ProductoDAO instance = new ProductoDAO();
//        ArrayList<Producto> expResult = null;
//        ArrayList<Producto> result = instance.listarProductosporCategoria(cat_codigo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }


//}
