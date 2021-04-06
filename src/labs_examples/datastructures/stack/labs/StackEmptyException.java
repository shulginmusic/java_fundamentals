package labs_examples.datastructures.stack.labs;

public class StackEmptyException extends Exception {
    //This exception is thrown when stack is empty
    @Override
    public String toString() {
        return "StackEmptyException{ Stack is empty! }";
    }
}
