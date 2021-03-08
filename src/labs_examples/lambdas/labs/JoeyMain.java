package labs_examples.lambdas.labs;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JoeyMain {
    public static void main(String[] args) throws IOException {

        //This is a file I created by following the video about the Stream API
        //I know there is already a file in the examples folder but it's easier for me
        //to learn as I follow along

        //1 Integer Stream

        IntStream
                .range(1, 10)
                .forEach(System.out::println); //here we use a method reference

        //2 Integer Stream with skip
        System.out.println("------");
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x)); //here we us a lambda expression

        System.out.println("------");
        //3 Integer Stream with sum
        System.out.println(IntStream.range(1, 100).sum());

        System.out.println("------");
        //4 Stream.of, sorted and findFirst

        Stream.of("Vladimir", "Leonid", "Yaroslavl")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //5 Stream from Array, sort, filter and print
        System.out.println("------");
        //Create array of Strings
        String[] names = {"Nikolay", "Vladimir", "Leonid", "Yaroslavl", "Vladislav", "Volodymyr"};
        Arrays.stream(names) // same as Stream.of(names)
                .filter(x -> x.startsWith("V")) //the only names we want to work with are the ones
                //that start with V
                .sorted() //sort in lexicographical order
                .forEach(name -> System.out.println(name));

        //6 average of cubes of an int array
        System.out.println("------");
        int[] numbers = {1, 45, 67, 23, 44};

        Arrays
                .stream(numbers)
                .map(i -> i * i * i)
                .average()
                .ifPresent(average -> System.out.println(average));

        //7 Stream from List, filter and print
        List<String> people = Arrays.asList("Efim", "Agniia", "Oliver");
        people
                .stream() //obtaining the stream
                .map(s -> s.toLowerCase()) //Change every element to lowercase
                .filter(name -> name.startsWith("a"))
                .forEach(name -> System.out.println(name));

        //8 Stream rows from text file, sort, filter and print

        //Set the paths to the files
        String bandPath = "/Users/dmfan113/Documents/Code/CodingNomads/labs/online-java-fundamentals/src" +
                "/labs_examples/lambdas/examples/stream_api/example_files/bands.txt";
        String dataPath = "/Users/dmfan113/Documents/Code/CodingNomads/labs/online-java-fundamentals/src" +
                "/labs_examples/lambdas/examples/stream_api/example_files/data.txt";

        System.out.println("------");
        Stream<String> bands = Files.lines(Paths.get(bandPath));
        bands
                .sorted()
                .forEach(band -> System.out.println(band));











    }
}
