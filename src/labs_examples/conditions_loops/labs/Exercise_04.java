package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 4: Even numbers
 *
 *      Using a "for-loop", print out all even numbers from 1-100.
 *
 */

public class Exercise_04 {
    public static void main(String[] args) {
        forLoop();
    }

    public static void forLoop(){
        for(int i = 0; i <= 100; i++){
            if((i % 2) != 0){
                continue;
            }
            System.out.println(i);
        }
    }
}
