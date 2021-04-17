package labs_examples.datastructures.hashmap.examples;

import java.util.*;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class HashMapQuiz{


    public static void hashMapExample(){

        // instantiate new HashMap to hold country names and their populations
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();

        // add "China" and 1420062022 to the map
        myMap.put("China", 1420062022);

        // add "India" and 1368737513 to the map
        myMap.put("India", 1368737513);

        // add "USA" and 329093110 to the map
        myMap.put("USA", 329093110);

        // add "Indonesia" and 269536482 to the map
        myMap.put("Indonesia", 269536482);

        // add "Brazil" and 212392717 to the map
        myMap.put("Brazil", 212392717);


        // get the population value for key = "China" and store in a variable
        int chinaPop = myMap.get("China");

        // print China's population
        System.out.println(chinaPop);


        // get the population value for key = "India" and store in a variable
        int indiaPop = myMap.get("India");

        // print India's population
        System.out.println(indiaPop);


        // get the population value for key = "USA" and store in a variable
        int usaPop = myMap.get("USA");

        // print USA's population
        System.out.println(usaPop);

        // get the population value for key = "Indonesia" and store in a variable
        int indonPop = myMap.get("Indonesia");

        // print Indonesia's population
        System.out.println(indonPop);

        // get the population value for key = "Brazil" and store in a variable
        int brazilPop = myMap.get("Brazil");

        // print Brazil's population
        System.out.println(brazilPop);




        // demonstrate iterating through the entries of a HashMap
        // create a Set of entries from the entrySet
        Set<Map.Entry<String, Integer>> data = myMap.entrySet();

        // create an Iterator from that entrySet
        Iterator iterator = data.iterator();




        // loop through the entries using the iterator
//        while (iterator.hasNext()) {

        // get each Entry individually

        // print out the entry's key and value
//        System.out.print("Key = " + data.getKey() + " -> Value = " + data.getValue());
//        System.out.println();
    }
}

