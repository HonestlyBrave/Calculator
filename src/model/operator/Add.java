package model.operator;

import model.Element;

/**
 * Leaf class of the math composite for addition operators.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class Add implements Operator {

    /**
     * Add.
     */
    public static final String OPERATOR = "+";

    /**
     * Default constructor.
     */
    public Add() {
    }

    @Override
    public double calculate(Element x1, Element x2) {
        return x1.evaluate() + x2.evaluate();
    }

    /**
     *
     * @return operator as string
     */
    @Override
    public String toString() {
        return OPERATOR;
    }
}
