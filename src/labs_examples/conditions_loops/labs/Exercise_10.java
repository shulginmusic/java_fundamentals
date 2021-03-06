package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 10: continue
 *
 *      Demonstrate the use of the "continue" statement to skip to the next iteration of a loop.
 *
 */

public class Exercise_10 {
    public static void main(String[] args) {
        for (int i = 100; i >=0; i--){
            if ((i % 5) != 0){
                continue;
            }
            printValue(i);
        }
    }

    public static void printValue(int i) {
        System.out.println(i);
    }
}

