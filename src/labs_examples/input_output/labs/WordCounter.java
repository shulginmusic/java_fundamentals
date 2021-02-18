package labs_examples.input_output.labs;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
//A Simple Java program to find out how many times a word appears in a certain text file
public class WordCounter {
    public static void main(String[] args) {
        //Set the path
        String path = "/Users/dmfan113/Documents/The Picture of Dorian Gray.txt";
        //Greet user
        System.out.println("Hello! We are going to find out how many times" +
                " a word appears in the following text file\n: " + path);
        System.out.print("Enter a word: " );
        //Get input from user
        Scanner scanner = new Scanner(System.in);
        String userWord = scanner.next();
        //Declare the wordCount variable
        int wordCount = 0;
        try {
            //Declare the string list to hold the lines
            //Read the lines in using the Files utility class, then split the lines into words utilizing a regex
            //So it will be words only
            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {
                String[] words = line.split("\\W+");

                //Check if a word appears and if so, how many times
                for (String word : words) {
                    //Ignore the case
                    if (word.equalsIgnoreCase(userWord)) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException exc) {
            System.out.println(exc.getLocalizedMessage());
        }
        //Let the user know the result
        System.out.println("The word " + userWord + " appears in the file " + wordCount + " times");
    }
}

