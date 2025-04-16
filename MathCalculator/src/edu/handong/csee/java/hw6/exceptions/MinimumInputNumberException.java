package edu.handong.csee.java.hw6.exceptions;

/**
 * Thrown when not enough numbers are provided.
 * Example: MIN command with only one number
 */
public class MinimumInputNumberException extends Exception {
    
    /**
     * Creates an exception with a message about minimum input requirement.
     * @param engine Name of the engine that needs more inputs
     */
    public MinimumInputNumberException(String engine) {
        super("Exception-02: You need at least 2 input values for " + engine + ".");
    }
}
