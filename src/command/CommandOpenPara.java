package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdOpenP")
public class CommandOpenPara implements Command {

    @Override
    public void execute() {
        Controller.updateDisplay("( ");
        Facade.openParentheses();
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoOperation();
    }

}
