/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

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
public class PilaTest {

    public PilaTest() {
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
     * Test of getCabeza method, of class Pila.
     */
    @Test
    public void testGetCabeza() {
        System.out.println("getCabeza");
        Pila instance = new Pila();
        Nodo expResult = null;
        Nodo result = instance.getCabeza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCabeza method, of class Pila.
     */
    @Test
    public void testSetCabeza() {
        System.out.println("setCabeza");
        Pila instance = new Pila();
        instance.setCabeza(null);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getUltimo method, of class Pila.
     */
    @Test
    public void testGetUltimo() {
        System.out.println("getUltimo");
        Pila instance = new Pila();
        Nodo expResult = null;
        Nodo result = instance.getUltimo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setUltimo method, of class Pila.
     */
    @Test
    public void testSetUltimo() {
        System.out.println("setUltimo");
        Pila instance = new Pila();
        instance.setUltimo(null);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of size method, of class Pila.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Pila instance = new Pila();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of isEmpty method, of class Pila.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Pila instance = new Pila();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of push method, of class Pila.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        String nombre = "";
        String apellido = "";
        String apellido2 = "";
        String documento = "";
        double edad = 0.0;
        Pila instance = new Pila();
        instance.push(nombre, apellido, apellido2, documento, edad);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pop method, of class Pila.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Pila instance = new Pila();
        Nodo expResult = null;
        Nodo result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of peek method, of class Pila.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        Pila instance = new Pila();
        Nodo expResult = null;
        Nodo result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of validarCedulaPasaporte method, of class Pila.
     */
    @Test
    public void testValidarCedulaPasaporte() {
        System.out.println("validarCedulaPasaporte");
        String documento = "";
        Pila instance = new Pila();
        boolean expResult = true;
        boolean result = instance.validarCedulaPasaporte(documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pasaporteFormato method, of class Pila.
     */
    @Test
    public void testPasaporteFormato() {
        System.out.println("pasaporteFormato");
        String Pasaporte = "A123456";
        Pila instance = new Pila();
        boolean expResult = false;
        boolean result = instance.pasaporteFormato(Pasaporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of cedulaFormato method, of class Pila.
     */
    @Test
    public void testCedulaFormato() {
        System.out.println("cedulaFormato");
        String Cedula = "1-2345-6789";
        Pila instance = new Pila();
        boolean expResult = false;
        boolean result = instance.cedulaFormato(Cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pasaporteCedula method, of class Pila.
     */
    @Test
    public void testPasaporteCedula() {
        System.out.println("pasaporteCedula");
        String Documento = "A123456";
        Pila instance = new Pila();
        boolean expResult = true;
        boolean result = instance.pasaporteCedula(Documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of abcMayus method, of class Pila.
     */
    @Test
    public void testAbcMayus() {
        System.out.println("abcMayus");
        char letra = ' ';
        Pila instance = new Pila();
        boolean expResult = false;
        boolean result = instance.abcMayus(letra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of abcMinus method, of class Pila.
     */
    @Test
    public void testAbcMinus() {
        System.out.println("abcMinus");
        char letra = ' ';
        Pila instance = new Pila();
        boolean expResult = false;
        boolean result = instance.abcMinus(letra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of popMultiple method, of class Pila.
     */
    @Test
    public void testPopMultiple() {
        System.out.println("popMultiple");
        int index = 0;
        Pila instance = new Pila();
        boolean expResult = false;
        boolean result = instance.popMultiple(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pasaportePrimero method, of class Pila.
     */
    @Test
    public void testPasaportePrimero() {
        System.out.println("pasaportePrimero");
        Pila instance = new Pila();
        instance.pasaportePrimero();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of agregarDesdePilaAux method, of class Pila.
     */
    @Test
    public void testAgregarDesdePilaAux() {
        System.out.println("agregarDesdePilaAux");
        Pila pilaAux = null;
        Pila instance = new Pila();
        if (pilaAux != null) {
            instance.agregarDesdePilaAux(pilaAux);
        }
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class Pila.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Pila instance = new Pila();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setSize method, of class Pila.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 0;
        Pila instance = new Pila();
        instance.setSize(size);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTamaño method, of class Pila.
     */
    @Test
    public void testObtenerTamaño() {
        System.out.println("obtenerTama\u00f1o");
        Pila p = null;
        if (p != null) {
            Pila instance = new Pila();
            int expResult = 0;
            int result = instance.obtenerTamaño(p);
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNodo method, of class Pila.
     */
    @Test
    public void testObtenerNodo() {
        System.out.println("obtenerNodo");
        Pila p = null;
        int index = 0;
        Pila instance = new Pila();
        if (p != null) {
            Nodo expResult = null;
            Nodo result = instance.obtenerNodo(p, index);
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of heapSort method, of class Pila.
     */
    @Test
    public void testHeapSort() {
        System.out.println("heapSort");
        Pila p = null;
        if (p != null) {
            Pila instance = new Pila();
            instance.heapSort(p);
        }
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of heapify method, of class Pila.
     */
    @Test
    public void testHeapify() {
        System.out.println("heapify");
        Pila p = null;
        if (p != null) {
            Pila instance = new Pila();
            instance.heapify(p);
        }
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class Pila.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Pila p = null;
        int i = 0;
        int j = 0;
        if (p != null) {
            Pila instance = new Pila();
            instance.swap(p, i, j);
        }
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of maxheap method, of class Pila.
     */
    @Test
    public void testMaxheap() {
        System.out.println("maxheap");
        Pila p = null;
        int i = 0;
        if (p != null) {
            Pila instance = new Pila();
            instance.maxheap(p, i);
        }
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
