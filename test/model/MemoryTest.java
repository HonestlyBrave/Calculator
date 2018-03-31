package model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class MemoryTest {

    /**
     * Test object.
     */
    private final Memory testInstance;

    public MemoryTest() {
        this.testInstance = Memory.getInstance();
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Memory class : ");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Memory class testing complete.\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Memory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("Method getInstance : ");

        Memory.getInstance().clear();
        double expResult = 0;
        double result = Memory.getInstance().evaluate();

        assertEquals("GetInstance failed.", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of add method, of class Memory.
     */
    @Test
    public void testAdd() {
        System.out.println("Method add : ");

        double value = 10.0;
        Memory instance = testInstance;
        instance.add(value);
        double expResult = 10;
        double result = testInstance.evaluate();

        assertEquals("Add failed.", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of subtract method, of class Memory.
     */
    @Test
    public void testSubtract() {
        System.out.println("Method subtract : ");

        double value = 5.0;
        Memory instance = testInstance;
        instance.subtract(value);
        double expResult = 5;
        double result = testInstance.evaluate();

        assertEquals("Subtract failed.", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of clear method, of class Memory.
     */
    @Test
    public void testClear() {
        System.out.println("Method clear : ");

        Memory instance = testInstance;
        instance.clear();
        double expResult = 0;
        double result = testInstance.evaluate();

        assertEquals("Subtract failed.", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of evaluate method, of class Memory.
     */
    @Test
    public void testEvaluate() {
        System.out.println("Method evaluate : ");

        double value1 = 5.0, value2 = 10.0;
        Memory instance = testInstance;
        double expResult = 0;
        double result = instance.evaluate();

        assertEquals("Evaluate failed.", expResult, result, 0.0);

        instance.add(value1);
        expResult = 5;
        result = instance.evaluate();

        assertEquals("Evaluate after adding a value failed.", expResult, result,
                0.0);

        instance.subtract(value2);
        expResult = -5;
        result = instance.evaluate();

        assertEquals("Evaluate after subtracting a value failed.", expResult,
                result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of toString method, of class Memory.
     */
    @Test
    public void testToString() {
        System.out.println("Method toString : ");

        Memory instance = testInstance;
        String expResult = "0";
        String result = instance.toString();

        assertEquals("ToString failed.", expResult, result);

        System.out.println("Complete.\n");
    }

}
