package command;

import control.Controller;
import model.Facade;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Component("cmdClear")
public class CommandClear implements Command {

    @Override
    public void execute() {
        Facade.clear();
        Facade.getView().setDisplay("");
        Controller.pushComand(this);
    }

    @Override
    public void undo() {
        Facade.undoClear();
    }

}
