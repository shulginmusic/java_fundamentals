package labs_examples.conditions_loops.labs;
import java.util.Scanner;

/**
 * Conditions and Loops Exercise 5: Calculator
 *
 *      Take two numbers from the user, an upper and lower bound. Using a "for-loop", calculate the sum
 *      of numbers from the lower bound to the upper bound. Also, calculate the average of numbers.
 *      Print the results to the console.
 *
 *      For example, if a user enters 1 and 100, the output should be:
 *
 *      The sum is: 5050
 *      The average is: 50.5
 *
 *
 */

//Referring to Example 19

public class Exercise_05 {
    public static void main(String[] args) {
        calculateSumAndAverage();

    }

    public static int getNumFromUser(boolean lower) {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt user
        if (lower){
            System.out.println("Enter a lower number:");
        } else{
            System.out.println("Enter a higher number:");
        }
        //Assing input to an int variable
        int num = scanner.nextInt();
        return num;

    }

    public static void calculateSumAndAverage() {
        int lower = getNumFromUser(true); //this is the lower num
        int higher = getNumFromUser(false);
        double sum = 0;
        double count = 0;
        for (int i = lower; i <= higher; i++) {
            sum += i;
            count++;
        }

        double average = sum / count;
        System.out.println("The sum is " + sum);
        System.out.println("The average is " + average);

    }
}









