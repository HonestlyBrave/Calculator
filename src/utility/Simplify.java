package utility;

import java.util.List;
import model.*;
import model.operator.*;

/**
 * Utility class.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Simplify implements Utility {

    /**
     * Combine multiply/divide binomial expressions into a BaseExpression then
     * update the ArrayList.
     *
     * @param elementsList list of elements to simplify
     * @return boolean
     */
    public static boolean calculateMultiplyDivide(List<Object> elementsList) {
        for (Object obj : elementsList) {
            if (obj instanceof Multiply || obj instanceof Divide) {
                int index = elementsList.indexOf(obj);
                BaseExpression tmp = new BaseExpression((Element) elementsList
                        .get(index - 1), (Operator) elementsList.get(index),
                        (Element) elementsList.get(index + 1));
                elementsList.add(index - 1, tmp);
                elementsList.remove(index);
                elementsList.remove(index);
                elementsList.remove(index);
                return true;
            }
        }
        return false;
    }

    /**
     * Combine add/subtract binomial expressions into a BaseExpression then
     * update the ArrayList.
     *
     * @param elementsList list of elements to simplify
     * @return boolean
     */
    public static boolean calculateAddSubtract(List<Object> elementsList) {
        for (Object obj : elementsList) {
            if (obj instanceof Add || obj instanceof Subtract) {
                int index = elementsList.indexOf(obj);
                BaseExpression tmp = new BaseExpression((Element) elementsList
                        .get(index - 1), (Operator) elementsList.get(index),
                        (Element) elementsList.get(index + 1));
                elementsList.add(index - 1, tmp);
                elementsList.remove(index);
                elementsList.remove(index);
                elementsList.remove(index);
                return true;
            }
        }
        return false;
    }
}
