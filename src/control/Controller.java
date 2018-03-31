package control;

import command.Command;
import java.util.ArrayDeque;
import java.util.Deque;
import model.Facade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.*;

/**
 * Calculator implementation. View aspect will be injected to this model. This
 * calculator respects bomdas/pemdas (or bodmas/pedmas).
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Controller {

    /**
     * Spring context.
     */
    private static final ApplicationContext CTX =
            new ClassPathXmlApplicationContext(
                    "classpath:/resources/beans.xml");

    /**
     * View Class object.
     */
    private static final View UI = CTX.getBean(UserInterface.class);

    /**
     * FIFO list of commands executed.
     */
    private static Deque<Command> comands = new ArrayDeque();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UI.setVisible();

        // After window loads, set focus to clear button.
        java.awt.EventQueue.invokeLater(() -> {
            UI.setFocus();
        });
    }

    /**
     * Update display as buttons are pressed.
     *
     * @param number literal input
     */
    public static void updateDisplay(String number) {
        if (Facade.answerNotEmpty()) {
            UI.setDisplay(Facade.getAnswer());
        }
        UI.updateDisplay(number);
    }

    /**
     * Retrieve current display text.
     *
     * @return text from user display
     */
    public static String getDisplay() {
        return UI.getDisplay();
    }

    /**
     * Replace current display text.
     *
     * @param newText string from machine
     */
    public static void setDisplay(String newText) {
        UI.setDisplay(newText);
    }

    /**
     * Remove last literal entry from current text.
     */
    public static void undoDisplay() {
        // Set empty if empty or get all characters -1(last entry).
        String undone = getDisplay().isEmpty() ? "" : getDisplay().substring(0,
                getDisplay().length() - 1);

        setDisplay(undone);
    }

    /**
     * Get the command collection.
     *
     * @return list of commands for design pattern
     */
    public static Deque<Command> getComands() {
        return comands;
    }

    /**
     * Set a collection of commands.
     *
     * @param aComands list of existing commands for design pattern
     */
    public static void setComands(Deque<Command> aComands) {
        comands = aComands;
    }

    /**
     * Pop a command from the queue.
     *
     * @return a command
     */
    public static Command popComand() {
        return comands.pop();
    }

    /**
     * Push a command to the queue.
     *
     * @param aComand one of existing commands for design pattern
     */
    public static void pushComand(Command aComand) {
        comands.push(aComand);
    }

}
