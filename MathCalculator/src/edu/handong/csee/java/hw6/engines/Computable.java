package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.MinimumInputNumberException;
import edu.handong.csee.java.hw6.exceptions.NegativeNumberException;
import edu.handong.csee.java.hw6.exceptions.MyNumberFormatException;
import edu.handong.csee.java.hw6.exceptions.OneInputException;
import edu.handong.csee.java.hw6.exceptions.InvalidCommandException;

/**
 * This interface defines the basic structure for all engines.
 * Every engine must set input, do computation, and return the result.
 * 
 * @author 22100324 박헌일
 */
public interface Computable {

    /**
     * This method sets the input values from the user.
     * @param args The input values from the command line.
     * @throws MinimumInputNumberException When the number of inputs is less than required
     * @throws NegativeNumberException When a negative number is input
     * @throws MyNumberFormatException When the input cannot be converted to a number
     * @throws OneInputException When more than one input is provided for single-input operations
     * @throws InvalidCommandException When an invalid command is provided
     */
    public void setInput(String[] args) throws MinimumInputNumberException, NegativeNumberException, 
                                             MyNumberFormatException, OneInputException, InvalidCommandException;

    /**
     * This method does the calculation.
     */
    public void compute();

    /**
     * This method returns the result.
     * @return The result as a double value.
     */
    public double getResult();

    /**
     * This method returns the engine name.
     * @return The engine name as a String.
     */
    public String getEngineName();

    /**
     * This method sets the engine name.
     * @param engineName The engine name to set.
     */
    public void setEngineName(String engineName);
}
