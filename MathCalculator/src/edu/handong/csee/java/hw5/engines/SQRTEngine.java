package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class calculates the square root of a number.
 */
public class SQRTEngine implements Computable {

    private static final String engineName = "SQRT";
    private double num;
    private double result;

    /**
     * This method sets the input value and checks if it is valid.
     * @param args The input from the command line.
     */
    @Override
    public void setInput(String[] args) {

        if (args.length != 2) {
            InputChecker.printErrorMesssageForTheNumberOfRequiredInputsAndExit(engineName, 1);
        }

        try {
            num = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("The input value should be a valid number for " + engineName + ".");
            System.exit(0);
        }

        if (num < 0) {
            InputChecker.printErrorMesssageForNegativeInputsAndExit(engineName);
        }
    }

    /**
     * This method calculates the square root of the number.
     */
    @Override
    public void compute() {
        result = Math.sqrt(num);
    }

    /**
     * This method returns the square root result.
     * @return The result as a double value.
     */
    @Override
    public double getResult() {
        return result;
    }
}
