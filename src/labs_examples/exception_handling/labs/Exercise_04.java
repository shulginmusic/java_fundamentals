package labs_examples.exception_handling.labs;

import java.util.Scanner;

/**
 * Exception Handling Exercise 4:
 *
 *      Demonstrate a nested try/catch.
 *
 */

public class Exercise_04 {
    public static void main(String[] args) {
        int [] nums = {4, 89 , 444, 33, 78, 0};
        try {
            System.out.print("How many numbers would you like to divide 12 by? ");
            Scanner scanner = new Scanner(System.in);
            int reply = scanner.nextInt();
            for (int i = 0; i < reply; i++) {
                System.out.println(12 / nums[i]);
            }
        } catch (ArithmeticException exc) {
            try {
                //something goes here
            } catch (ArrayIndexOutOfBoundsException exc1) {
                //something goes here
            }
        }
    }
}
