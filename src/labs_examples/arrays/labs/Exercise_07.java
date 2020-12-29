package labs_examples.arrays.labs;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  ArrayLists
 *
 *      Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 *      Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 *      typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 *      shows a list of methods.
 *
 */
public class Exercise_07 {
    public static void main(String[] args) {
        //Create an array list
        ArrayList<String> dogs = new ArrayList();
        //populate an array list
        dogs.add("daschhound");
        dogs.add("labradoodle");
        dogs.add("australian shepherd");
        dogs.add("maltipoo");
        dogs.add("greyhound");

        //Access elements within the array list
        String dog = dogs.get(0);
        System.out.println(dog);

        //some other cool array list methods

        //change value
        dogs.set(0, "labrador");
        System.out.println(dogs);

        //get length(size) of array list
        int x = dogs.size();
        System.out.println("There are " + x + " dogs here");

        //minimize storage space
        dogs.trimToSize();

        //remove an item

        dogs.remove(4);
        System.out.println(dogs);

        //sort aplhabetically using Collections
        Collections.sort(dogs);
        System.out.println(dogs);

        //Create an array list of ints using the Integer wrapper class!

        ArrayList<Integer> nums = new ArrayList();

        for (int i = 0; i <= 100000; i+=50) {
            nums.add(i);
        }
        System.out.println(nums.get(50));

        String num = "7";
        int numInt = Integer.parseInt(num);
        System.out.println(numInt);
        System.out.println(Integer.bitCount(numInt));

        /*
            74612

            0000 0000 0000




         */


    }
}
