package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.*;

/**
 * Calculates cube volume.
 * Volume = side × side × side
 * 
 * @author 22100324 박헌일
 */
public class CubeVolEngine implements Computable {

    private String engineName = "CUBEVOL";
    private double length;
    private double result;

    /**
     * Sets the side length from user input.
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
            length = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            throw new MyNumberFormatException(args[1], engineName);
        }

        if (length < 0) {
            throw new NegativeNumberException(engineName);
        }
    }

    /**
     * Calculates the cube volume.
     */
    @Override
    public void compute() {
        result = Math.pow(length, 3);
    }

    /**
     * Returns the calculated volume.
     * @return Volume of the cube
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
     * Returns the side length.
     * @return Length of cube's side
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the side length.
     * @param length New length for cube's side
     */
    public void setLength(double length) {
        this.length = length;
    }
}
