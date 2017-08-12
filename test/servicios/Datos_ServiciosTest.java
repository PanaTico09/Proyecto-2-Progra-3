/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import da.DatosAlgoritmos;
import java.sql.Connection;
import java.util.List;
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
public class Datos_ServiciosTest {

    public Datos_ServiciosTest() {
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
     * Test of guardar method, of class Datos_Servicios.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardar");
        Connection conexion = null;
        if (conexion != null) {
            DatosAlgoritmos datos = null;
            Datos_Servicios instance = new Datos_Servicios();
            instance.guardar(conexion, datos);
        }
    }

    /**
     * Test of eliminar method, of class Datos_Servicios.
     */
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Connection conexion = null;
        if (conexion != null) {
            Datos_Servicios instance = new Datos_Servicios();
            instance.eliminar(conexion);
        }
    }

    /**
     * Test of recuperarTodas method, of class Datos_Servicios.
     */
    @Test
    public void testRecuperarTodas() throws Exception {
        System.out.println("recuperarTodas");
        Connection conexion = null;
        if (conexion != null) {
            Datos_Servicios instance = new Datos_Servicios();
            List<DatosAlgoritmos> expResult = null;
            List<DatosAlgoritmos> result = instance.recuperarTodas(conexion);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of recuperarMasRapido method, of class Datos_Servicios.
     */
    @Test
    public void testRecuperarMasRapido() throws Exception {
        System.out.println("recuperarMasRapido");
        Connection conexion = null;
        if (conexion != null) {
            Datos_Servicios instance = new Datos_Servicios();
            List<DatosAlgoritmos> expResult = null;
            List<DatosAlgoritmos> result = instance.recuperarMasRapido(conexion);
            assertEquals(expResult, result);
        }
    }

}
