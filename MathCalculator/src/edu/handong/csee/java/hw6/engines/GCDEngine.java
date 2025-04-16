package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.*;

/**
 * Calculates Greatest Common Divisor of numbers.
 * Example: GCD of 12 and 18 is 6
 */
public class GCDEngine implements Computable {

    private String engineName = "GCD";
    private int[] numbers;
    private double result;

    /**
     * Sets the input numbers from user.
     * @param args User input (two or more numbers)
     * @throws MinimumInputNumberException If input count is less than 2
     * @throws NegativeNumberException If any input is negative
     * @throws MyNumberFormatException If any input is not a number
     */
    @Override
    public void setInput(String[] args) throws MinimumInputNumberException, NegativeNumberException, MyNumberFormatException {
        if(args.length < 3) {
            throw new MinimumInputNumberException(engineName);
        }

        numbers = new int[args.length - 1];

        for(int i = 1; i < args.length; i++) {
            try {
                int num = Integer.parseInt(args[i]);
                if(num < 0) {
                    throw new NegativeNumberException(engineName);
                }
                numbers[i - 1] = num;
            } catch (NumberFormatException e) {
                throw new MyNumberFormatException(args[i], engineName);
            }
        }
    }

    /**
     * Calculates the GCD using Euclidean algorithm.
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
     * Helper method to calculate GCD of two numbers.
     * @param a First number
     * @param b Second number
     * @return GCD of a and b
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
     * Returns the calculated GCD.
     * @return GCD value
     */
    @Override
    public double getResult() {
        return result;
    }

    /**
     * Returns the engine name.
     * @return Name of this engine
     */
    @Override
    public String getEngineName() {
        return engineName;
    }

    /**
     * Sets the engine name.
     * @param engineName New name for this engine
     */
    @Override
    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    /**
     * Returns the input numbers.
     * @return Array of input numbers
     */
    public int[] getNumbers() {
        return numbers;
    }

    /**
     * Sets the input numbers.
     * @param numbers New array of numbers
     */
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
