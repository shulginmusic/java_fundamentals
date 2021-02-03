package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 3:
 *
 *      Demonstrate a try/catch/finally block.
 *
 */

public class Exercise_03 {
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
        } finally {
            System.out.println("\nPROGRAM END");
        }
    }
}
