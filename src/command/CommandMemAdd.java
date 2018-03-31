package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdMemAdd")
public class CommandMemAdd implements Command {

    @Override
    public void execute() {
        Facade.addMemory();
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoAddMem();
    }

}
