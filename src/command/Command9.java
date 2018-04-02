package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd9")
public class Command9 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("9");
        if (Facade.RemoveAnswerFromDisplay()) {
            Facade.getView().setDisplay("");
        }
        Facade.getView().updateDisplay("9");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
