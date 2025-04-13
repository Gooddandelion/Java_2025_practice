package edu.handong.csee.java.hw5.util;

/**
 * This class checks if the input values are valid.
 * It prints error messages when the input is wrong.
 */
public class InputChecker {

    /**
     * This method prints an error message if the number of inputs is not enough.
     * Then, the program stops.
     * @param engineName The name of the engine.
     * @param numOfRequiredInputs The number of inputs that the engine needs.
     */
    public static void printErrorMesssageForTheNumberOfRequiredInputsAndExit(String engineName,
                                                                             int numOfRequiredInputs) {
        if (numOfRequiredInputs == 1) {
            System.out.println("You need " + numOfRequiredInputs + " input values for " + engineName.toUpperCase() + ".");
            System.exit(0);
        }else if (numOfRequiredInputs == 2) {
            System.out.println("You need at least " + numOfRequiredInputs + " input values for " + engineName.toUpperCase() + ".");
            System.exit(0);
        }

    }

    /**
     * This method prints an error message if an input value is negative.
     * Then, the program stops.
     * @param engineName The name of the engine.
     */
    public static void printErrorMesssageForNegativeInputsAndExit(String engineName) {
        System.out.println("The input value cannot be negative for " + engineName.toUpperCase() + ".");
        System.exit(0);
    }

}

