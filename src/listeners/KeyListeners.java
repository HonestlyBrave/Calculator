package listeners;

import command.Command;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.CommandsResource;

/**
 * Listener for all keyboard keys that appear in the user interface. Note :
 * Enter represents = and Escape will reset the calculator. Only the keyPressed
 * method was used to accomplish this task.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Service("keyListeners")
public class KeyListeners implements KeyListener {

    /**
     * Utility class.
     */
    @Autowired
    private final CommandsResource cmdR;

    /**
     * Array of Command objects.
     */
    private final Command[] commands;

    /**
     * Inject command resource and get Array of commands.
     *
     * @param cmdR
     */
    @Autowired
    public KeyListeners(CommandsResource cmdR) {
        this.cmdR = cmdR;
        this.commands = cmdR.getCommands();
    }

    /**
     * Unused implemented method.
     *
     * @param ke KeyEvent arguments
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    /**
     * Switch key code to execute the corresponding command.
     *
     * @param ke KeyEvent arguments
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        int index;
        switch (ke.getKeyCode()) {
            case VK_0:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD0:
                index = 0;
                commands[index].execute();
                break;
            case VK_1:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD1:
                index = 1;
                commands[index].execute();
                break;
            case VK_2:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD2:
                index = 2;
                commands[index].execute();
                break;
            case VK_3:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD3:
                index = 3;
                commands[index].execute();
                break;
            case VK_4:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD4:
                index = 4;
                commands[index].execute();
                break;
            case VK_5:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD5:
                index = 5;
                commands[index].execute();
                break;
            case VK_6:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD6:
                index = 6;
                commands[index].execute();
                break;
            case VK_7:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD7:
                index = 7;
                commands[index].execute();
                break;
            case VK_8:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD8:
                index = 8;
                commands[index].execute();
                break;
            case VK_9:
                index = Integer.parseInt(getKeyText(ke.getKeyCode()));
                commands[index].execute();
                break;
            case VK_NUMPAD9:
                index = 9;
                commands[index].execute();
                break;
            case VK_ADD:
                index = 10;
                commands[index].execute();
                break;
            case VK_ESCAPE:
                index = 11;
                commands[index].execute();
                break;
            case VK_DECIMAL:
                index = 12;
                commands[index].execute();
                break;
            case VK_DIVIDE:
                index = 13;
                commands[index].execute();
                break;
            case VK_SUBTRACT:
                index = 17;
                commands[index].execute();
                break;
            case VK_MULTIPLY:
                index = 18;
                commands[index].execute();
                break;
            case VK_ENTER:
                index = 19;
                commands[index].execute();
                break;
            default:
                break;
        }
    }

    /**
     * Unused implemented method.
     *
     * @param ke KeyEvent arguments
     */
    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
