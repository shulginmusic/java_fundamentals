package labs_examples.conditions_loops.labs;
import java.util.Scanner;



/**
 * Conditions and Loops Exercise 7: First vowel
 *
 *      Take in a word from the user and using a "while" loop, find the first vowel in the word.
 *      Once you find the vowel, print out the word and the first vowel.
 *
 *      Hints:
 *          - there are a few helpful methods in the String class called length(), charAt() and indexOf()
 *          - you'll likely want to use a String that contains all the vowels:
 *              - ie: String vowels = "aeiou";
 *
 */

public class Exercise_07 {
    public static void main(String[] args) {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt user
        System.out.println("Enter a word");
        //Assigning input to a String variable
        String word = scanner.next();
        String vowels = "aeiouy";
        int count = 0;

        while (count < word.length()) {
            char letter = word.charAt(count);
            if (vowels.indexOf(letter) != -1) {
                System.out.println("the first vowel in " + word + " is " + letter);
                return;
            }
            count++;
        }
        System.out.println("There is no vowel in " + word);
    }
}



