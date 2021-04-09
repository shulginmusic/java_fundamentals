package labs_examples.datastructures.hashmap.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> cityPopulations = new HashMap();

        // add several cities (key )and their populations (value )to the HashMap
        cityPopulations.put("San Francisco", 850000);
        cityPopulations.put("New York", 8500000);
        cityPopulations.put("Chicago", 2710000);

        // retrieve the population of each city using the key
        System.out.println(cityPopulations.get("San Francisco"));

        // print each element (key and value) in the HashMap
        Set entries = cityPopulations.entrySet();
        Iterator iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry city = (Map.Entry) iterator.next();
            System.out.println("Key: " + city.getKey());
            System.out.println("Value: " + city.getValue());
        }

        // demonstrate at least 3 other HashMap methods
        System.out.println(cityPopulations.containsKey("Tampa"));
        cityPopulations.clear();
        System.out.println(cityPopulations.isEmpty());
    }
}
