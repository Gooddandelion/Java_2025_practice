package edu.handong.csee.java.hw5.engines;

import edu.handong.csee.java.hw5.util.InputChecker;

/**
 * This class finds the smallest number among the input values.
 */
public class MinEngine implements Computable {

    private static final String engineName = "MIN";
    private double[] num;


    private double result;

    /**
     * This method sets the input values and checks if they are valid numbers.
     * @param args The numbers from the command line.
     */
    @Override
    public void setInput(String[] args) {

        if (args.length < 3) {
            InputChecker.printErrorMesssageForTheNumberOfRequiredInputsAndExit(engineName, 2);
        }

        num = new double[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            try {
                num[i - 1] = Double.parseDouble(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("The input value should be a valid number for " + engineName + ".");
                System.exit(0);
            }
        }
    }

    /**
     * This method finds the smallest number from the input list.
     */
    @Override
    public void compute() {
        result = num[0];

        for (int i = 1; i < num.length; i++) {
            result = Math.min(result, num[i]);
        }
    }

    /**
     * This method returns the smallest number found.
     * @return The minimum value as a double.
     */
    @Override
    public double getResult() {
        return result;
    }
}
