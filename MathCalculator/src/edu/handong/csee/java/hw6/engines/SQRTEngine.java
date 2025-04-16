package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.*;

/**
 * Calculates square root of a number.
 * Example: √16 = 4
 */
public class SQRTEngine implements Computable {

    private String engineName = "SQRT";
    private double num;
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
            num = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            throw new MyNumberFormatException(args[1], engineName);
        }

        if (num < 0) {
            throw new NegativeNumberException(engineName);
        }
    }

    /**
     * Calculates the square root.
     */
    @Override
    public void compute() {
        result = Math.sqrt(num);
    }

    /**
     * Returns the calculated square root.
     * @return Square root value
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
    public double getNum() {
        return num;
    }

    /**
     * Sets the input number.
     * @param num New input number
     */
    public void setNum(double num) {
        this.num = num;
    }
}
