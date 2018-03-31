package model.decorator;

import model.BaseExpression;
import model.Element;
import model.History;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class SaveToHistory extends History implements ExpressionDecorator {

    /**
     * Expression to manipulate.
     */
    BaseExpression expression;

    /**
     * Default constructor.
     *
     * @param expression Base Expression
     */
    public SaveToHistory(BaseExpression expression) {
        super();
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        double val = expression.evaluate();
        addResult(val);
        return val;
    }

    @Override
    public void addFirst(Element element) {
        expression.addFirst(element);
    }

    @Override
    public void addSecond(Element element) {
        expression.addSecond(element);
    }

    /**
     *
     * @return History list and this Base Expression
     */
    @Override
    public String toString() {
        return super.toString() + expression.toString();
    }

}
