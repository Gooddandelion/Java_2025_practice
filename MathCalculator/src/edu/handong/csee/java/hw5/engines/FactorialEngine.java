package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class calculates the factorial of a number.
 * For example, factorial of 5 is 5 × 4 × 3 × 2 × 1 = 120.
 */
public class FactorialEngine implements Computable {

    private static final String engineName = "FACTORIAL";
    private int num;

    private double result;

    /**
     * This method gets the input number from the user.
     * It also checks if the input is a valid non-negative integer.
     * @param args The input arguments from the command line.
     */
    @Override
    public void setInput(String[] args) {

        if (args.length != 2) {
            InputChecker.printErrorMesssageForTheNumberOfRequiredInputsAndExit(engineName, 1);
        }

        try {
            num = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("The input value should be a valid integer for " + engineName + ".");
            System.exit(0);
        }

        if (num < 0) {
            InputChecker.printErrorMesssageForNegativeInputsAndExit(engineName);
        }
    }

    /**
     * This method calculates the factorial of the number.
     */
    @Override
    public void compute() {
        result = 1;
        for (int i = 2; i <= num; i++) {
            result = result * i;
        }

    }

    /**
     * This method returns the result of the factorial calculation.
     * @return The result as a double value.
     */
    @Override
    public double getResult() {
        return result;
    }
}