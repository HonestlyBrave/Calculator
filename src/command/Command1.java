package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd1")
public class Command1 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("1");
        if (Facade.RemoveAnswerFromDisplay()) {
            Controller.setDisplay("");
        }
        Controller.updateDisplay("1");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
