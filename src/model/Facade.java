package model;

import control.Controller;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JOptionPane;
import model.operator.*;

/**
 * Facade design pattern to compliment Command design pattern.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Facade {

    /**
     * Main Equation for calculation using elements and operators. Elements are
     * base expressions, equations(parentheses), scalars and a singleton memory.
     */
    private static Equation PRIMARY = new Equation();

    /**
     * Machine equivalent of actual display.
     */
    private static String displayText = "";

    /**
     * Machine reference of output to replace/update display.
     */
    private static String output = "";

    /**
     * Machine reference of last answer.
     */
    private static String answer = "";

    /**
     * Stack(LIFO) of solved and cleared objects.
     */
    private static final Deque<Object> UNDOCOMANDS = new ArrayDeque<>();

    /**
     * Use commas as separator and eliminate extra zeros after decimal.
     */
    private static final DecimalFormat FINE = new DecimalFormat("");

    /**
     * Add a value to memory.
     */
    public static void addMemory() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        if (validateNewMemVal()) {
            PRIMARY.addMemory(parseCommas(getCleanString()));
            PRIMARY.setInput("");
        }
    }

    /**
     * Subtract a value from memory.
     */
    public static void subtractMemory() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        if (validateNewMemVal()) {
            PRIMARY.subtractMemory(parseCommas(getCleanString()));
            PRIMARY.setInput("");
        }
    }

    /**
     * Retrieve a value from memory, then update or replace display.
     */
    public static void recallMemory() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        if (PRIMARY.recallMemory().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "There is no memory value or it is zero.",
                    "No memory value", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // If there is new input.
        if (!PRIMARY.getInput().isEmpty()) {
            if (newInputAfterClosedEquation()) {
                addMultiplySignAfterLastEquation();
            }
            PRIMARY.addInput();
        }

        // Set memory value to input and output.
        setMachineInputOutput(PRIMARY.recallMemory());

        // Start of a new calculation.
        if (PRIMARY.itemListIsEmpty()) {
            Controller.setDisplay(output);
            return;
        }

        // Empty parentheses or operator.
        if (PRIMARY.anyEquationEmpty() || PRIMARY.nestedLastItemIsOperator()
                || PRIMARY.nestedLastItemIsClosedEquation()) {
            Controller.updateDisplay(output);
        } else {// Else there is a pre-existing scalar.
            Controller.updateDisplay(" ˣ " + output);
        }
    }

    /**
     * Clear memory of any value including zero.
     */
    public static void clearMemory() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        PRIMARY.clearMemory();
    }

    /**
     * Reinitialize calculator.
     */
    public static void clear() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        // Clear display and input.
        displayText = "";
        PRIMARY.setInput("");
        output = "";
        answer = "";

        // New primary calculation.
        PRIMARY = new Equation();
    }

    /**
     * Check for valid value then add operator to primary equation.
     */
    public static void add() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        if (answerNotEmpty()) {
            PRIMARY.setInput(removeCommas(answer));
        }

        if (verifyNewValueOrClosedEquationOrScalar()) {
            if (newInputAfterClosedEquation()) {
                addMultiplySignAfterLastEquation();
            }

            if (!PRIMARY.addInput() && !PRIMARY.nestedLastItemIsClosedEquation()) {
                JOptionPane.showMessageDialog(null,
                        "You must enter a valid operand "
                        + "before choosing an operator.",
                        "Missing operand", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        PRIMARY.addItem(new Add());
    }

    /**
     * Check for valid value then addItem operator to ArrayList.
     */
    public static void subtract() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        if (answerNotEmpty()) {
            PRIMARY.setInput(removeCommas(answer));
        }

        if (verifyNewValueOrClosedEquationOrScalar()) {
            if (newInputAfterClosedEquation()) {
                addMultiplySignAfterLastEquation();
            }

            if (!PRIMARY.addInput() && !PRIMARY.nestedLastItemIsClosedEquation()) {
                JOptionPane.showMessageDialog(null,
                        "You must enter a valid operand "
                        + "before choosing an operator.",
                        "Missing operand", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        PRIMARY.addItem(new Subtract());
    }

    /**
     * Check for valid value then addItem operator to ArrayList.
     */
    public static void multiply() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        if (answerNotEmpty()) {
            PRIMARY.setInput(removeCommas(answer));
        }

        if (verifyNewValueOrClosedEquationOrScalar()) {
            if (newInputAfterClosedEquation()) {
                addMultiplySignAfterLastEquation();
            }

            if (!PRIMARY.addInput() && !PRIMARY.nestedLastItemIsClosedEquation()) {
                JOptionPane.showMessageDialog(null,
                        "You must enter a valid operand "
                        + "before choosing an operator.",
                        "Missing operand", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        PRIMARY.addItem(new Multiply());
    }

    /**
     * Check for valid value then addItem operator to ArrayList.
     */
    public static void divide() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        if (answerNotEmpty()) {
            PRIMARY.setInput(removeCommas(answer));
        }

        if (verifyNewValueOrClosedEquationOrScalar()) {
            if (newInputAfterClosedEquation()) {
                addMultiplySignAfterLastEquation();
            }

            if (!PRIMARY.addInput() && !PRIMARY.nestedLastItemIsClosedEquation()) {
                JOptionPane.showMessageDialog(null,
                        "You must enter a valid operand "
                        + "before choosing an operator.",
                        "Missing operand", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        PRIMARY.addItem(new Divide());
    }

    /**
     * Check for valid Scalar then add new Equation to primary Equation.
     */
    public static void openParentheses() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        if (answerNotEmpty()) {
            PRIMARY.setInput(removeCommas(answer));
        }

        if (validateNewVal() || PRIMARY.nestedLastItemIsClosedEquation()) {
            if (newInputAfterClosedEquation()) {
                addMultiplySignAfterLastEquation();
            }

            addMultiplySignBeforeInput();
            PRIMARY.addInput();
        }

        PRIMARY.addItem(new Equation());
    }

    /**
     * Check for valid Scalar then close equation.
     */
    public static void closeParentheses() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        if (validateNewVal()) {
            if (newInputAfterClosedEquation()) {
                addMultiplySignAfterLastEquation();
            }

            PRIMARY.addInput();
        }

        PRIMARY.closeEquation();
    }

    /**
     * Check for valid value then solve equation.
     */
    public static void solve() {
        // Save state for undo
        UNDOCOMANDS.push(PRIMARY);

        synchMachineDisplay();

        if (!answer.isEmpty() && PRIMARY.itemListIsEmpty()
                && PRIMARY.getInput().isEmpty()) {
            PRIMARY.setInput(removeCommas(answer));
        }

        // Verify input exist.
        if (validateNewVal()) {
            PRIMARY.addInput();
        }

        // Verify if any Equation(parentheses) is not valid.
        if (PRIMARY.checkAll4Unsolvable()) {
            JOptionPane.showMessageDialog(null,
                    "The equation can not be solved due to an unclosed "
                    + "parentheses or missing operand/operator.",
                    "Missing element or operator", JOptionPane.ERROR_MESSAGE);

            PRIMARY = (Equation) UNDOCOMANDS.pop();
            return;
        }
        // Evaluate the last element.
        answer = FINE.format(PRIMARY.evaluate());

        // Update display with complete expression and result.
        Controller.setDisplay(PRIMARY.toString() + " = " + answer);

        // Clear main equation.
        PRIMARY = new Equation();
        PRIMARY.setInput("");
    }

    /**
     * Remove the last operator and it's accompanying operand.
     */
    public static void undoOperation() {
        PRIMARY = (Equation) UNDOCOMANDS.pop();
        Controller.setDisplay(displayText);
    }

    /**
     * Undo a solve operation.
     */
    public static void undoSolve() {
        PRIMARY = (Equation) UNDOCOMANDS.pop();
        Controller.setDisplay(displayText);
    }

    /**
     * Undo a clear operation.
     */
    public static void undoClear() {
        PRIMARY = (Equation) UNDOCOMANDS.pop();
        Controller.setDisplay(displayText);
    }

    /**
     * Undo a memory operation.
     */
    public static void undoAddMem() {
        PRIMARY = (Equation) UNDOCOMANDS.pop();
        Controller.setDisplay(displayText);
    }

    /**
     * Undo a memory operation.
     */
    public static void undoSubtractMem() {
        PRIMARY = (Equation) UNDOCOMANDS.pop();
        Controller.setDisplay(displayText);
    }

    /**
     * Undo a memory operation.
     */
    public static void undoRecallMem() {
        PRIMARY = (Equation) UNDOCOMANDS.pop();
        Controller.setDisplay(displayText);
    }

    /**
     * Undo a memory operation.
     */
    public static void undoClearMem() {
        PRIMARY = (Equation) UNDOCOMANDS.pop();
    }

    /**
     * Literal user input between operations.
     *
     * @param latestInput literal user input
     */
    public static void updateInput(String latestInput) {
        PRIMARY.updateInput(latestInput);
    }

    /**
     *
     * @return answer
     */
    public static String getAnswer() {
        return answer;
    }

    /**
     * Start a new calculation with current answer.
     *
     * @return boolean
     */
    public static boolean answerNotEmpty() {
        return (!answer.isEmpty() && PRIMARY.itemListIsEmpty()
                && PRIMARY.getInput().isEmpty());
    }

    /**
     * Is Equation list empty, while answer is not and input has no more than
     * one character.
     *
     * @return boolean
     */
    public static boolean RemoveAnswerFromDisplay() {
        return (!answer.isEmpty() && PRIMARY.itemListIsEmpty()
                && PRIMARY.getInput().length() == 1);
    }

    /**
     * Check current equation for illegal state before adding new operator.
     *
     * @return boolean
     */
    public static boolean operatorNotAllowed() {
        return ((PRIMARY.itemListIsEmpty() && bothInputAnswerEmpty())
                || (PRIMARY.nestedEquationEmpty()
                && PRIMARY.getInput().isEmpty())
                || (PRIMARY.nestedLastItemIsOperator()
                && PRIMARY.getInput().isEmpty()));
    }

    /**
     * Check all Equations illegal state before closing.
     *
     * @return boolean
     */
    public static boolean cannotCloseParaNow() {
        return (PRIMARY.itemListIsEmpty()
                || !PRIMARY.isThereAnOpenEquation()
                || (PRIMARY.nestedLastItemIsOperator() && PRIMARY.getInput()
                .isEmpty())
                || (PRIMARY.getInput().isEmpty()
                && PRIMARY.nestedEquationEmpty()));
    }

    /**
     * Validate user/machine input.
     *
     * @return boolean
     */
    private static boolean validateNewVal() {
        return (!PRIMARY.getInput().isEmpty()
                && !PRIMARY.getInput().equalsIgnoreCase("."));
    }

    /**
     * Validate user/machine memory input.
     *
     * @return boolean
     */
    private static boolean validateNewMemVal() {
        if (!getCleanString().isEmpty()
                && !getCleanString().equalsIgnoreCase(".")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "There is no value to use.",
                    "Missing value", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Trim display data as needed to return value only.
     *
     * @return value substring of user display
     */
    private static String getCleanString() {
        synchMachineDisplay();

        String cleanString;

        // Find index of space before value.
        int index = displayText.lastIndexOf(" ");
        // Take everything after index.
        cleanString = displayText.substring(index + 1);

        return cleanString;
    }

    /**
     * Validate a new value or whether the previous item was an Equation or
     * Scalar. The exception for no Scalar value before an operator.
     *
     * @return boolean
     */
    private static boolean verifyNewValueOrClosedEquationOrScalar() {
        return (validateNewVal() || PRIMARY.nestedLastItemIsClosedEquation()
                || PRIMARY.nestedLastItemIsScalar());
    }

    /**
     * True if there is new input and the last item is a closed Equation.
     *
     * @return boolean
     */
    private static boolean newInputAfterClosedEquation() {
        return (validateNewVal() && PRIMARY.nestedLastItemIsClosedEquation());
    }

    /**
     * True if both attributes are empty.
     *
     * @return boolean
     */
    private static boolean bothInputAnswerEmpty() {
        return (PRIMARY.getInput().isEmpty() && answer.isEmpty());
    }

    /**
     * Synchronize machine display with user display.
     */
    private static void synchMachineDisplay() {
        displayText = Controller.getDisplay();
    }

    /**
     * Set machine view and user/machine input.
     *
     * @param text for machine display and input
     */
    private static void setMachineInputOutput(String text) {
        output = text;
        PRIMARY.setInput(removeCommas(text));
    }

    /**
     * Add literal "ˣ" to user display before parentheses.
     */
    private static void addMultiplySignBeforeInput() {
        synchMachineDisplay();
        int tmp = displayText.lastIndexOf("(");
        displayText = displayText.substring(0, tmp);
        displayText = displayText.concat(" ˣ ( ");
        Controller.setDisplay(displayText);
    }

    /**
     * Add literal "ˣ" to user display after parentheses.
     */
    private static void addMultiplySignAfterLastEquation() {
        synchMachineDisplay();
        int tmp = displayText.lastIndexOf(")");
        String newinput = displayText.substring(tmp + 1);
        displayText = displayText.substring(0, tmp);
        displayText = displayText.concat(") ˣ " + newinput);
        Controller.setDisplay(displayText);
    }

    /**
     *
     * @param number formatted to allow commas
     * @return number without commas
     */
    private static String removeCommas(String number) {
        return number.replaceAll(",", "");
    }

    /**
     * Two methods that allow Double class to parse formatted strings.
     *
     * @param number formatted to allow commas
     * @return double
     */
    private static double parseCommas(String number) {
        return Double.parseDouble(removeCommas(number));
    }
}
