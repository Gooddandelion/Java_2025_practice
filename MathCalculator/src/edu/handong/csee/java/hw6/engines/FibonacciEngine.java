package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.*;

/**
 * Calculates nth Fibonacci number.
 * Example: F(7) = 13
 */
public class FibonacciEngine implements Computable {

    private String engineName = "FIBONACCI";
    private int num;
    private double result;

    /**
     * Sets the input number from user.
     * @param args User input (one number)
     * @throws OneInputException If input count is wrong
     * @throws NegativeNumberException If input is negative
     * @throws MyNumberFormatException If input is not a number
     */
    @Override
    public void setInput(String[] args) throws OneInputException, NegativeNumberException, MyNumberFormatException {
        if (args.length != 2) {
            throw new OneInputException(engineName);
        }

        try {
            num = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new MyNumberFormatException(args[1], engineName);
        }

        if (num < 0) {
            throw new NegativeNumberException(engineName);
        }
    }

    /**
     * Calculates the Fibonacci number.
     */
    @Override
    public void compute() {
        if (num == 0) {
            result = 0;
            return;
        }
        if (num == 1) {
            result = 1;
            return;
        }

        double prev = 0;
        double curr = 1;
        for (int i = 2; i <= num; i++) {
            double next = prev + curr;
            prev = curr;
            curr = next;
        }
        result = curr;
    }

    /**
     * Returns the calculated Fibonacci number.
     * @return Fibonacci number
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
     * Returns the input number.
     * @return Input number
     */
    public int getNum() {
        return num;
    }

    /**
     * Sets the input number.
     * @param num New input number
     */
    public void setNum(int num) {
        this.num = num;
    }
}
