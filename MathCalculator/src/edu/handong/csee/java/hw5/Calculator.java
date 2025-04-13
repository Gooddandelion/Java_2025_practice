package edu.handong.csee.java.hw5;

import edu.handong.csee.java.hw5.engines.*;

/**
 * This class runs the calculator program.
 * It finds the correct engine and shows the result.
 */
public class Calculator {

    /**
     * This is the main method.
     * It starts the calculator program.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please put a computing engine option such as LCM, GCD, SQRT, FACTORIAL, FIBONACCI, MAX, MIN, CUBEVOL, and SPHEREVOL. For example, java -cp [your classpath] edu.handong.csee.java.hw5.Calculator MAX 12 4 5 45 100");
            System.exit(0);
        }

        Calculator myCalculator = new Calculator();
        myCalculator.run(args);
    }

    /**
     * This method chooses the correct engine based on the user's input.
     * Then, it runs the engine and prints the result.
     * @param args The input arguments from the user.
     */
    public void run(String[] args) {

        String engineName = args[0].toUpperCase();
        Computable engine = null;

        switch (engineName) {
            case "LCM":
                engine = new LCMEngine();
                break;
            case "GCD":
                engine = new GCDEngine();
                break;
            case "SQRT":
                engine = new SQRTEngine();
                break;
            case "FACTORIAL":
                engine = new FactorialEngine();
                break;
            case "FIBONACCI":
                engine = new FibonacciEngine();
                break;
            case "MAX":
                engine = new MaxEngine();
                break;
            case "MIN":
                engine = new MinEngine();
                break;
            case "CUBEVOL":
                engine = new CubeVolEngine();
                break;
            case "SPHEREVOL":
                engine = new SphereVolEngine();
                break;
            default:
                System.out.println("Invalid command: " + engineName);
                System.exit(0);
        }

        engine.setInput(args);
        engine.compute();
        System.out.println("The result of " + engineName + " is " + engine.getResult() + ".");
    }
}
