package labs_examples.arrays.labs;

import java.util.Scanner;

/**
 *  More labs_examples.arrays
 *
 *      Using the array below, take in a number from 1-10 from the user and print out the index of that
 *      element.
 *
 */

public class Exercise_02 {

    public static void main(String[] args) {

        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        printIndex(array);

    }
    public static int getNum(int [] numArr) {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt user
        System.out.print("Enter a number between 0 and "
                + numArr.length + "...");
        int num = scanner.nextInt();
        return num;
    }
    public static void printIndex(int [] numArr) {
        int num = getNum(numArr);
        int index = getIndex(numArr, num);
        System.out.println("The number " + num +
                " is at index " + index + "!");
    }

    public static int getIndex(int[] nums, int num){
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == num){
                return i;
            }
        }
        return -1; //invalid index, not found
    }
}