package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmd3")
public class Command3 implements Command {

    @Override
    public void execute() {
        Facade.updateInput("3");
        if (Facade.RemoveAnswerFromDisplay()) {
            Facade.getView().setDisplay("");
        }
        Facade.getView().updateDisplay("3");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Controller.undoDisplay();
    }

}
