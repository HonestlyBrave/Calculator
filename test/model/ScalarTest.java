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
public class ScalarTest {

    /**
     * Test object.
     */
    private final Scalar testInstance;

    /**
     * Default constructor.
     */
    public ScalarTest() {
        this.testInstance = new Scalar(25.5);
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Scalar class : ");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Scalar class testing complete.\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNumber method, of class Scalar.
     */
    @Test
    public void testGetNumber() {
        System.out.println("Method getNumber : ");

        Scalar instance = testInstance;
        double expResult = 25.5;
        double result = instance.getNumber();

        assertEquals("Getter failed.", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of setNumber method, of class Scalar.
     */
    @Test
    public void testSetNumber() {
        System.out.println("Method setNumber : ");

        double number = 55.0;
        Scalar instance = testInstance;
        double preResult = instance.getNumber();
        instance.setNumber(number);
        double postResult = instance.getNumber();

        assertTrue("Setter failed.", preResult != postResult);

        System.out.println("Complete.\n");
    }

    /**
     * Test of evaluate method, of class Scalar.
     */
    @Test
    public void testEvaluate() {
        System.out.println("Method evaluate : ");

        Scalar instance = testInstance;
        double expResult = 25.5;
        double result = instance.evaluate();

        assertEquals("Evaluate failed", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of toString method, of class Scalar.
     */
    @Test
    public void testToString() {
        System.out.println("Method toString : ");

        Scalar instance = testInstance;
        String expResult = "25.5";
        String result = instance.toString();

        assertEquals("ToString failed.", expResult, result);

        System.out.println("Complete.\n");
    }

}
