package labs_examples.exception_handling.labs;

import java.util.Scanner;

/**
 * Exception Handling Exercise 7:
 *
 *      1) Create a custom exception.
 *      2) Demonstrate a method throwing your custom exception.
 */

public class Exercise_07 {
    public static void main(String[] args) {
        try {
            uberRide();
            System.out.println("Great, let's go!");
        } catch (TooManyPassengersException exc) {
            System.out.println(exc.toString());
        } finally {
            System.out.println("\nProgram Complete");
        }
    }

    public static void uberRide() throws TooManyPassengersException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello, how many people are riding today? ");
        int passengers = scanner.nextInt();
        if (passengers > 5) {
            throw new TooManyPassengersException();
        }
    }
}