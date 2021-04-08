package labs_examples.datastructures.queue.labs;

public class QueueEmptyException extends Exception {
    //This exception is thrown when the queue is empty
    @Override
    public String toString() {
        return "StackEmptyException{ Queue is empty! }";
    }
}
