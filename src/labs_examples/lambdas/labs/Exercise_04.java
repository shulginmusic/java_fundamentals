package labs_examples.lambdas.labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Lambdas Exercise 4:
 *
 *      Stream API Labs
 *
 *      1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
 *      2) Demonstrate the use of the sum function to determine the range of a set of numbers.
 *      3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
 *          to get the sum of the modified list
 *      4) Demontrate the filter function by filtering out all Integers that are less than 10 - then use the average
 *          function to average the remaining numbers, assign this result to an int variable.
 *      5) Demonstrate the reduce() function to determine the sum of a list of Integers
 *      6) Demontsrate how to Stream a text file and print out each line
 *      7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          the print out the element at the 1 index for each array.
 *      8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          the print out the sum of all elements at index 2.
 *      9) Demonstrate the anyMatch() function.
 *      10) Demonstrate the allMatch() function.
 *      11) Demonstrate the collect() terminal operation to store resulting values into a List
 *      
 */

public class Exercise_04 {
    public static void main(String[] args) throws IOException{
        //1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
        IntStream
                .range(1, 16).
                forEach(i -> System.out.print(i + " "));

        // *2) Demonstrate the use of the sum function to determine the range of a set of numbers.
        System.out.println();
        int[] numbers = {1, 45, 67, 23, 44};
        System.out.println(Arrays.stream(numbers).min().getAsInt());
        System.out.println(Arrays.stream(numbers).max().getAsInt());

//        3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
//        to get the sum of the modified list

//         *      5) Demonstrate the reduce() function to determine the sum of a list of Integers

        List<Integer> ints = Arrays.asList(1, 2, 5, 89);
        int sum = ints
                .stream()
                .map(i -> i + 100)
                .reduce(2, Integer::sum);


        //4) Demonstrate the filter function by filtering out all Integers that are less than 10 - then use the average
        // *          function to average the remaining numbers, assign this result to an int variable.

        Arrays
                .stream(numbers)
                .filter(i -> i > 10)
                .average()
                .ifPresent(i -> System.out.println(i));

//       6) Demontsrate how to Stream a text file and print out each line
//        String path = "/Users/dmfan113/Documents/The Picture of Dorian Gray.txt";
//        Stream<String> myText = Files.lines(Paths.get(path));
//        myText
//                .forEach(line -> System.out.println(line));


//        7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
// *          the print out the element at the 1 index for each array.
        System.out.println();
        String csvPath = "/Users/dmfan113/Documents/Code/CodingNomads/labs/online-java-fundamentals/src/labs_examples" +
                "/lambdas/labs/stream_text_lab.csv";
        Stream<String> csvLines = Files.lines(Paths.get(csvPath));
        csvLines
                .map(line -> line.split(","))
                .forEach(words -> System.out.println(words[1]));

    }
}

















