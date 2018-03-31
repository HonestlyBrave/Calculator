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
public class EquationTest {

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
     * Test object.
     */
    private final Equation testInstance;

    public EquationTest() {
        this.testInstance = new Equation();
        this.testDivide = new Divide();
        this.testMultiply = new Multiply();
        this.testSubtract = new Subtract();
        this.testAdd = new Add();
        this.testScalar2 = new Scalar(5);
        this.testScalar1 = new Scalar(5);
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Equation class : ");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Equation class testing complete.\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class Equation.
     */
    @Test
    public void testAddItem_Scalar() {
        System.out.println("Method addItem scalar : ");

        Scalar scalar = testScalar1;
        Equation instance = testInstance;

        instance.addItem(scalar);

        assertTrue("AddItem with scalar instance check failed.", instance
                .lastIsScalar());

        double expResult = testScalar1.evaluate();
        double result = instance.evaluate();

        assertEquals("AddItem with Scalar value check failed.", expResult,
                result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of addItem method, of class Equation.
     */
    @Test
    public void testAddItem_Operator() {
        System.out.println("Method addItem operator : ");

        Operator operator = testAdd;
        Equation instance = new Equation();

        instance.addItem(testScalar1);
        instance.addItem(operator);
        instance.addItem(testScalar2);

        double expResult = 10.0;
        double result = instance.evaluate();

        assertEquals("AddItem with add operator failed.", expResult,
                result, 0.0);

        operator = testSubtract;
        instance = new Equation();

        instance.addItem(testScalar1);
        instance.addItem(operator);
        instance.addItem(testScalar2);

        expResult = 0.0;
        result = instance.evaluate();

        assertEquals("AddItem with subtract operator failed.", expResult,
                result, 0.0);

        operator = testMultiply;
        instance = new Equation();

        instance.addItem(testScalar1);
        instance.addItem(operator);
        instance.addItem(testScalar2);

        expResult = 25.0;
        result = instance.evaluate();

        assertEquals("AddItem with multiply operator failed.", expResult,
                result, 0.0);

        operator = testDivide;
        instance = new Equation();

        instance.addItem(testScalar1);
        instance.addItem(operator);
        instance.addItem(testScalar2);

        expResult = 1.0;
        result = instance.evaluate();

        assertEquals("AddItem with divide operator failed.", expResult,
                result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of addItem method, of class Equation.
     */
    @Test
    public void testAddItem_Equation() {
        System.out.println("Method addItem equation : ");

        Equation equation = testInstance;
        Equation instance = new Equation();

        instance.addItem(equation);

        assertTrue("AddItem with equation instance check failed.", instance
                .lastIsEquation());

        System.out.println("Complete.\n");
    }

    /**
     * Test of closeEquation method, of class Equation.
     */
    @Test
    public void testCloseEquation() {
        System.out.println("Method closeEquation : ");

        Equation equation = new Equation();
        Equation instance = new Equation();

        instance.addItem(equation);
        instance.addItem(testScalar1);

        instance.closeEquation();

        assertTrue("CloseEquation failed.", instance
                .nestedLastItemIsClosedEquation());

        System.out.println("Complete.\n");
    }

    /**
     * Test of evaluate method, of class Equation.
     */
    @Test
    public void testEvaluate() {
        System.out.println("Method evaluate : ");

        Operator operator = testAdd;
        Equation instance = new Equation();

        instance.addItem(testScalar1);
        instance.addItem(operator);
        instance.addItem(testScalar2);

        double expResult = 10.0;
        double result = instance.evaluate();

        assertEquals("Evaluate failed.", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of toString method, of class Equation.
     */
    @Test
    public void testToString() {
        System.out.println("Method toString : ");

        Operator operator = testAdd;
        Equation instance = testInstance;

        instance.addItem(testScalar1);
        instance.addItem(operator);
        instance.addItem(testScalar2);
        instance.evaluate();

        String expResult = "(5 + 5)";
        String result = instance.toString();

        assertEquals("ToString failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of checkAll4FirstOperand method, of class Equation.
     */
    @Test
    public void testCheckAll4FirstOperand() {
        System.out.println("Method checkAll4FirstOperand : ");

        Equation instance = new Equation();

        boolean result = instance.checkAll4FirstOperand();

        assertFalse("CheckAll4FirstOperand with no operand failed.", result);

        instance.addItem(testScalar1);

        result = instance.checkAll4FirstOperand();

        assertTrue("CheckAll4FirstOperand with one operand failed.", result);

        instance.addItem(new Equation());

        result = instance.checkAll4FirstOperand();

        assertFalse("CheckAll4FirstOperand with one operand and "
                + "an empty equation failed.", result);

        instance.addItem(new Equation());
        instance.addItem(testScalar1);

        result = instance.checkAll4FirstOperand();

        assertTrue("CheckAll4FirstOperand with one operand and "
                + "a non-empty equation failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of checkAll4Unsolvable method, of class Equation.
     */
    @Test
    public void testCheckAll4Unsolvable() {
        System.out.println("Method checkAll4Unsolvable : ");

        Equation instance = new Equation();

        boolean result = instance.checkAll4Unsolvable();

        assertTrue("CheckAll4Unsolvable with no operands failed.", result);

        instance.addItem(testScalar1);

        result = instance.checkAll4Unsolvable();

        assertFalse("CheckAll4Unsolvable with one operand failed.", result);

        instance.addItem(testAdd);

        result = instance.checkAll4Unsolvable();

        assertTrue(
                "CheckAll4Unsolvable with one operand and one operator failed.",
                result);

        instance.addItem(testScalar2);

        result = instance.checkAll4Unsolvable();

        assertFalse(
                "CheckAll4Unsolvable with two operands and one operator failed.",
                result);

        System.out.println("Complete.\n");

    }

    /**
     * Test of nestedLastItemIsClosedEquation method, of class Equation.
     */
    @Test
    public void testNestedLastItemIsClosedEquation() {
        System.out.println("Method nestedLastItemIsClosedEquation : ");

        Equation instance = new Equation();
        Equation equationItem = new Equation();
        instance.addItem(equationItem);
        instance.addItem(testScalar1);
        instance.closeEquation();

        boolean result = instance.nestedLastItemIsClosedEquation();

        assertTrue("NestedLastItemIsClosedEquation failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of anyEquationEmpty method, of class Equation.
     */
    @Test
    public void testAnyEquationEmpty() {
        System.out.println("Method anyEquationEmpty : ");

        Equation instance = new Equation();

        boolean result = instance.anyEquationEmpty();

        assertTrue("AnyEquationEmpty failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of nestedLastItemIsOperator method, of class Equation.
     */
    @Test
    public void testNestedLastItemIsOperator() {
        System.out.println("Method nestedLastItemIsOperator : ");

        Equation instance = testInstance;
        instance.addItem(testScalar1);

        boolean result = instance.nestedLastItemIsOperator();

        assertFalse("NestedLastItemIsOperator failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of lastIsEquation method, of class Equation.
     */
    @Test
    public void testLastIsEquation() {
        System.out.println("Method lastIsEquation : ");

        Equation instance = new Equation();
        instance.addItem(testScalar1);

        boolean result = instance.lastIsEquation();

        assertFalse("LastIsEquation with one scalar failed.", result);

        instance.addItem(testInstance);

        result = instance.lastIsEquation();

        assertTrue("LastIsEquation with one scalar and one equation failed.",
                result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of lastIsOperator method, of class Equation.
     */
    @Test
    public void testLastIsOperator() {
        System.out.println("Method lastIsOperator : ");

        Equation instance = testInstance;
        instance.addItem(testScalar1);

        boolean result = instance.nestedLastItemIsOperator();

        assertFalse("LastItemIsOperator with one scalar failed.", result);

        instance.addItem(testAdd);

        result = instance.nestedLastItemIsOperator();

        assertTrue("LastItemIsOperator with one scalar and one operator failed.",
                result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of getLastItem method, of class Equation.
     */
    @Test
    public void testGetLastItem() {
        System.out.println("Method getLastItem : ");

        Equation instance = new Equation();

        Object expResult = null;
        Object result = instance.getLastItem();

        assertEquals("GetLastItem with no items failed.", expResult, result);

        instance.addItem(testScalar1);

        expResult = testScalar1;
        result = instance.getLastItem();

        assertEquals("GetLastItem with one scalar failed.", expResult, result);

        instance.addItem(testAdd);

        expResult = testAdd;
        result = instance.getLastItem();

        assertEquals(
                "GetLastItem with one scalar and one operator failed.",
                expResult, result);

        instance.addItem(testInstance);

        expResult = testInstance;
        result = instance.getLastItem();

        assertEquals(
                "GetLastItem with one scalar, one operator and one equation failed.",
                expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of isSolvable method, of class Equation.
     */
    @Test
    public void testIsSolvable() {
        System.out.println("Method isSolvable : ");

        Equation instance = new Equation();

        boolean result = instance.isSolvable();

        assertFalse("IsSolvable with empty equation failed.", result);

        instance.addItem(testScalar1);

        result = instance.isSolvable();

        assertTrue("IsSolvable with one scalar in one equation failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of undoOperation method, of class Equation.
     */
    @Test
    public void testUndoOperation() {
//        System.out.println("Method undoOperation : ");
//
//        Equation instance = testInstance;
//        instance.undoOperation();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addMemory method, of class Equation.
     */
    @Test
    public void testAddMemory() {
        System.out.println("Method addMemory : ");

        Equation instance = new Equation();
        instance.clearMemory();
        double expResult = 25;
        instance.addMemory(expResult);
        double result = instance.evaluateMemory();

        assertEquals("AddMemory with double value failed.", expResult, result, 0);

        instance = new Equation();
        expResult = 50;
        instance.addMemory(25);
        result = instance.evaluateMemory();

        assertEquals("AddMemory with new equation instance failed.", expResult,
                result, 0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of subtractMemory method, of class Equation.
     */
    @Test
    public void testSubtractMemory() {
        System.out.println("Method subtractMemory : ");

        Equation instance = new Equation();
        instance.clearMemory();
        double value = 15.0;
        instance.addMemory(25);
        instance.subtractMemory(value);

        double expResult = 10;
        double result = instance.evaluateMemory();

        assertEquals("SubtractMemory with double value failed.", expResult,
                result, 0);

        instance = new Equation();
        instance.addMemory(55);
        instance.subtractMemory(value);

        expResult = 50;
        result = instance.evaluateMemory();

        assertEquals("SubtractMemory with new equation instance failed.",
                expResult, result, 0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of recallMemory method, of class Equation.
     */
    @Test
    public void testRecallMemory() {
        System.out.println("Method recallMemory : ");

        Equation instance = new Equation();
        instance.clearMemory();

        String expResult = "";
        String result = instance.recallMemory();

        assertEquals("RecallMemory with zero value failed.", expResult, result);

        instance.addMemory(100);

        expResult = "100";
        result = instance.recallMemory();

        assertEquals("RecallMemory with added value failed.", expResult, result);

        instance.addMemory(100);
        instance.subtractMemory(50);

        expResult = "150";
        result = instance.recallMemory();

        assertEquals("RecallMemory with added and subtracted value failed.",
                expResult, result);

        instance.subtractMemory(100);

        expResult = "50";
        result = instance.recallMemory();

        assertEquals("RecallMemory with subtracted value failed.", expResult,
                result);

        instance = new Equation();

        expResult = "50";
        result = instance.recallMemory();

        assertEquals("RecallMemory with new equation failed.", expResult,
                result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of clearMemory method, of class Equation.
     */
    @Test
    public void testClearMemory() {
        System.out.println("Method clearMemory : ");

        Equation instance = new Equation();
        instance.clearMemory();

        double expResult = 0;
        double result = instance.evaluateMemory();

        assertEquals("ClearMemory failed.", expResult, result, 0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of lastIsClosedEquation method, of class Equation.
     */
    @Test
    public void testLastIsClosedEquation() {
        System.out.println("Method lastIsClosedEquation : ");

        Equation instance = new Equation();
        Equation equationItem = new Equation();
        instance.addItem(equationItem);

        boolean result = instance.lastIsClosedEquation();

        assertFalse("LastIsClosedEquation with new equation failed.", result);

        instance.addItem(testScalar1);
        instance.closeEquation();

        result = instance.lastIsClosedEquation();

        assertTrue("LastIsClosedEquation with closed equation failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of evaluateMemory method, of class Equation.
     */
    @Test
    public void testEvaluateMemory() {
        System.out.println("Method evaluateMemory : ");

        Equation instance = new Equation();
        instance.clearMemory();
        instance.addMemory(10);

        double expResult = 10.0;
        double result = instance.evaluateMemory();

        assertEquals("EvaluateMemory failed.", expResult, result, 0.0);

        System.out.println("Complete.\n");
    }

    /**
     * Test of getInput method, of class Equation.
     */
    @Test
    public void testGetInput() {
        System.out.println("Method getInput : ");

        Equation instance = new Equation();

        String expResult = "";
        String result = instance.getInput();

        assertEquals("GetInput with no input failed.", expResult, result);

        instance.setInput("123");

        expResult = "123";
        result = instance.getInput();

        assertEquals("GetInput with input failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of setInput method, of class Equation.
     */
    @Test
    public void testSetInput() {
        System.out.println("Method setInput : ");

        Equation instance = new Equation();
        instance.setInput("123");

        String expResult = "123";
        String result = instance.getInput();

        assertEquals("SetInput first attempt failed.", expResult, result);

        instance.setInput("187");

        expResult = "187";
        result = instance.getInput();

        assertEquals("SetInput second attempt failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of updateInput method, of class Equation.
     */
    @Test
    public void testUpdateInput() {
        System.out.println("Method updateInput : ");

        Equation instance = new Equation();
        instance.setInput("321");
        instance.updateInput("123");

        String expResult = "321123";
        String result = instance.getInput();

        assertEquals("UpdateInput first attempt failed.", expResult, result);

        instance.updateInput("555");

        expResult = "321123555";
        result = instance.getInput();

        assertEquals("UpdateInput second attempt failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of nestedLastItemIsScalar method, of class Equation.
     */
    @Test
    public void testNestedLastItemIsScalar() {
        System.out.println("Method nestedLastItemIsScalar : ");

        Equation instance = new Equation();

        boolean result = instance.nestedLastItemIsScalar();

        assertFalse("NestedLastItemIsScalar with no items failed.", result);

        instance.addItem(new Equation());

        result = instance.nestedLastItemIsScalar();

        assertFalse("NestedLastItemIsScalar with one equation failed.", result);

        instance.addItem(testScalar1);

        result = instance.nestedLastItemIsScalar();

        assertTrue(
                "NestedLastItemIsScalar with one scalar in an equation failed.",
                result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of isThereAnOpenEquation method, of class Equation.
     */
    @Test
    public void testIsThereAnOpenEquation() {
        System.out.println("Method isThereAnOpenEquation : ");

        Equation instance = new Equation();
        Equation equationItem1 = new Equation();
        Equation equationItem2 = new Equation();
        Equation equationItem3 = new Equation();

        boolean result = instance.isThereAnOpenEquation();

        assertFalse("IsThereAnOpenEquation with no equations failed.", result);

        instance.addItem(equationItem1);

        result = instance.isThereAnOpenEquation();

        assertTrue("IsThereAnOpenEquation with one open equation failed.",
                result);

        instance.addItem(equationItem2);

        result = instance.isThereAnOpenEquation();

        assertTrue(
                "IsThereAnOpenEquation with two nested open equations failed.",
                result);

        instance.addItem(equationItem3);

        result = instance.isThereAnOpenEquation();

        assertTrue(
                "IsThereAnOpenEquation with three nested open equations failed.",
                result);

        instance.addItem(testScalar1);
        instance.closeEquation();

        result = instance.isThereAnOpenEquation();

        assertTrue(
                "IsThereAnOpenEquation with three nested equations and "
                + "deepest equation is closed failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of getLastEquationItem method, of class Equation.
     */
    @Test
    public void testGetLastEquationItem() {
        System.out.println("Method getLastEquationItem : ");

        Equation instance = new Equation();

        Equation expResult = null;
        Equation result = instance.isThereAnOpenEquation() ? instance
                .getLastEquationItem() : null;

        assertEquals("GetLastEquationItem with no items failed.", expResult,
                result);

        instance.addItem(testInstance);

        expResult = testInstance;
        result = instance.isThereAnOpenEquation() ? instance
                .getLastEquationItem() : null;

        assertEquals("GetLastEquationItem with one equation failed.", expResult,
                result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of nestedEquationEmpty method, of class Equation.
     */
    @Test
    public void testAnyNestedEquationEmpty() {
        System.out.println("Method anyNestedEquationEmpty : ");

        Equation instance = new Equation();
        instance.addItem(new Equation());

        boolean result = instance.nestedEquationEmpty();

        assertTrue("AnyNestedEquationEmpty with empty equation failed.", result);

        instance.addItem(testScalar1);

        result = instance.nestedEquationEmpty();

        assertFalse("AnyNestedEquationEmpty with non-empty equation failed.",
                result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of lastIsScalar method, of class Equation.
     */
    @Test
    public void testLastIsScalar() {
        System.out.println("Method lastIsScalar : ");

        Equation instance = new Equation();

        boolean result = instance.lastIsScalar();

        assertFalse("LastIsScalar with no items failed.", result);

        instance.addItem(testScalar1);

        result = instance.lastIsScalar();

        assertTrue("LastIsScalar with one scalar failed.", result);

        instance.addItem(testAdd);

        result = instance.lastIsScalar();

        assertFalse("LastIsScalar with one scalar and one operator failed.",
                result);

        instance.addItem(testScalar2);

        result = instance.lastIsScalar();

        assertTrue("LastIsScalar with two scalars and one operator failed.",
                result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of itemListIsEmpty method, of class Equation.
     */
    @Test
    public void testItemListIsEmpty() {
        System.out.println("Method itemListIsEmpty : ");

        Equation instance = new Equation();

        boolean result = instance.itemListIsEmpty();

        assertTrue("ItemListIsEmpty with no items failed.", result);

        instance.addItem(testScalar1);

        result = instance.itemListIsEmpty();

        assertFalse("ItemListIsEmpty with one item failed.", result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of hasFirstOperand method, of class Equation.
     */
    @Test
    public void testHasFirstOperand() {
        System.out.println("Method hasFirstOperand : ");

        Equation instance = new Equation();

        boolean result = instance.hasFirstOperand();

        assertFalse("HasFirstOperand with no operands failed.", result);

        instance.addItem(new Equation());

        result = instance.hasFirstOperand();

        assertFalse("HasFirstOperand with no operands failed.", result);

        instance.addItem(testScalar1);

        result = instance.hasFirstOperand();

        assertFalse("HasFirstOperand with no operands failed.", result);

        instance.closeEquation();

        result = instance.hasFirstOperand();

        assertTrue("HasFirstOperand with no operands failed.", result);

        System.out.println("Complete.\n");
    }

}
