package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.*;

/**
 * Finds the largest number among inputs.
 * Example: Max of 3, 7, 2 is 7
 */
public class MaxEngine implements Computable {

    private String engineName = "MAX";
    private double[] numbers;
    private double result;

    /**
     * Sets the input numbers from user.
     * @param args User input (two or more numbers)
     * @throws MinimumInputNumberException If input count is less than 2
     * @throws MyNumberFormatException If any input is not a number
     */
    @Override
    public void setInput(String[] args) throws MinimumInputNumberException, MyNumberFormatException {
        if (args.length < 3) {
            throw new MinimumInputNumberException(engineName);
        }

        numbers = new double[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            try {
                numbers[i - 1] = Double.parseDouble(args[i]);
            } catch (NumberFormatException e) {
                throw new MyNumberFormatException(args[i], engineName);
            }
        }
    }

    /**
     * Finds the largest number.
     */
    @Override
    public void compute() {
        result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            result = Math.max(result, numbers[i]);
        }
    }

    /**
     * Returns the largest number.
     * @return Maximum value
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
    public double[] getNumbers() {
        return numbers;
    }

    /**
     * Sets the input numbers.
     * @param numbers New array of numbers
     */
    public void setNumbers(double[] numbers) {
        this.numbers = numbers;
    }
}
