package edu.handong.csee.java.hw6;

import edu.handong.csee.java.hw6.engines.*;
import edu.handong.csee.java.hw6.exceptions.*;

/**
 * This class runs the calculator program.
 * It finds the correct engine and shows the result.
 * 
 * @author 22100324 박헌일
 */
public class Calculator {
    
    /**
     * This is the main method.
     * It starts the calculator program.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Exception-01: Invalid command: " + System.lineSeparator() +
                             "Please put a computing engine option such as LCM, GCD, SQRT, FACTORIAL, FIBONACCI, MAX, MIN, CUBEVOL, and SPHEREVOL. For example, ./app  MAX 12 4 5 45 100");
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
        String originalCommand = args[0];
        String engineName = originalCommand.toUpperCase();

        Computable engine = null;

        try {
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
                    throw new InvalidCommandException(originalCommand);
            }

            engine.setInput(args);
            engine.compute();
            System.out.println("The result of " + engineName + " is " + engine.getResult() + ".");
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        } catch (MinimumInputNumberException e) {
            System.out.println(e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        } catch (OneInputException e) {
            System.out.println(e.getMessage());
        } catch (MyNumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
