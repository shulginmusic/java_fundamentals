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
        int sum = calculateSum();
        System.out.println("The sum is " + sum);
//        int average = calculateAverage(sum);
//        System.out.println("testtests " + average);

    }

    public static int getLowerNum() {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt user
        System.out.println("Enter a lower number");
        //Assing input to an int variable
        int lowerNum = scanner.nextInt();
        return lowerNum;
    }

    public static int getHigherNum() {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt user
        System.out.println("Enter a higher number");
        //Assigning input to an int variable
        int higherNum = scanner.nextInt();
        return higherNum;
    }

    public static int calculateSum() {
        int i = getLowerNum();
        int z = getHigherNum();
        int sum = 0;
        for (; i <= z; i++) {
            sum += i;
        }
        return sum;
    }
}

//
//    public static int calculateAverage(int sum){
//        //Average is the sum of numbers divided by the number of value in a set
//
//        //get number of values using for loop
//        for(int i)
//    }
//}











