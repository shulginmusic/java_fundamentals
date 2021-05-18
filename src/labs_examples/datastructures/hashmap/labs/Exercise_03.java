package labs_examples.datastructures.hashmap.labs;

import java.util.*;

/**
 *      HashMaps Exercise_03
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 100 elements
 *      2) update 100 elements
 *      3) search for 100 elements
 *      4) delete 100 elements
 */

//for the timer, thanks to https://www.baeldung.com/java-measure-elapsed-time

public class Exercise_03 {
    public static void main(String[] args) {
        //Java built-in data structures

        LinkedList<Integer> javaLinkedList = new LinkedList<>();
        Stack<Integer> javaStack = new Stack<>();
        PriorityQueue<Integer> javaPriorityQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> javaHashMap = new HashMap<>();

        long start = 0;
        long finish = 0;
        long timeElapsed = finish - start;


        System.out.println("-----------------------");
        System.out.println("Java built-in data structures testing");
        System.out.println("-----------------------");


        //LINKED LIST
        System.out.println("Java Linked List");

        //add 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaLinkedList.push(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

        //update 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaLinkedList.add(i, generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

        //search for 100 elements
        start = System.currentTimeMillis();
        int search = 0;
        for (int i = 0; i < 100; i++) {
            search = javaLinkedList.get(i);
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);

        //delete  100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaLinkedList.remove(0);
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to delete 100 elements: " + timeElapsed);
        System.out.println("-----------------------");

        //Stack
        System.out.println("Java Stack");

        //add 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaStack.push(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

        //update 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaStack.add(i, generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

        //search for 100 elements
        start = System.currentTimeMillis();
        search = 0;
        for (Integer element : javaStack) {
            search = javaStack.search(element);
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);

        //delete  100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaStack.remove(0);
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to delete 100 elements: " + timeElapsed);
        System.out.println("-----------------------");

        //Queue
        System.out.println("Java Priority Queue");

        //add 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaPriorityQueue.add(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

        //update 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaPriorityQueue.remove();
        }
        for (int i = 0; i < 100; i++) {
            javaPriorityQueue.add(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

        //search for 100 elements
        start = System.currentTimeMillis();
        search = 0;
        for (int i = 0; i < javaPriorityQueue.size(); i++) {
            search = javaPriorityQueue.element();
            javaPriorityQueue.remove();
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);

        
        start = System.currentTimeMillis();
        for (int i = 0; i < javaPriorityQueue.size(); i++) {
            javaPriorityQueue.remove();
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to delete 100 elements: " + timeElapsed);
        System.out.println("-----------------------");

        //Hashmap
        System.out.println("Java Hashmap");

        //add 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            javaHashMap.put(generateRandom(), generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

        //update 100 elements
        start = System.currentTimeMillis();
        for (Integer key : javaHashMap.keySet()) {
            javaHashMap.replace(key, generateRandom(), generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

        //search for 100 elements
        start = System.currentTimeMillis();
        Integer searchedVal = null;
        for (Integer key : javaHashMap.keySet()) {
            searchedVal = javaHashMap.get(key);
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);

        //delete  100 elements
        start = System.currentTimeMillis();
        //This unfortunately throws ConcurrentModificationException... So we'll just clear here
//        for (Integer key : javaHashMap.keySet()) {
//            javaHashMap.remove(key);
//        }
        javaHashMap.clear();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to clear: " + timeElapsed);
        System.out.println("-----------------------");


    }



    //A method to generate random numbers
    private static Integer generateRandom() {
        int min = 0;
        int max = 1423;
        int range = max - min + 1;

        return (int) (Math.random() * range) + min;

    }
}





















