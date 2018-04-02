package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdAdd")
public class CommandAdd implements Command {

    @Override
    public void execute() {
        if (Facade.operatorNotAllowed()) {
            return;
        }
        Facade.add();
        Facade.getView().updateDisplay(" + ");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoOperation();
    }

}
