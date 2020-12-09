package labs_examples.fundamentals.labs;
/**
 * Fundamentals Exercise 4: My Second Program
 *
 *      Write the necessary code to display, declare and print each of Java's primitive data types.
 *      Please declare a single variable of each type, give it an appropriate value, then print that variable.
 *
 */

public class Exercise_04 {

    public static void main(String[] args) {

        int i = 1;
        System.out.println("int i is: " + i);
        //8 Primitive Data Types in Java

        //Boolean
        boolean success = true;
        boolean failure = false;

        //Byte
        byte one = 1;
        byte negative_hundred = -100;

        //Short
        short three_thousand = 3000;
        short negative_twenty_thousand = -20000;

        //Int
        int one_hundred_k = 100000;
        int neg_one_mil = -1000000;

        //Longs
        long very_large_number = ((int) Math.pow(2,45));
        long very_large_neg_number = ((int)Math.pow(-3, 10));

        //Floats

        float one_five = 1.5f;

        //Doubles
        double many_decimal_points = 5.6784848484884;

        //Chars

        char first = 'a';

        System.out.println("i = " + i);
        System.out.println("\n8 Primitive Data Types in Java\nBoolean:");
        System.out.println("success = " + success);
        System.out.println("failure = " + failure);
        System.out.println("\nWhole Numbers\nBytes: ");
        System.out.println("one = " + one);
        System.out.println("negative_hundred = " + negative_hundred);
        System.out.println("\nShorts:");
        System.out.println("three_thousand = " + three_thousand);
        System.out.println("negative_twenty_thousand = " + negative_twenty_thousand);
        System.out.println("\nInts:");
        System.out.println("one_hundred_k = " + one_hundred_k);
        System.out.println("neg_one_mil = " + neg_one_mil);
        System.out.println("\nLongs:");
        System.out.println("very_large_number = " + very_large_number);
        System.out.println("very_large_neg_number = " + very_large_neg_number);
        System.out.println("\nFloats:");
        System.out.println("one_five = " + one_five);
        System.out.println("\nDoubles:");
        System.out.println("many_decimal_points = " + many_decimal_points);
        System.out.println("\nLast but not a number, char:");
        System.out.println("first = " + first);
    }
}
