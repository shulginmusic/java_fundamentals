package labs_examples.input_output.labs;

import java.io.*;
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
        //Instantiate the File and FileReader objects
        File textFile = null;
        FileReader fileIn = null;
        //Declare the wordCount variable
        int wordCount = 0;
        try {
            //Declare the File and FileReader objects
            textFile = new File(path);
            fileIn = new FileReader(textFile);
            //Declare the char array to hold the data from the file
            char [] fileChars = new char[(int) textFile.length()];
            //Read the chars into the char array
            fileIn.read(fileChars);
            //Make a string to hold the text not
            String text = new String(fileChars);
            //Make a words array
            //Use a regex to only put letters/nums into words arr
            String [] words = text.split("\\W+");
            //Check if a word appears and if so, how many times
            for (String word : words) {
                //Ignore the case
                if (word.equalsIgnoreCase(userWord)) {
                    wordCount++;
                }
            }
        } catch (IOException exc) {
            System.out.println(exc.getLocalizedMessage());
        } finally {
            try {
                assert fileIn != null;
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Let the user know the result
        System.out.println("The word " + userWord + " appears in the file " + wordCount + " times");
    }
}

