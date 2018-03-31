package model;

import model.operator.*;
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
public class BaseExpressionTest {

    /**
     * Test object.
     */
    private final Scalar testScalar1;

    /**
     * Test object.
     */
    private final Scalar testScalar2;

    /**
     * Test object.
     */
    private final Operator testAdd;

    /**
     * Test object.
     */
    private final Operator testSubtract;

    /**
     * Test object.
     */
    private final Operator testMultiply;

    /**
     * Test object.
     */
    private final Operator testDivide;

    /**
     *
     */
    public BaseExpressionTest() {
        this.testDivide = new Divide();
        this.testMultiply = new Multiply();
        this.testSubtract = new Subtract();
        this.testAdd = new Add();
        this.testScalar2 = new Scalar(5);
        this.testScalar1 = new Scalar(5);
    }

    /**
     * Test object.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Base Expression class : ");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Base Expression class testing complete.\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addFirst method, of class BaseExpression.
     */
    @Test
    public void testAddFirst() {
        System.out.println("Method addFirst : ");

        Element element = testScalar1;
        BaseExpression instance = new BaseExpression();
        instance.addFirst(element);

        System.out.println("No getter. Test Evaluate and ToString dependant.\n");
    }

    /**
     * Test of addSecond method, of class BaseExpression.
     */
    @Test
    public void testAddSecond() {
        System.out.println("Method addSecond : ");

        Element element = testScalar2;
        BaseExpression instance = new BaseExpression();
        instance.addSecond(element);

        System.out.println("No getter. Test Evaluate and ToString dependant.\n");
    }

    /**
     * Test of evaluate method, of class BaseExpression.
     */
    @Test
    public void testEvaluate() {
        System.out.println("Method evaluate : ");

        BaseExpression instance = new BaseExpression(testScalar1, testAdd,
                testScalar2);
        double expResult = 10.0;
        double result = instance.evaluate();
        assertEquals("Evaluate with add operator failed.", expResult, result,
                0.0);

        instance = new BaseExpression(testScalar1, testSubtract, testScalar2);
        expResult = 0.0;
        result = instance.evaluate();
        assertEquals("Evaluate with subtract operator failed.", expResult,
                result, 0.0);

        instance = new BaseExpression(testScalar1, testMultiply, testScalar2);
        expResult = 25.0;
        result = instance.evaluate();
        assertEquals("Evaluate with multiply operator failed.", expResult,
                result, 0.0);

        instance = new BaseExpression(testScalar1, testDivide, testScalar2);
        expResult = 1.0;
        result = instance.evaluate();
        assertEquals("Evaluate with divide operator failed.", expResult, result,
                0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of toString method, of class BaseExpression.
     */
    @Test
    public void testToString() {
        System.out.println("Method toString : ");

        BaseExpression instance = new BaseExpression(testScalar1, testMultiply,
                testScalar2);
        String expResult = "(5 ˣ 5)";
        String result = instance.toString();
        assertEquals("ToString failed.", expResult, result);

        System.out.println("Complete.\n");
    }

}
