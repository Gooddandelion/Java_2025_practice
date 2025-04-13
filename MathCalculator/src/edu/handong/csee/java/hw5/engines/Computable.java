package edu.handong.csee.java.hw5.engines;

/**
 * This interface defines the basic structure for all engines.
 * Every engine must set input, do computation, and return the result.
 */
public interface Computable {

    /**
     * This method sets the input values from the user.
     * @param args The input values from the command line.
     */
    public void setInput(String[] args);

    /**
     * This method does the calculation.
     */
    public void compute();

    /**
     * This method returns the result.
     * @return The result as a double value.
     */
    public double getResult();
}
