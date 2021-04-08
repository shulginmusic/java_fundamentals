package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_03
 *
 *      Please create your own custom doubly-LinkedList from start to finish :) You got this!
 */
public class Exercise_03 {
    public static void main(String[] args) {
        MyDoublyLinkedList<String> letters = new MyDoublyLinkedList<>();

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

        letters.remove("C"); //removing from the middle of the list
        letters.remove("A"); //removing first element
        letters.remove("E"); //removing last element
        letters.remove("Z"); //Trying to remove unknown element

        System.out.println(letters.get("B")); //get by value
        System.out.println(letters.getFirst()); //get first
        System.out.println(letters.getSize()); //get size
        letters.clear(); //clear list
        System.out.println(letters.getFirst()); //return null from empty list

    }
}