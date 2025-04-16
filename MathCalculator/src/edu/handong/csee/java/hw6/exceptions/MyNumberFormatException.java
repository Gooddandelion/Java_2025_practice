package edu.handong.csee.java.hw6.exceptions;

/**
 * Thrown when input cannot be converted to a number.
 * Example: SQRT command with "abc"
 */
public class MyNumberFormatException extends NumberFormatException {
    
    /**
     * Creates an exception with a message about invalid number format.
     * @param input The invalid input that cannot be converted to a number
     * @param engine Name of the engine that received the invalid input
     */
    public MyNumberFormatException(String input, String engine) {
        super("Exception-05: The input value should be converted into a number. (" + input + " is not a number value for " + engine + ".)");
    }
} 