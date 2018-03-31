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
public class FacadeTest {

    public FacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Facade class : ");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Facade class testing complete.\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMemory method, of class Facade.
     */
    @Test
    public void testAddMemory() {
        System.out.println("Method addMemory : ");

        Facade.addMemory();

        System.out.println("Complete.\n");
    }

    /**
     * Test of subtractMemory method, of class Facade.
     */
    @Test
    public void testSubtractMemory() {
        System.out.println("Method subtractMemory : ");

        Facade.subtractMemory();

        System.out.println("Complete.\n");
    }

    /**
     * Test of recallMemory method, of class Facade.
     */
    @Test
    public void testRecallMemory() {
        System.out.println("Method recallMemory : ");

        Facade.recallMemory();

        System.out.println("Complete.\n");
    }

    /**
     * Test of clearMemory method, of class Facade.
     */
    @Test
    public void testClearMemory() {
        System.out.println("Method clearMemory : ");

        Facade.clearMemory();

        System.out.println("Complete.\n");
    }

    /**
     * Test of clear method, of class Facade.
     */
    @Test
    public void testClear() {
        System.out.println("Method clear : ");

        Facade.clear();

        System.out.println("Complete.\n");
    }

    /**
     * Test of add method, of class Facade.
     */
    @Test
    public void testAdd() {
        System.out.println("Method add : ");

        Facade.add();

        System.out.println("Complete.\n");
    }

    /**
     * Test of subtract method, of class Facade.
     */
    @Test
    public void testSubtract() {
        System.out.println("Method subtract : ");

        Facade.subtract();

        System.out.println("Complete.\n");
    }

    /**
     * Test of multiply method, of class Facade.
     */
    @Test
    public void testMultiply() {
        System.out.println("Method multiply : ");

        Facade.multiply();

        System.out.println("Complete.\n");
    }

    /**
     * Test of divide method, of class Facade.
     */
    @Test
    public void testDivide() {
        System.out.println("Method divide : ");

        Facade.divide();

        System.out.println("Complete.\n");
    }

    /**
     * Test of openParentheses method, of class Facade.
     */
    @Test
    public void testOpenParentheses() {
        System.out.println("Method openParentheses : ");

        Facade.openParentheses();

        System.out.println("Complete.\n");
    }

    /**
     * Test of closeParentheses method, of class Facade.
     */
    @Test
    public void testCloseParentheses() {
        System.out.println("Method closeParentheses : ");

        Facade.closeParentheses();

        System.out.println("Complete.\n");
    }

    /**
     * Test of solve method, of class Facade.
     */
    @Test
    public void testSolve() {
        System.out.println("Method solve : ");

        Facade.solve();

        System.out.println("Complete.\n");
    }

//    /**
//     * Test of undoOperation method, of class Facade.
//     */
//    @Test
//    public void testUndoOperation() {
//        System.out.println("Method undoOperation : ");
//
//        Facade.undoOperation();
//
//        System.out.println("Complete.\n");
//    }
//
//    /**
//     * Test of undoSolve method, of class Facade.
//     */
//    @Test
//    public void testUndoSolve() {
//        System.out.println("Method undoSolve : ");
//
//        Facade.undoSolve();
//
//        System.out.println("Complete.\n");
//    }
//
//    /**
//     * Test of undoClear method, of class Facade.
//     */
//    @Test
//    public void testUndoClear() {
//        System.out.println("Method undoClear : ");
//
//        Facade.undoClear();
//
//        System.out.println("Complete.\n");
//    }
//
//    /**
//     * Test of undoAddMem method, of class Facade.
//     */
//    @Test
//    public void testUndoAddMem() {
//        System.out.println("Method undoAddMem : ");
//
//        Facade.undoAddMem();
//
//        System.out.println("Complete.\n");
//    }
//
//    /**
//     * Test of undoSubtractMem method, of class Facade.
//     */
//    @Test
//    public void testUndoSubtractMem() {
//        System.out.println("Method undoSubtractMem : ");
//
//        Facade.undoSubtractMem();
//
//        System.out.println("Complete.\n");
//    }
//
//    /**
//     * Test of undoRecallMem method, of class Facade.
//     */
//    @Test
//    public void testUndoRecallMem() {
//        System.out.println("Method undoRecallMem : ");
//
//        Facade.undoRecallMem();
//
//        System.out.println("Complete.\n");
//    }
//
//    /**
//     * Test of undoClearMem method, of class Facade.
//     */
//    @Test
//    public void testUndoClearMem() {
//        System.out.println("Method undoClearMem : ");
//
//        Facade.undoClearMem();
//
//        System.out.println("Complete.\n");
//    }
    /**
     * Test of updateInput method, of class Facade.
     */
    @Test
    public void testUpdateInput() {
        System.out.println("Method updateInput : ");

        String latestInput = "";
        Facade.updateInput(latestInput);

        System.out.println("Complete.\n");
    }

    /**
     * Test of getAnswer method, of class Facade.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("Method getAnswer : ");

        String expResult = "";
        String result = Facade.getAnswer();

        assertEquals("GetAnswer failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of answerNotEmpty method, of class Facade.
     */
    @Test
    public void testGetLatestAnswer() {
        System.out.println("Method getLatestAnswer : ");

        boolean expResult = false;
        boolean result = Facade.answerNotEmpty();

        assertEquals("GetLatestAnswer failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of RemoveAnswerFromDisplay method, of class Facade.
     */
    @Test
    public void testRemoveAnswerFromDisplay() {
        System.out.println("Method RemoveAnswerFromDisplay : ");

        boolean expResult = false;
        boolean result = Facade.RemoveAnswerFromDisplay();

        assertEquals("RemoveAnswerFromDisplay failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of operatorNotAllowed method, of class Facade.
     */
    @Test
    public void testOperatorNotAllowed() {
        System.out.println("Method operatorNotAllowed : ");

        boolean expResult = true;
        boolean result = Facade.operatorNotAllowed();

        assertEquals("OperatorNotAllowed failed.", expResult, result);

        System.out.println("Complete.\n");
    }

    /**
     * Test of cannotCloseParaNow method, of class Facade.
     */
    @Test
    public void testCannotCloseParaNow() {
        System.out.println("Method closeParaNotAllowed : ");

        boolean expResult = true;
        boolean result = Facade.cannotCloseParaNow();

        assertEquals("CloseParaNotAllowed failed.", expResult, result);

        System.out.println("Complete.\n");
    }

}
