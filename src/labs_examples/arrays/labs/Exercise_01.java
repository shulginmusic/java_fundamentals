package labs_examples.arrays.labs;
import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {
    public static void main(String[] args) {
        int [] tenNums = getTenNums();
        printSumAndAverage(tenNums);
    }

    public static int[] getTenNums() {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt user
        System.out.print("Enter 10 numbers... ");

        int [] tenNums = new int [10];
        for(int i = 0; i < tenNums.length; i++) {
            int newNum = scanner.nextInt();
            tenNums[i] = newNum;
        }
        return tenNums;
    }

    public static double getSum(int[] intArray) {
        double sum = 0;
        for(int i = 0; i < intArray.length; i++ ) {
            sum += intArray[i];
        }
        return sum;
    }

    public static double getAverage(int [] intArray) {
        double sum = getSum(intArray);
        //Average is sum / number of values in set
        double average = sum / intArray.length;
        return average;
    }

    public static void printSumAndAverage(int [] intArray) {
        double sum = getSum(intArray);
        double average = getAverage(intArray);
        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The average is " + average);
    }
}


//reference: https://www.softwaretestinghelp.com/pass-return-array-in-java/