package edu.handong.csee.java.hw6.exceptions;

/**
 * Thrown when an invalid command is entered.
 * Example: "ADD" instead of "MIN"
 */
public class InvalidCommandException extends Exception {
    
    /**
     * Creates an exception with a message about invalid command.
     * @param command The invalid command that was entered
     */
    public InvalidCommandException(String command) {
        super("Exception-01: Invalid command: " + command.toUpperCase() + System.lineSeparator() +
              "Please put a computing engine option such as LCM, GCD, SQRT, FACTORIAL, FIBONACCI, MAX, MIN, CUBEVOL, and SPHEREVOL. For example, ./app  MAX 12 4 5 45 100");
    }
} 