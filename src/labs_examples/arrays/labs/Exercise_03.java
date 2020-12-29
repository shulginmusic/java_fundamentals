package labs_examples.arrays.labs;

/**
 *  2D Array
 *
 *      Create and populate a 5x5 2D array with multiples of 3, starting with 3. Once populated, print out the results.
 *
 *      The output should look something like this:
 *
 *      3 6 9 12 15
 *      18 21 24 27 30
 *      ...
 *      ...
 *      ...
 *
 */

public class Exercise_03 {

    public static void main(String[] args) {
        //create array
        int [] [] multiplesOfThree = new int [5] [5];
        //we'll populate using this variable
        int x = 3;
        for (int i = 0; i < multiplesOfThree.length; i++) {
            for(int z = 0; z < multiplesOfThree[i].length; z++){
                multiplesOfThree [i] [z] = x;
                x += 3; //so that next time it's a higher multiple of 3

            }
        }

        for (int[] numbers : multiplesOfThree){
            for (int num : numbers){
                System.out.print(num + " ");
            }
            System.out.println();//print a new line for each new row after first
        }
    }
}
