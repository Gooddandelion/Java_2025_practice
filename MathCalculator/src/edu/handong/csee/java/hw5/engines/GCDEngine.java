package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class calculates the Greatest Common Divisor (GCD) of multiple integers.
 */
public class GCDEngine implements Computable {

    private static final String engineName = "GCD";
    private int[] numbers;

    private double result;

    /**
     * Sets input values and checks for validity.
     * @param args The input values from the command line.
     */
    @Override
    public void setInput(String[] args) {

        if (args.length < 3) {
            InputChecker.printErrorMesssageForTheNumberOfRequiredInputsAndExit(engineName, 2);
        }

        numbers = new int[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            try {
                int val = Integer.parseInt(args[i]);
                if (val < 0) {
                    InputChecker.printErrorMesssageForNegativeInputsAndExit(engineName);
                }
                numbers[i - 1] = val;
            } catch (NumberFormatException e) {
                System.out.println("The input value should be a valid integer for " + engineName + ".");
                System.exit(0);
            }
        }
    }

    /**
     * Calculates the GCD of all input numbers using the Euclidean algorithm.
     */
    @Override
    public void compute() {
        int gcd = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            gcd = computeGCD(gcd, numbers[i]);
        }

        result = gcd;
    }

    /**
     * Computes the GCD of two integers using the Euclidean algorithm.
     * @param a First number
     * @param b Second number
     * @return The GCD of a and b
     */
    private int computeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Returns the result of the GCD calculation.
     * @return The GCD as a double.
     */
    @Override
    public double getResult() {
        return result;
    }
}
