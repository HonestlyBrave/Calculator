package utility;

import command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All commands injected and assembled in a set order in one place.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Service("cmdR")
public class CommandsResource implements Utility {

    /**
     * Injections by variable name.
     */
    @Autowired
    private Command cmd0, cmd1, cmd2, cmd3, cmd4, cmd5, cmd6, cmd7, cmd8, cmd9;

    /**
     * Injections by variable name.
     */
    @Autowired
    private Command cmdAdd, cmdClear, cmdDecimal, cmdDivide, cmdMemAdd;

    /**
     * Injections by variable name.
     */
    @Autowired
    private Command cmdMemSub, cmdMemRecall, cmdSubtract, cmdMultiply, cmdSolve;

    /**
     * Injections by variable name.
     */
    @Autowired
    private Command cmdMemClear, cmdUndo, cmdOpenP, cmdCloseP;

    /**
     * Order of commands is crucial for array index references.
     *
     * @return array of Commands in set order
     */
    public Command[] getCommands() {

        Command[] commands = {cmd0, cmd1, cmd2, cmd3, cmd4, cmd5, cmd6, cmd7,
            cmd8, cmd9, cmdAdd, cmdClear, cmdDecimal, cmdDivide, cmdMemAdd,
            cmdMemSub, cmdMemRecall, cmdSubtract, cmdMultiply, cmdSolve,
            cmdMemClear, cmdUndo, cmdOpenP, cmdCloseP};

        return commands;
    }

}
