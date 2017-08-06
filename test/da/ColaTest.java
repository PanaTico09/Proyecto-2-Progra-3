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
public class ColaTest {
    
    public ColaTest() {
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
     * Test of getCabeza method, of class Cola.
     */
    @Test
    public void testGetCabeza() {
        System.out.println("getCabeza");
        Cola instance = new Cola();
        Nodo expResult = null;
        Nodo result = instance.getCabeza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setCabeza method, of class Cola.
     */
    @Test
    public void testSetCabeza() {
        System.out.println("setCabeza");
        Cola instance = new Cola();
        instance.setCabeza(null);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUltimo method, of class Cola.
     */
    @Test
    public void testGetUltimo() {
        System.out.println("getUltimo");
        Cola instance = new Cola();
        Nodo expResult = null;
        Nodo result = instance.getUltimo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setUltimo method, of class Cola.
     */
    @Test
    public void testSetUltimo() {
        System.out.println("setUltimo");
        Cola instance = new Cola();
        instance.setUltimo(null);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of size method, of class Cola.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Cola instance = new Cola();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isEmpty method, of class Cola.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Cola instance = new Cola();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of queue method, of class Cola.
     */
    @Test
    public void testQueue() {
        System.out.println("queue");
        String nombre = "";
        String apellido = "";
        String apellido2 = "";
        String documento = "";
        double edad = 0.0;
        Cola instance = new Cola();
        instance.queue(nombre, apellido, apellido2, documento, edad);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of dequeue method, of class Cola.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        Cola instance = new Cola();
        Nodo expResult = null;
        Nodo result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of top method, of class Cola.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        Cola instance = new Cola();
        Nodo expResult = null;
        Nodo result = instance.top();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of validarCedulaPasaporte method, of class Cola.
     */
    @Test
    public void testValidarCedulaPasaporte() {
        System.out.println("validarCedulaPasaporte");
        String documento = "";
        Cola instance = new Cola();
        boolean expResult = true;
        boolean result = instance.validarCedulaPasaporte(documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of pasaporteFormato method, of class Cola.
     */
    @Test
    public void testPasaporteFormato() {
        System.out.println("pasaporteFormato");
        String Pasaporte = "A123456";
        Cola instance = new Cola();
        boolean expResult = false;
        boolean result = instance.pasaporteFormato(Pasaporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cedulaFormato method, of class Cola.
     */
    @Test
    public void testCedulaFormato() {
        System.out.println("cedulaFormato");
        String Cedula = "1-2345-6789";
        Cola instance = new Cola();
        boolean expResult = false;
        boolean result = instance.cedulaFormato(Cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of pasaporteCedula method, of class Cola.
     */
    @Test
    public void testPasaporteCedula() {
        System.out.println("pasaporteCedula");
        String Documento = "A123456";
        Cola instance = new Cola();
        boolean expResult = true;
        boolean result = instance.pasaporteCedula(Documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of abcMayus method, of class Cola.
     */
    @Test
    public void testAbcMayus() {
        System.out.println("abcMayus");
        char letra = ' ';
        Cola instance = new Cola();
        boolean expResult = false;
        boolean result = instance.abcMayus(letra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of abcMinus method, of class Cola.
     */
    @Test
    public void testAbcMinus() {
        System.out.println("abcMinus");
        char letra = ' ';
        Cola instance = new Cola();
        boolean expResult = false;
        boolean result = instance.abcMinus(letra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of dequeueMultiple method, of class Cola.
     */
    @Test
    public void testDequeueMultiple() {
        System.out.println("dequeueMultiple");
        int index = 0;
        Cola instance = new Cola();
        boolean expResult = false;
        boolean result = instance.dequeueMultiple(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of pasaportePrimero method, of class Cola.
     */
    @Test
    public void testPasaportePrimero() {
        System.out.println("pasaportePrimero");
        Cola instance = new Cola();
        instance.pasaportePrimero();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of insertionSort method, of class Cola.
     */
    @Test
    public void testInsertionSort() {
        System.out.println("insertionSort");
        Cola instance = new Cola();
        instance.insertionSort();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of sortedInsert method, of class Cola.
     */
    @Test
    public void testSortedInsert() {
        System.out.println("sortedInsert");
        Nodo colaOrdenada = null;
        Nodo añadido = null;
        Cola instance = new Cola();
        Nodo expResult = null;
        Nodo result = instance.sortedInsert(colaOrdenada, añadido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of toString method, of class Cola.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cola instance = new Cola();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of ultimoNodoCola method, of class Cola.
     */
    @Test
    public void testUltimoNodoCola() {
        System.out.println("ultimoNodoCola");
        Cola instance = new Cola();
        instance.ultimoNodoCola();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
