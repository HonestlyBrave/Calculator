package control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.*;

/**
 * Calculator implementation. View aspect will be injected to this model. This
 * calculator respects bomdas/pemdas (or bodmas/pedmas).
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Controller {

    /**
     * Spring context.
     */
    private static final ApplicationContext CTX =
            new ClassPathXmlApplicationContext(
                    "classpath:/resources/beans.xml");

    /**
     * View Class object.
     */
    private static final View UI = CTX.getBean(UserInterface.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UI.setVisible();

        // After window loads, set focus to clear button.
        java.awt.EventQueue.invokeLater(() -> {
            UI.setFocus();
        });
    }

}
