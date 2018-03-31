package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd6")
public class Command6 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("6");
        if (Facade.RemoveAnswerFromDisplay()) {
            Controller.setDisplay("");
        }
        Controller.updateDisplay("6");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
