package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_02
 *
 *      Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 *      class we used here, it must be entirely unique. Please also add at least two
 *      additional helper methods that you think could be useful. Refer to Java's built-in
 *      LinkedList class for inspiration. Your new LinkedList class should ONLY allow users
 *      to add and remove elements from the front of the list AND the end of the list.
 *      Also, instead of using the index in the get() and remove() methods, these methods should
 *      get() and remove() based by the Node's value, not it's index.
 */

public class Exercise_02 {
    public static void main(String[] args) {
        //Constructing the list with two values
        MyLinkedList<Integer> numsList = new MyLinkedList<Integer>();
//
        numsList.add(345);
        numsList.add(11);
        numsList.add(432);
        numsList.add(222);
        numsList.add(231);

        numsList.remove(345); //Test removing first element
        numsList.remove(432); //Test removing from the middle
        numsList.remove(231); //Test removing last element
        numsList.remove(11111); //Test with no such value in list

        numsList.add(1, true); //Test adding to the front of a not-empty list
        numsList.add(787); //Test adding to the end of the list

        System.out.println(numsList.getFirst());//Test getting first
        System.out.println(numsList.get(432));//Test getting by value
        System.out.println(numsList.get(1321231)); //Test trying to get an unexisting node
        System.out.println(numsList.get(11)); //get last value from list

        numsList.clear();//Test clear() method
        System.out.println(numsList.getSize());

        numsList.add(3);
        numsList.remove(3);
        System.out.println(numsList.getSize());


    }
}

