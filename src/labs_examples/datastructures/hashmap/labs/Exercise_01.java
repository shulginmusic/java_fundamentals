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

        //put()
        users.put(1, "efim1994");
        users.put(2, "henrymaas342");

        //get()
        System.out.println(users.get(2));

        //putAll()
        HashMap<Integer, String> usersTwo = new HashMap<>();
        usersTwo.putAll(users);
        System.out.println(users.get(2));

        //size()
        System.out.println(users.size());

        //contains()
        System.out.println(users.containsKey(3));
        System.out.println(users.containsValue("efim1994"));

        //keySet()
        System.out.println(users.keySet()); //shows the keys in this map

        //entrySet()
        System.out.println(users.entrySet()); //shows the entries (key-value pairs) in this map

        //putIfAbsent()
        users.putIfAbsent(3, "devin_t32");
        users.putIfAbsent(3, "devin_t32");
        System.out.println(users.entrySet());

        //remove()
        users.remove(3);

        //replace()
        users.replace(2, "james_h12");
        System.out.println(users.get(2));

        //forEach() Thanks to: https://www.programiz.com/java-programming/library/hashmap/foreach
        users.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });

        //clear()
        users.clear();
        System.out.println(users.entrySet()); //entry set is now empty because the map has been cleared








    }
}
