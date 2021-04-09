package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;

/**
 *  HashMaps Exercise_01
 *
 *  Demonstrate you're mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 *
 */
public class Exercise_01 {
    public static void main(String[] args) {
        HashMap<Integer, String> users = new HashMap<>();

        //put
        users.put(1, "efim1994");
        users.put(2, "agniia_z");

        //get
        System.out.println(users.get(2));

        //putAll


    }
}
