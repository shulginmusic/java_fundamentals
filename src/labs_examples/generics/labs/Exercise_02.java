package labs_examples.generics.labs;

import java.util.ArrayList;

/**
 * Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList
 */

public class Exercise_02 {
    public static void main(String[] args) {
        ArrayList<Double> someDoubles = new ArrayList<>();
        someDoubles.add(5.0);
        someDoubles.add(6.78);

        System.out.println(returnSumOfElements(someDoubles));

    }

    public static <T extends Number> double returnSumOfElements(ArrayList<T> arrayList) {
        double sum = 0;
        for (T t : arrayList) {
            sum += t.doubleValue();
        }
        return sum;
    }
}
