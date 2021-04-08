package labs_examples.datastructures.queue.examples;

import java.util.PriorityQueue;
class QueueRepl {
    public static void main(String[] args) {
        PriorityQueue<String> myQueue = new PriorityQueue();

        // add several elements to the myQueue
        myQueue.add("Dog");
        myQueue.add("Cat");
        myQueue.add("Horse");
        myQueue.add("Bird");

//         print out every element in this myQueue
        for (String word : myQueue) {
            System.out.println(word);
        }
        System.out.println();

        // why did they print out in the order they did
        //Because the JVM sorts the elements in this collection in "Natural Order", see link below:
        //https://stackoverflow.com/questions/9176643/difference-between-natural-ordering-and-total-ordering

        // pop the first element off the myQueue
        String s = myQueue.remove();
        System.out.println(s);
        System.out.println();
        // print out every element again
        for (String word : myQueue) {
            System.out.println(word);
        }
        System.out.println();

        // demonstrate several other PriorityQueue methods
        System.out.println(myQueue.comparator()); //no comparator, so the JVM uses its "Natural Order"
        System.out.println(myQueue.peek());
        System.out.println(myQueue.contains("Dog"));
        System.out.println(myQueue.size());
        System.out.println(myQueue.element());

        myQueue.clear();
    }
}