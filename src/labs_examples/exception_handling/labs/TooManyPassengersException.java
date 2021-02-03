package labs_examples.exception_handling.labs;

public class TooManyPassengersException extends Exception{
    @Override
    public String toString() {
        return "Sorry, too many passengers for the car!";
    }
}
