package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 5:
 *
 *      Demonstrate how to throw an exception.
 *
 */

public class Exercise_05 {
    public static void main(String[] args) {
        try {
            divideTen(0);
        } catch (ArithmeticException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void divideTen(int x) throws ArithmeticException {
        System.out.println(10 / x);
    }
}
