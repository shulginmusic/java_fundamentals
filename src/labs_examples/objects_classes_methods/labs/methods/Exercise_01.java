package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {

        // please create the methods as instructed below then
        // call each of those methods from here, within the main()
        System.out.println(multiplyHere(5,6));
        System.out.println(divideHere(100, 67));
        joke();
        System.out.println(yearsToSeconds(56));

        int [] someArr = {5, 5656, 33, 444};
        System.out.println(varArgs(someArr));


    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b

    public static int multiplyHere(int a, int b){
        return (a * b);
    }


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b

    public static int divideHere(int a, int b){
        return (a / b);
    }


    // 3) Create a static void method that will print of joke of your choice to the console

    public static void joke(){
        System.out.println("1 hour in Python is 7 years in Assembly");
    }


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents
    public static int yearsToSeconds(int years){
        return (years * 31556952);
    }


    // 5) Create a varargs method that will return the length of the varargs array passed in

    public static int varArgs(int array[]){
        return (array.length);
    }






}
