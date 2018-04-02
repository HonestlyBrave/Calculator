package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd8")
public class Command8 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("8");
        if (Facade.RemoveAnswerFromDisplay()) {
            Facade.getView().setDisplay("");
        }
        Facade.getView().updateDisplay("8");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
