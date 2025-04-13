package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class calculates the volume of a cube.
 * The formula is: side × side × side.
 */
public class CubeVolEngine implements Computable {

    private static final String engineName = "CUBEVOL";
    private double num;

    private double result;

    /**
     * This method sets the input value from the user.
     * @param args The input arguments (should contain one number).
     */
    @Override
    public void setInput(String[] args) {

        if(args.length != 2) {
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
     * This method calculates the cube volume using the formula side^3.
     */
    @Override
    public void compute() {
        result = Math.pow(num, 3);
    }

    /**
     * This method returns the result of the calculation.
     * @return The cube volume.
     */
    @Override
    public double getResult() {
        return result;
    }
}
