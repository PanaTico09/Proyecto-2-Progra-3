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
public class ListaTest {

    public ListaTest() {
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
     * Test of size method, of class Lista.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Lista instance = new Lista();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCabeza method, of class Lista.
     */
    @Test
    public void testGetCabeza() {
        System.out.println("getCabeza");
        Lista instance = new Lista();
        Nodo expResult = null;
        Nodo result = instance.getCabeza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCabeza method, of class Lista.
     */
    @Test
    public void testSetCabeza() {
        System.out.println("setCabeza");
        Lista instance = new Lista();
        instance.setCabeza(null);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getUltimo method, of class Lista.
     */
    @Test
    public void testGetUltimo() {
        System.out.println("getUltimo");
        Lista instance = new Lista();
        Nodo expResult = null;
        Nodo result = instance.getUltimo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setUltimo method, of class Lista.
     */
    @Test
    public void testSetUltimo() {
        System.out.println("setUltimo");
        Lista instance = new Lista();
        instance.setUltimo(null);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of isEmpty method, of class Lista.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Lista instance = new Lista();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addSimple method, of class Lista.
     */
    @Test
    public void testAdd() {
        System.out.println("addSimple");
        String nombre = "";
        String apellido = "";
        String apellido2 = "";
        String documento = "";
        double edad = 0.0;
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.add(nombre, apellido, apellido2, documento, edad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addFirstSimple method, of class Lista.
     */
    @Test
    public void testAddFirstSimple() {
        System.out.println("addFirstSimple");
        String nombre = "";
        String apellido = "";
        String apellido2 = "";
        String documento = "";
        double edad = 0.0;
        Lista instance = new Lista();
        boolean expResult = true;
        boolean result = instance.addFirstSimple(nombre, apellido, apellido2, documento, edad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addCircular method, of class Lista.
     */
    @Test
    public void testAddCircular() {
        System.out.println("addCircular");
        String nombre = "";
        String apellido = "";
        String apellido2 = "";
        String documento = "";
        double edad = 0.0;
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.addCircular(nombre, apellido, apellido2, documento, edad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of validarCedulaPasaporte method, of class Lista.
     */
    @Test
    public void testValidarCedulaPasaporte() {
        System.out.println("validarCedulaPasaporte");
        String documento = "";
        Lista instance = new Lista();
        boolean expResult = true;
        boolean result = instance.validarCedulaPasaporte(documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pasaporteFormato method, of class Lista.
     */
    @Test
    public void testPasaporteFormato() {
        System.out.println("pasaporteFormato");
        String Pasaporte = "A123456";
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.pasaporteFormato(Pasaporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of cedulaFormato method, of class Lista.
     */
    @Test
    public void testCedulaFormato() {
        System.out.println("cedulaFormato");
        String Cedula = "1-2345-6789";
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.cedulaFormato(Cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pasaporteCedula method, of class Lista.
     */
    @Test
    public void testPasaporteCedula() {
        System.out.println("pasaporteCedula");
        String Documento = "A123456";
        Lista instance = new Lista();
        boolean expResult = true;
        boolean result = instance.pasaporteCedula(Documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of abcMayus method, of class Lista.
     */
    @Test
    public void testAbcMayus() {
        System.out.println("abcMayus");
        char letra = ' ';
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.abcMayus(letra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of abcMinus method, of class Lista.
     */
    @Test
    public void testAbcMinus() {
        System.out.println("abcMinus");
        char letra = ' ';
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.abcMinus(letra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of remove method, of class Lista.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pasaportePrimero method, of class Lista.
     */
    @Test
    public void testPasaportePrimero() {
        System.out.println("pasaportePrimero");
        Lista instance = new Lista();
        instance.pasaportePrimero();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of ultimoNodoLista method, of class Lista.
     */
    @Test
    public void testUltimoNodoLista() {
        System.out.println("ultimoNodoLista");
        Lista instance = new Lista();
        instance.ultimoNodoLista();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of mergeSort method, of class Lista.
     */
    @Test
    public void testMergeSort() {
        System.out.println("mergeSort");
        Nodo inicial = null;
        Lista instance = new Lista();
        Nodo expResult = null;
        Nodo result = instance.mergeSort(inicial);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class Lista.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lista instance = new Lista();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of dividirLista method, of class Lista.
     */
    @Test
    public void testDividirLista() {
        System.out.println("dividirLista");
        Nodo inicial = null;
        Lista instance = new Lista();
        Nodo expResult = null;
        Nodo result = instance.dividirLista(inicial);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of mergeS method, of class Lista.
     */
    @Test
    public void testMergeS() {
        System.out.println("mergeS");
        Nodo izqIni = null;
        Nodo derIni = null;
        Lista instance = new Lista();
        instance.mergeS(izqIni, derIni);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of obtenerNodo method, of class Lista.
     */
    @Test
    public void testObtenerNodo() {
        System.out.println("obtenerNodo");
        Lista p = null;
        int index = 0;
        if (p != null) {
            Lista instance = new Lista();
            Nodo expResult = null;
            Nodo result = instance.obtenerNodo(p, index);
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of swap method, of class Lista.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Lista p = null;
        int i = 0;
        int j = 0;
        if (p != null) {
            Lista instance = new Lista();
            instance.swap(p, i, j);
        }
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of brickSort method, of class Lista.
     */
    @Test
    public void testBrickSort() {
        System.out.println("brickSort");
        Lista p = null;
        if (p != null) {
            Lista instance = new Lista();
            instance.brickSort(p);
        }
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of pasaportePrimeroC method, of class Lista.
     */
    @Test
    public void testPasaportePrimeroC() {
        System.out.println("pasaportePrimeroC");
        Lista instance = new Lista();
        instance.pasaportePrimeroC();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of linkeos method, of class Lista.
     */
    @Test
    public void testLinkeos() {
        System.out.println("linkeos");
        Lista instance = new Lista();
        instance.linkeos();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of mergeSortC method, of class Lista.
     */
    @Test
    public void testMergeSortC() {
        System.out.println("mergeSortC");
        Nodo inicial = null;
        if (inicial != null) {
            Lista instance = new Lista();
            Nodo expResult = null;
            Nodo result = instance.mergeSortC(inicial);
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of mergeC method, of class Lista.
     */
    @Test
    public void testMergeC() {
        System.out.println("mergeC");
        Nodo izqIni = null;
        Nodo derIni = null;
        Lista instance = new Lista();
        if (izqIni != null) {
            instance.mergeC(izqIni, derIni);
        }
        // TODO review the generated test code and remove the default call to fail.

    }

}
