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
     * Find multiply/divide operators to create BaseExpression elements then
     * update the List of objects.
     *
     * @param elementsList list of elements and operators to simplify
     * @return boolean
     */
    public static boolean calculateMultiplyDivide(List<Object> elementsList) {
        for (Object obj : elementsList) {
            if (obj.getClass().equals(Multiply.class)
                    || obj.getClass().equals(Divide.class)) {
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
     * Find add/subtract operators to create BaseExpression elements then update
     * the List of objects.
     *
     * @param elementsList list of elements and operators to simplify
     * @return boolean
     */
    public static boolean calculateAddSubtract(List<Object> elementsList) {
        for (Object obj : elementsList) {
            if (obj.getClass().equals(Add.class)
                    || obj.getClass().equals(Subtract.class)) {
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
