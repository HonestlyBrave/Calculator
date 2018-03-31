package utility;

import javax.swing.JButton;
import org.springframework.stereotype.Service;

/**
 * Utility class.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Service("decor")
public class Decor implements Utility {

    /**
     * Standard button with an accompanying ActionCommand string for listeners.
     *
     * @param string text to display on button
     * @return a JButton
     */
    public JButton aButton(String string) {
        // Apply string to button.
        JButton tmp = new JButton(string);

        // Set string to action command.
        tmp.setActionCommand(string);

        // Return new button.
        return tmp;
    }

}
