/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johan Herrera
 */
public class ConexionTest {
    
    public ConexionTest() {
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
     * Test of obtener method, of class Conexion.
     * @throws java.lang.Exception
     */
    @Test
    public void testObtener() throws Exception {
        System.out.println("obtener");
        Connection expResult = Conexion.obtener();
        Connection result = Conexion.obtener();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cerrar method, of class Conexion.
     * @throws java.lang.Exception
     */
    @Test
    public void testCerrar() throws Exception {
        System.out.println("cerrar");
        Conexion.cerrar();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
