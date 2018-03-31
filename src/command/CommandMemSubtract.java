package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdMemSub")
public class CommandMemSubtract implements Command {

    @Override
    public void execute() {
        Facade.subtractMemory();
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoSubtractMem();
    }

}
