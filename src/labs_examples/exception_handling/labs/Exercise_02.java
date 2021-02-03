package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 2:
 *
 *      Demonstrate a try/catch with multiple catch statements.
 *
 */

public class Exercise_02 {
    public static void main(String[] args) {
        int [] nums = {5, 56, 47, 0};
        try {
            for (int i = 0; i < 1000; i++) {
                System.out.println(100 / nums[i]);
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println(exc.getLocalizedMessage());
        } catch (ArithmeticException exc) {
            System.out.println(exc.getLocalizedMessage());
        }
    }
}


