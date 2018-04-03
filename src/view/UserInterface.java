package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import listeners.ActionListeners;
import listeners.KeyListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.Decor;

/**
 * View created without Model(data manipulation).
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
@Service("userInterface")
public class UserInterface extends JFrame implements View {

    /**
     * Inject an action listener class.
     */
    @Autowired
    private final ActionListeners actionListeners;

    /**
     * Inject a key listener class.
     */
    @Autowired
    private final KeyListeners keyListeners;

    /**
     * Inject a utility class to create buttons.
     */
    @Autowired
    private final Decor decor;

    /**
     * Calculator panels.
     */
    private JPanel jpMain, jpFirst, jpSecond;

    /**
     * Calculator buttons.
     */
    private JButton jb0, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jbDecimal;

    /**
     * Calculator buttons.
     */
    private JButton jbSolve, jbAdd, jbSubtract, jbMultiply, jbDivide;

    /**
     * Calculator buttons.
     */
    private JButton jbClear, jbMemAdd, jbMemMinus, jbMemRecall, jbMemClear;

    /**
     * Calculator buttons.
     */
    private JButton jbOpenPara, jbClosePara, jbUndo;

    /**
     * Calculator display.
     */
    private JTextField jtDisplayBox;

    /**
     * Constructor.
     *
     * @param actionListeners
     * @param keyListeners
     * @param decor
     */
    @Autowired
    public UserInterface(ActionListeners actionListeners,
            KeyListeners keyListeners, Decor decor) {
        this.actionListeners = actionListeners;
        this.keyListeners = keyListeners;
        this.decor = decor;
        setWidgets();
        setListeneres();
    }

    /**
     * Components.
     */
    private void setWidgets() {
        jpMain = new JPanel(new GridLayout(2, 1, 10, 10));

        add(jpMain);

        jpFirst = new JPanel(new BorderLayout());
        jpSecond = new JPanel(new GridLayout(6, 4, 5, 5));

        jpMain.add(jpFirst);
        jpMain.add(jpSecond);

        jtDisplayBox = new JTextField("");
        jtDisplayBox.setEditable(false);
        jtDisplayBox.setHorizontalAlignment(JTextField.RIGHT);
        jtDisplayBox.setFont(new Font("Arial", Font.TRUETYPE_FONT, 32));

        jpFirst.add(jtDisplayBox, BorderLayout.CENTER);

        jb0 = decor.aButton("0");
        jb1 = decor.aButton("1");
        jb2 = decor.aButton("2");
        jb3 = decor.aButton("3");
        jb4 = decor.aButton("4");
        jb5 = decor.aButton("5");
        jb6 = decor.aButton("6");
        jb7 = decor.aButton("7");
        jb8 = decor.aButton("8");
        jb9 = decor.aButton("9");
        jbAdd = decor.aButton("+");
        jbAdd.setActionCommand("10"); // Override default ActionCommand string.
        jbClear = decor.aButton("Clear");
        jbClear.setActionCommand("11");
        jbDecimal = decor.aButton(".");
        jbDecimal.setActionCommand("12");
        jbDivide = decor.aButton("÷");
        jbDivide.setActionCommand("13");
        jbMemAdd = decor.aButton("M+");
        jbMemAdd.setActionCommand("14");
        jbMemMinus = decor.aButton("M-");
        jbMemMinus.setActionCommand("15");
        jbMemRecall = decor.aButton("MR");
        jbMemRecall.setActionCommand("16");
        jbSubtract = decor.aButton("-");
        jbSubtract.setActionCommand("17");
        jbMultiply = decor.aButton("ˣ");
        jbMultiply.setActionCommand("18");
        jbSolve = decor.aButton("=");
        jbSolve.setActionCommand("19");
        jbMemClear = decor.aButton("MC");
        jbMemClear.setActionCommand("20");
        jbUndo = decor.aButton("Undo");
        jbUndo.setActionCommand("21");
        jbOpenPara = decor.aButton("(");
        jbOpenPara.setActionCommand("22");
        jbClosePara = decor.aButton(")");
        jbClosePara.setActionCommand("23");

        jpSecond.add(jb1);
        jpSecond.add(jb2);
        jpSecond.add(jb3);
        jpSecond.add(jbAdd);
        jpSecond.add(jb4);
        jpSecond.add(jb5);
        jpSecond.add(jb6);
        jpSecond.add(jbSubtract);
        jpSecond.add(jb7);
        jpSecond.add(jb8);
        jpSecond.add(jb9);
        jpSecond.add(jbMultiply);
        jpSecond.add(jb0);
        jpSecond.add(jbDecimal);
        jpSecond.add(jbSolve);
        jpSecond.add(jbDivide);
        jpSecond.add(jbClear);
        jpSecond.add(jbUndo);
        jpSecond.add(jbOpenPara);
        jpSecond.add(jbClosePara);
        jpSecond.add(jbMemAdd);
        jpSecond.add(jbMemMinus);
        jpSecond.add(jbMemRecall);
        jpSecond.add(jbMemClear);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        setTitle("Supreme Calculator");
        setLocationRelativeTo(null);
    }

    /**
     * Listeners.
     */
    private void setListeneres() {
        // Add listeners to components in a specific panel.
        for (Component comp : jpSecond.getComponents()) {
            if (comp.getClass().equals(JButton.class)) {
                ((JButton) comp).addActionListener(actionListeners);
                ((JButton) comp).addKeyListener(keyListeners);
            }
        }

    }

    @Override
    public void setVisible() {
        setVisible(true);
    }

    @Override
    public void setFocus() {
        jbClear.requestFocus();
    }

    @Override
    public String getDisplay() {
        return jtDisplayBox.getText();
    }

    @Override
    public void setDisplay(String text) {
        jtDisplayBox.setText(text);
    }

    @Override
    public void updateDisplay(String text) {
        jtDisplayBox.setText(getDisplay() + text);
    }

    @Override
    public void undoDisplay() {
        String text = getDisplay();
        int textLen = text.length();

        // Set empty if empty or get all characters -1(last entry).
        String newText = text.isEmpty() ? "" : text.substring(0, textLen - 1);

        setDisplay(newText);
    }

}
