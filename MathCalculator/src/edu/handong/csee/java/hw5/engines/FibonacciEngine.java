package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class calculates the nth Fibonacci number.
 * For example, Fibonacci(7) is 13.
 */
public class FibonacciEngine implements Computable {

    private static final String engineName = "FIBONACCI";
    private int num;

    private double result;

    /**
     * This method gets the input number from the user.
     * It also checks if the number is a valid non-negative integer.
     * @param args The input values from the command line.
     */
    @Override
    public void setInput(String[] args) {

        if(args.length != 2) {
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
     * This method calculates the Fibonacci number at position 'num'.
     */
    @Override
    public void compute() {
        if (num == 0) {
            result = 0;
        } else if (num == 1) {
            result = 1;
        } else {
            int a = 0, b = 1;
            for (int i = 2; i <= num; i++) {
                int temp = a + b;
                a = b;
                b = temp;
            }
            result = b;
        }
    }

    /**
     * This method returns the result of the Fibonacci calculation.
     * @return The result as a double value.
     */
    @Override
    public double getResult() {
        return result;
    }
}
