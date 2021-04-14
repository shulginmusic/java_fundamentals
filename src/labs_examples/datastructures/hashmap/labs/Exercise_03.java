package labs_examples.datastructures.hashmap.labs;

import labs_examples.datastructures.linkedlist.labs.MyLinkedList;
import labs_examples.datastructures.queue.labs.MyQueue;
import labs_examples.datastructures.queue.labs.QueueEmptyException;
import labs_examples.datastructures.stack.labs.MyStack;
import labs_examples.datastructures.stack.labs.StackEmptyException;

import java.util.*;

/**
 * HashMaps Exercise_03
 * <p>
 * Create a new class that does the following:
 * <p>
 * 1) create a LinkedList
 * 2) create a Stack
 * 3) create a Queue
 * 4) create a HashMap
 * <p>
 * Then, add millisecond timers before and after each data structure above and print out
 * how long it takes for each to complete EACH the following tasks, and the total time for
 * each data structure:
 * <p>
 * 1) add 100 elements
 * 2) update 100 elements
 * 3) search for 100 elements
 * 4) delete 100 elements
 */

//for the timer, thanks to https://www.baeldung.com/java-measure-elapsed-time

public class Exercise_03 {
    public static void main(String[] args) throws StackEmptyException, QueueEmptyException {
        //Java built-in data structures

        LinkedList<Integer> javaLinkedList = new LinkedList<>();
        Stack<Integer> javaStack = new Stack<>();
        PriorityQueue<Integer> javaPriorityQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> javaHashMap = new HashMap<>();

        //Custom built data structures by me

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        MyStack<Integer> myStack = new MyStack<>();
        MyQueue<Integer> myQueue = new MyQueue<>();
        CustomHashRewritten<Integer, Integer> myHashMap = new CustomHashRewritten<>();

        //Long variables for time tracking

        long start = 0;
        long finish = 0;
        long timeElapsed = finish - start;

        //JAVA BUILT-IN DATASTRUCTURES TESTING

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

        //delete  100 elements
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

        //CUSTOM TESTING

        System.out.println("-----------------------");
        System.out.println("Custom data structures testing");
        System.out.println("-----------------------");

        //LINKED LIST
        System.out.println("Custom Linked List");

        //add 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myLinkedList.add(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

        //update 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myLinkedList.add(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

        //search for 100 elements
        start = System.currentTimeMillis();
        search = 0;
        for (int i = 0; i < 100; i++) {
            try {
                search = myLinkedList.get(i); //although this is get by value, so some will be like "no such value"
            } catch (NullPointerException exc) {
                ;
            }
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);

        //delete  100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myLinkedList.remove(0); //although this is get by value, so some will be like "no such value"
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to delete 100 elements: " + timeElapsed);
        System.out.println("-----------------------");

        //STACK
        System.out.println("Custom Stack");

        //add 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myStack.push(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

        //update 100 elements
        start = System.currentTimeMillis();

        //First delete 100 elements
        myStack.clear();
        //Then push new 100 elements
        for (int i = 0; i < 100; i++) {
            myStack.push(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

//        search for 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(myStack.search(generateRandom()));
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);


        //delete  100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myStack.pop();
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to delete 100 elements: " + timeElapsed);
        System.out.println("-----------------------");

        //QUEUE
        System.out.println("Custom Queue");

        //ADD 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myQueue.enqueue(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to add 100 elements: " + timeElapsed);

        //UPDATE 100 elements
        start = System.currentTimeMillis();

        //First delete 100 elements
        myQueue.clear();
        //Then push new 100 elements
        for (int i = 0; i < 100; i++) {
            myQueue.enqueue(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

        //search for 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(myQueue.search(generateRandom()));
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);

        //delete  100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myQueue.dequeue();
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to delete 100 elements: " + timeElapsed);
        System.out.println("-----------------------");

        //Hashmap

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

        //update 100 elements
        start = System.currentTimeMillis();
        for (int i = generateRandom(); i < generateRandom() + 100; i++) {
            myHashMap.update(i, generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to update 100 elements: " + timeElapsed);

        //search for 100 elements
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            myHashMap.retrieve(generateRandom());
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to search 100 elements: " + timeElapsed);

        //delete  100 elements
        start = System.currentTimeMillis();
        myHashMap.clear();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Milliseconds to clear 100 elements: " + timeElapsed);
        System.out.println("-----------------------");

        //There was an alternative to actually try and delete 100 different keys, but it keeps freezing in this class
        //for some reason:

//        //delete  100 elements
//        start = System.currentTimeMillis();
//        //This unfortunately throws ConcurrentModificationException... So we'll just clear here
////        for (Integer key : javaHashMap.keySet()) {
////            javaHashMap.remove(key);
////        }
////        javaHashMap.clear();
//        for (int i = 0; i < 100; i++) {
//            myHashMap.delete(generateRandom());
//        }
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("Milliseconds to delete 100 elements: " + timeElapsed);
//        System.out.println("-----------------------");

    }

    //A method to generate random numbers
    private static Integer generateRandom() {
        int min = 0;
        int max = 1423;
        int range = max - min + 1;

        return (int) (Math.random() * range) + min;

    }
}





















