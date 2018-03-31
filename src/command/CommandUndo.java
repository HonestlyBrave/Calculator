package command;

import control.Controller;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdUndo")
public class CommandUndo implements Command {

    @Override
    public void execute() {
        if (!Controller.getComands().isEmpty()) {
            Controller.popComand().undo();
        } else {
            JOptionPane.showMessageDialog(null, "Nothing to undo.",
                    "Invalid Operation", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void undo() {

    }

}
