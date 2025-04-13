package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class calculates the volume of a sphere.
 * The formula is (4/3) * pi * r^3.
 */
public class SphereVolEngine implements Computable {

    private static final String engineName = "SPHEREVOL";
    private double num;

    private double result;

    /**
     * This method sets the input value from the user and checks if it's valid.
     * @param args The input from the command line (radius).
     */
    @Override
    public void setInput(String[] args) {

        if (args.length != 2) {
            InputChecker.printErrorMesssageForTheNumberOfRequiredInputsAndExit(engineName, 1);
        }

        try {
            num = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("The input value should be a valid number for " + engineName + ".");
            System.exit(0);
        }

        if (num < 0) {
            InputChecker.printErrorMesssageForNegativeInputsAndExit(engineName);
        }
    }

    /**
     * This method calculates the volume of a sphere using the formula.
     */
    @Override
    public void compute() {
        result = (4.0 / 3.0) * Math.PI * Math.pow(num, 3);
    }

    /**
     * This method returns the calculated sphere volume.
     * @return The result as a double.
     */
    @Override
    public double getResult() {
        return result;
    }
}
