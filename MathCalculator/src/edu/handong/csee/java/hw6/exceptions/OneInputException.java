package edu.handong.csee.java.hw6.exceptions;

/**
 * Thrown when only one input is provided for an engine that needs more inputs.
 * Example: MAX command with only one number
 */
public class OneInputException extends Exception {
    
    /**
     * Creates an exception with a message about one input requirement.
     * @param engine Name of the engine that needs more inputs
     */
    public OneInputException(String engine) {
        super("Exception-04: You need one input value for " + engine + ".");
    }
} 