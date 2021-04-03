package labs_examples.datastructures.linkedlist.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *
 *      1) create a LinkedList (from Java's libraries)
 *      2) add()
 *      3) addAll()
 *      4) addFirst()
 *      5) addLast()
 *      6) getFirst()
 *      7) getLast()
 *      8) get()
 *      9) set()
 *      10) push()
 *      11) pop()
 *      12) remove()
 *      13) contains()
 *      14) listIterator()
 *      15) clear()
 */

public class Exercise_01 {
    public static void main(String[] args) {
        //1) create a LinkedList (from Java's libraries)
        LinkedList<String> cities = new LinkedList<>();

        //2) add()
        cities.add("SF");

        //3) addAll()

        ArrayList<String> russianCities = new ArrayList<>();
        russianCities.add("Moscow");
        russianCities.add("Tula");
        russianCities.add("St. Petersburg");

        cities.addAll(russianCities);

        //4) addFirst()
        cities.addFirst("New York");

        //5) addLast()
        cities.addLast("Los Angeles");

        // 6) getFirst()
        System.out.println(cities.getFirst());

        //7) getLast()
        System.out.println(cities.getLast());

        //8) get()
        System.out.println(cities.get(2));

        //9) set()
        cities.set(0, "Bend"); //this actually updates the index and throws out the old value

        //10) push()

//        This method is equivalent to addFirst.

        cities.push("Tampa");

        // *      11) pop()
        System.out.println(cities.pop()); //Pops the element from the TOP of the list...

        //12) remove()
        cities.remove(); //removes the first item if no arguments given
        //args can also be index and Object
        cities.remove("Tula"); //Object
        cities.remove(2); //Index

        // 13) contains()
        System.out.println(cities.contains("SF"));

        //14) listIterator()
        ListIterator iterator = cities.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //15) clear()
        cities.clear();





    }
}



















