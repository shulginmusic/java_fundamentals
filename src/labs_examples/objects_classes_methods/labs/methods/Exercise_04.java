package labs_examples.objects_classes_methods.labs.methods;

/**
 * Create a recursive method named factorial that will return the factorial of any number passed to it.
 *
 * For instance, after creating the factorial method, uncomment the two lines in the main() method. When you run
 * it, it should print 120. It should also work for any there number you pass it.
 *
 */
public class Exercise_04 {

    public static void main(String[] args) {
        double x = factorial(5);
        System.out.println(x);

        //max it will go to without doing weird stuff is 39
        double z = factorial(1000);
        System.out.println(z);
        System.out.println(z * 40);
    }

    public static double factorial(double x) {
        double factorialOfX;

        if (x == 1) //base case
            return 1; //no curly brackets ? Syntax of recursion?
        factorialOfX = x * factorial(x - 1); //continuing forward
        return factorialOfX;

        //first, there is a stack that's created with an ambiguous expression:
        //factorialOfX = 5 * factorial(5-1);
        //or factorialOfX = 5 * factorial(4);
        //so the stack looks like this until you reach 1:
        //
        // factorialOfX = 5 * factorial(4); //when x == 5
        // factorialOfX = 4 * factorial(3); //when x == 4
        // factorialOfX = 3 * factorial(2); //when x == 3
        // factorialOfX = 2 * factorial(1); //when x == 2
        // factorialOfX = 1; //when x == 1

        // Once we get to 1, we start going back up the stack...

        // factorialOfX = 1
        // factorialOFX = 2 * factorial(1) // when x == 2;
        // factorial of 1 == 1, so
        // factorialOfX = 2; //when x == 2
        //...
        //factorialOFX = 3 * factorial(2) = 6 // when x == 3;
        //factorialOFX = 4 * factorial(3) = 24 // when x == 4;
        //factorialOFX = 5 * factorial(4) = 120 // when x == 5; //because 24 * 5 = 20



    }




}

