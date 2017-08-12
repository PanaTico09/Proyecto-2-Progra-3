/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.awt.Graphics2D;
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
public class BoxNumberTest {

    public BoxNumberTest() {
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
     * Test of draw method, of class BoxNumber.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics2D g2 = null;
        if (g2 != null) {
            BoxNumber instance = new BoxNumber();
            instance.draw(g2);
        }
    }
}
