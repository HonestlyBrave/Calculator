package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdSubtract")
public class CommandSubtract implements Command {

    @Override
    public void execute() {
        if (Facade.operatorNotAllowed()) {
            return;
        }
        Facade.subtract();
        Facade.getView().updateDisplay(" - ");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoOperation();
    }

}
