package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd2")
public class Command2 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("2");
        if (Facade.RemoveAnswerFromDisplay()) {
            Controller.setDisplay("");
        }
        Controller.updateDisplay("2");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
