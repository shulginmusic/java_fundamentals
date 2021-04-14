package labs_examples.datastructures.hashmap.labs;

import labs_examples.datastructures.queue.labs.MyQueue;
import labs_examples.datastructures.queue.labs.QueueEmptyException;
import labs_examples.datastructures.stack.labs.StackEmptyException;


public class StackTesting {

    private static Integer generateRandom() {
        int min = 0;
        int max = 1423;
        int range = max - min + 1;

        return (int) (Math.random() * range) + min;

    }

    public static void main(String[] args) {

        CustomHashRewritten<Integer, Integer> myHashMap = new CustomHashRewritten<>();
        long start = 0;
        long finish = 0;
        long timeElapsed = finish - start;

        //Hashmap
        System.out.println("Custom Hashmap");

        //add 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myHashMap.insert(generateRandom(), generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

//        //update 100 elements
//        start = System.currentTimeMillis();
//        for (Integer key : myHashMap.keySet()) {
//            javaHashMap.replace(key, generateRandom(), generateRandom());
//        }
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);
//
//        //search for 100 elements
//        start = System.currentTimeMillis();
//        Integer searchedVal = null;
//        for (Integer key : javaHashMap.keySet()) {
//            searchedVal = javaHashMap.get(key);
//        }
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);
//
//        //delete  100 elements
//        start = System.currentTimeMillis();
//        //This unfortunately throws ConcurrentModificationException... So we'll just clear here
////        for (Integer key : javaHashMap.keySet()) {
////            javaHashMap.remove(key);
////        }
//        javaHashMap.clear();
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Milliseconds to clear: " + timeElapsed);
//        System.out.println("-----------------------");
//
//

    }
}
