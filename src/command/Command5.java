package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd5")
public class Command5 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("5");
        if (Facade.RemoveAnswerFromDisplay()) {
            Controller.setDisplay("");
        }
        Controller.updateDisplay("5");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
