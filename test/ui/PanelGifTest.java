/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;
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
public class PanelGifTest {
    
    public PanelGifTest() {
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
     * Test of paintComponent method, of class PanelGif.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        if(g != null){
        PanelGif instance = new PanelGif();
        instance.paintComponent(g);
        }
    }

    /**
     * Test of generar method, of class PanelGif.
     */
    @Test
    public void testGenerar() {
        System.out.println("generar");
        PanelGif instance = new PanelGif();
        instance.generar();

    }

    /**
     * Test of ordenarMerge method, of class PanelGif.
     */
    @Test
    public void testOrdenarMerge() {
        System.out.println("ordenarMerge");
        PanelGif instance = new PanelGif();
        instance.ordenarMerge();

    }

    /**
     * Test of ordenarBrick method, of class PanelGif.
     */
    @Test
    public void testOrdenarBrick() {
        System.out.println("ordenarBrick");
        PanelGif instance = new PanelGif();
        instance.ordenarBrick();
    }
    
}
