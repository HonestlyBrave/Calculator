package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdDecimal")
public class CommandDecimal implements Command {

    @Override
    public void execute() {
        Facade.updateInput(".");
        if (Facade.RemoveAnswerFromDisplay()) {
            Facade.getView().setDisplay("");
        }
        Facade.getView().updateDisplay(".");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
