package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdCloseP")
public class CommandClosePara implements Command {

    @Override
    public void execute() {
        if (Facade.cannotCloseParaNow()) {
            return;
        }
        Facade.closeParentheses();
        Facade.getView().updateDisplay(" )");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoOperation();
    }

}
