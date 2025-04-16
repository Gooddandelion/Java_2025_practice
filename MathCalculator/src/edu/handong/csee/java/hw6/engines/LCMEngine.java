package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.*;

/**
 * Calculates Least Common Multiple of numbers.
 * Example: LCM of 4 and 6 is 12
 */
public class LCMEngine implements Computable {

    private String engineName = "LCM";
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
     * Calculates the LCM using GCD.
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
     * Helper method to calculate LCM of two numbers.
     * @param a First number
     * @param b Second number
     * @return LCM of a and b
     */
    private int computeLCM(int a, int b) {
        return a * b / computeGCD(a, b);
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
     * Returns the calculated LCM.
     * @return LCM value
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
