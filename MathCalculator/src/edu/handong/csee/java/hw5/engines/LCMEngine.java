package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class calculates the Least Common Multiple (LCM) of multiple integers.
 */
public class LCMEngine implements Computable {

    private static final String engineName = "LCM";
    private int[] numbers;

    private double result;

    /**
     * This method sets the input values and checks if they are valid.
     * @param args The input arguments from the command line.
     */
    @Override
    public void setInput(String[] args) {

        if(args.length < 3) { // engineName + at least 2 numbers
            InputChecker.printErrorMesssageForTheNumberOfRequiredInputsAndExit(engineName, 2);
        }

        numbers = new int[args.length - 1]; // args[0] is engine name

        for(int i = 1; i < args.length; i++) {
            try {
                int num = Integer.parseInt(args[i]);
                if(num < 0) {
                    InputChecker.printErrorMesssageForNegativeInputsAndExit(engineName);
                }
                numbers[i - 1] = num;
            } catch (NumberFormatException e) {
                System.out.println("The input value should be a valid integer for " + engineName + ".");
                System.exit(0);
            }
        }
    }

    /**
     * This method calculates the LCM of all input numbers.
     */
    @Override
    public void compute() {
        int lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            lcm = computeLCM(lcm, numbers[i]);
        }
        result = lcm;
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) using the Euclidean algorithm.
     * @param a First integer
     * @param b Second integer
     * @return GCD of a and b
     */
    private int computeGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calculates the Least Common Multiple of two numbers.
     * @param a First integer
     * @param b Second integer
     * @return LCM of a and b
     */
    private int computeLCM(int a, int b) {
        return (a * b) / computeGCD(a, b);
    }

    /**
     * Returns the result of the LCM calculation.
     * @return The LCM as a double.
     */
    @Override
    public double getResult() {
        return result;
    }
}
