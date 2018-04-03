package utility;

import java.util.List;
import model.*;
import model.operator.*;

/**
 * The heart of this calculator. Each set of parentheses are sent here twice for
 * simplification. Once for each method until only the primary calculation
 * remains. The primary calculation is then treated as a set of parentheses
 * itself and sent here for simplification to achieve the final solution.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Simplify implements Utility {

    /**
     * Find multiply/divide operators to calculate.
     *
     * @param itemList list of elements and operators to simplify
     * @return boolean
     */
    public static boolean calculateMultiplyDivide(List<Object> itemList) {
        for (Object obj : itemList) {
            if (obj.getClass().equals(Multiply.class)
                    || obj.getClass().equals(Divide.class)) {
                int index = itemList.indexOf(obj);

                calculate(index, itemList);

                return true;
            }
        }
        return false;
    }

    /**
     * Find add/subtract operators to calculate.
     *
     * @param itemList list of elements and operators to simplify
     * @return boolean
     */
    public static boolean calculateAddSubtract(List<Object> itemList) {
        for (Object obj : itemList) {
            if (obj.getClass().equals(Add.class)
                    || obj.getClass().equals(Subtract.class)) {
                int index = itemList.indexOf(obj);

                calculate(index, itemList);

                return true;
            }
        }
        return false;
    }

    /**
     * Create BaseExpression elements then update the List of objects.
     *
     * @param index
     * @param list
     */
    public static void calculate(int index, List<Object> list) {
        BaseExpression tmp = new BaseExpression((Element) list
                .get(index - 1), (Operator) list.get(index),
                (Element) list.get(index + 1));

        list.add(index - 1, tmp);
        list.remove(index);
        list.remove(index);
        list.remove(index);
    }
}
