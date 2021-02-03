package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 6:
 *
 *      Demonstrate throwing an exception in one method and catching it in another method.
 *
 */
public class Exercise_06 {
    public static void main(String[] args) {
        try {
            divideTenPlusFive(0);
        } catch (ArithmeticException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void divideTenPlusFive(int x) {
        try {
            int y = divideTen(x) + 5;
        } catch (ArithmeticException exc) {
            System.out.println("Cannot complete operation");
            throw exc;
        }
    }

    public static int divideTen(int x) throws ArithmeticException {
        return (10 / x);
    }
}
