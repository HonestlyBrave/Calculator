package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdDivide")
public class CommandDivide implements Command {

    @Override
    public void execute() {
        if (Facade.operatorNotAllowed()) {
            return;
        }
        Facade.divide();
        Facade.getView().updateDisplay(" ÷ ");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoOperation();
    }

}
