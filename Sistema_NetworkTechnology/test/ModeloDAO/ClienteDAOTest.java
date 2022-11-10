/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Cliente;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USUARIO
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
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
     * Test of agregar method, of class ClienteDAO.
     */
    @Test
    public void testAgregar() {
        System.out.println("Registrar uusuario al sistema");
        Cliente cli = new Cliente("C0010","Rebeca","Meza","Tordoya","72668536","Mzo o2 lt14","Puente Piedra","985639194","rebecamesa@gmail.com","99999");
        ClienteDAO instance = new ClienteDAO();
        instance.agregar(cli);      
    }

    /**
     * Test of editar method, of class ClienteDAO.
     */
//    @Test
//    public void testEditar() {
//        System.out.println("editar");
//        String cli_codigo = "";
//        ClienteDAO instance = new ClienteDAO();
//        boolean expResult = false;
//        boolean result = instance.editar(cli_codigo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of eliminar method, of class ClienteDAO.
     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        String cli_codigo = "";
//        ClienteDAO instance = new ClienteDAO();
//        boolean expResult = false;
//        boolean result = instance.eliminar(cli_codigo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listar method, of class ClienteDAO.
     */
//    @Test
//    public void testListar() {
//        System.out.println("listar");
//        String email = "";
//        String passw = "";
//        ClienteDAO instance = new ClienteDAO();
//        Cliente expResult = null;
//        Cliente result = instance.listar(email, passw);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of recuperarClave method, of class ClienteDAO.
     */
//    @Test
//    public void testRecuperarClave() {
//        System.out.println("recuperarClave");
//        String email = "";
//        ClienteDAO instance = new ClienteDAO();
//        Cliente expResult = null;
//        Cliente result = instance.recuperarClave(email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of recuperarId method, of class ClienteDAO.
     */
//    @Test
//    public void testRecuperarId() {
//        System.out.println("recuperarId");
//        String email = "";
//        ClienteDAO instance = new ClienteDAO();
//        int expResult = 0;
//        int result = instance.recuperarId(email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listarTodoCliente method, of class ClienteDAO.
     */
//    @Test
//    public void testListarTodoCliente() {
//        System.out.println("listarTodoCliente");
//        ClienteDAO instance = new ClienteDAO();
//        ArrayList<Cliente> expResult = null;
//        ArrayList<Cliente> result = instance.listarTodoCliente();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of nuevoCliente method, of class ClienteDAO.
     */
//    @Test
//    public void testNuevoCliente() {
//        System.out.println("nuevoCliente");
//        ClienteDAO instance = new ClienteDAO();
//        int expResult = 0;
//        int result = instance.nuevoCliente();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listarClientes method, of class ClienteDAO.
     */
//    @Test
//    public void testListarClientes() {
//        System.out.println("listarClientes");
//        ClienteDAO instance = new ClienteDAO();
//        ArrayList<Cliente> expResult = null;
//        ArrayList<Cliente> result = instance.listarClientes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
