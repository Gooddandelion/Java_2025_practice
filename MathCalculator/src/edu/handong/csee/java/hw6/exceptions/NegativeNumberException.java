package edu.handong.csee.java.hw6.exceptions;

/**
 * Thrown when a negative number is provided.
 * Example: SQRT command with -4
 */
public class NegativeNumberException extends Exception {
    
    /**
     * Creates an exception with a message about negative number.
     * @param engine Name of the engine that doesn't accept negative numbers
     */
    public NegativeNumberException(String engine) {
        super("Exception-03: The input value cannot be negative for " + engine + ".");
    }
} 