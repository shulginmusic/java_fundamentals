package labs_examples.datastructures.hashmap.labs;

/**
 *      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *      1) no method has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      2) no variable has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      3) resize the HashMap when the underlying array is more than half full
 *      4) triple the size of the underlying array on resize()
 *      5) instead of checking the number of keys to resize, check the number of values
 *      6) on collisions, add new elements to the front of the LinkedList, not the end
 *      7) anytime someone tries to get/update/remove an element that does not exist, print
 *          out a message indicating that the element does not exist
 *      8) add at least one more method that you think could be useful to the HashMap
 *          review Java's built-in HashMap for inspiration
 */

public class Exercise_02 {
    public static void main(String[] args) {
        CustomHashRewritten<String, String> names = new CustomHashRewritten<>();
        //insert method
        names.insert("Efim", "Shulgin");
        names.insert("Donald", "Duck");
        names.insert("Mickey", "Mouse");

        //retrieve method
        System.out.println(names.retrieve("Efim"));
        System.out.println(names.retrieve("Donald"));

        //delete method
        names.delete("Mickey");
//        names.delete("Mickey"); //nothing to delete


        //Inserting values so hashmap gets crowded and resized

        names.insert("Efim", "Shulgin");
        names.insert("Efim", "Shulgin");
        names.insert("Efim", "Shulgin");

        names.insert("Donald", "Duck");
        names.insert("Donald", "Duck");
        names.insert("Donald", "Duck");

        names.insert("Mickey", "Mouse");
        names.insert("Mickey", "Mouse");
        names.insert("Mickey", "Mouse");

        names.printInfo();

        names.delete("Efim");
        //don't mind the size here in the debugger - the hashmap is messed up on purpose to create more collisions,
        // so entries have identical keys for collision simulation

        String name = names.retrieve("Mickey");
        System.out.println(name); //Debug here to see new underlying array size

        //Clearing
        names.clear();




    }
}

