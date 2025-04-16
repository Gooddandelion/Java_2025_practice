package edu.handong.csee.java.hw6.engines;

import edu.handong.csee.java.hw6.exceptions.MyNumberFormatException;
import edu.handong.csee.java.hw6.exceptions.NegativeNumberException;
import edu.handong.csee.java.hw6.exceptions.OneInputException;

/**
 * This class calculates the volume of a sphere.
 * The formula is (4/3) * pi * r^3.
 * 
 * @author 20230123 Your Name
 */
public class SphereVolEngine implements Computable {

    private String engineName = "SPHEREVOL";
    private double radius;
    private double result;

    /**
     * This method sets the input value from the user and checks if it's valid.
     * @param args The input from the command line (radius).
     */
    @Override
    public void setInput(String[] args) throws OneInputException, NegativeNumberException, MyNumberFormatException {
        if (args.length != 2) {
            throw new OneInputException(engineName);
        }

        try {
            radius = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            throw new MyNumberFormatException(args[1], engineName);
        }

        if (radius < 0) {
            throw new NegativeNumberException(engineName);
        }
    }

    /**
     * This method calculates the volume of a sphere using the formula.
     */
    @Override
    public void compute() {
        result = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * This method returns the calculated sphere volume.
     * @return The result as a double.
     */
    @Override
    public double getResult() {
        return result;
    }

    /**
     * This method returns the engine name.
     * @return The engine name as a String.
     */
    @Override
    public String getEngineName() {
        return engineName;
    }

    /**
     * This method sets the engine name.
     * @param engineName The engine name to set.
     */
    @Override
    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    /**
     * This method returns the radius.
     * @return The radius as a double.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * This method sets the radius.
     * @param radius The radius to set.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
