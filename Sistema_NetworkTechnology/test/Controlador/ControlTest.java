/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
/**
 *
 * @author USUARIO
 */
public class ControlTest {
    
//    public Control servlet;
//    public MockHttpServletRequest mokito;
//    public MockHttpServletResponse res;
//    
    public ControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
//        servlet = new Control();
//        mokito = new MockHttpServletRequest();
//        res = new MockHttpServletResponse();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of processRequest method, of class Control.
     * @throws java.lang.Exception
     */
       
    
    @Test
    public void testProcessRequest() throws Exception {
          
            System.out.println("processRequest Administrador"); 
            MockHttpServletRequest request = new MockHttpServletRequest();
            request.getSession();
            request.setParameter("email","A0003");
            request.setParameter("pass","administrador666");
            MockHttpServletResponse response = new MockHttpServletResponse();
            System.out.println(request);
            System.out.println(response);             
            Control instance = new Control();
            instance.doGet(request, response);                
    }


    /**
     * Test of doGet method, of class Control.
     */
//    @Test
//    public void testDoGet() throws Exception {
//        System.out.println("doGet");
//        HttpServletRequest request = null;
//        HttpServletResponse response = null;
//        Control instance = new Control();
//        instance.doGet(request, response);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of doPost method, of class Control.
//     */
//    @Test
//    public void testDoPost() throws Exception {
//        System.out.println("doPost");
//        HttpServletRequest request = null;
//        HttpServletResponse response = null;
//        Control instance = new Control();
//        instance.doPost(request, response);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getServletInfo method, of class Control.
//     */
//    @Test
//    public void testGetServletInfo() {
//        System.out.println("getServletInfo");
//        Control instance = new Control();
//        String expResult = "";
//        String result = instance.getServletInfo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
