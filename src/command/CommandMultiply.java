package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdMultiply")
public class CommandMultiply implements Command {

    @Override
    public void execute() {
        if (Facade.operatorNotAllowed()) {
            return;
        }
        Facade.multiply();
        Facade.getView().updateDisplay(" ˣ ");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoOperation();
    }

}
