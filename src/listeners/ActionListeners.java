package listeners;

import command.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.CommandsResource;

/**
 * Listener for all buttons to execute their respective commands.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Service("actionListeners")
public class ActionListeners implements ActionListener {

    /**
     * Retrieve the Spring context.
     */
    @Autowired
    private final CommandsResource cmdR;

    /**
     * Command objects.
     */
    private final Command[] commands;

    /**
     * Inject command resource and get Array of commands.
     *
     * @param cmdR
     */
    @Autowired
    public ActionListeners(CommandsResource cmdR) {
        this.cmdR = cmdR;
        this.commands = cmdR.getCommands();
    }

    /**
     * Utilize the action command string to retrieve and execute the
     * corresponding command.
     *
     * @param e event arguments
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().equals(JButton.class)) {
            String x = e.getActionCommand();
            int index = Integer.parseInt(x);
            commands[index].execute();
        }
    }
}
