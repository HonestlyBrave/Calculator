package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd0")
public class Command0 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("0");
        if (Facade.RemoveAnswerFromDisplay()) {
            Facade.getView().setDisplay("");
        }
        Facade.getView().updateDisplay("0");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
