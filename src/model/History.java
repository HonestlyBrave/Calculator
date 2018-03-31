package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class History {

    /**
     * Singleton instance.
     */
    private static final History INSTANCE = null;

    /**
     * Results list.
     */
    List<Double> results = new ArrayList();

    /**
     *
     * @return instance of History
     */
    public History getInstance() {
        if (INSTANCE == null) {
            return new History();
        }
        return INSTANCE;
    }

    /**
     * Add to list.
     *
     * @param value evaluated result
     */
    public void addResult(double value) {
        results.add(value);
    }

    /**
     *
     * @return last result item
     */
    public double getLastResult() {
        return results.get(results.size() - 1);
    }

    /**
     *
     * @return first result item
     */
    public double getResult() {
        return results.get(0);
    }

    /**
     * Return list of results as text.
     *
     * @return StringBuilder to string
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("History\n");
        for (Double d : results) {
            string.append(d).append("\n");
        }
        return string.toString();
    }
}
