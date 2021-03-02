package labs_examples.lambdas.labs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Lambdas Exercise 1:
 * <p>
 * 1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 * 2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 * an anonymous inner class from this interface.
 * <p>
 * 3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 * value of the same type as the parameter
 * 4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 * an anonymous inner class from this interface.
 * <p>
 * 5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 * value
 * 6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 * an anonymous inner class from this interface.
 * <p>
 * 7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 */

public class Exercise_01 {
    public static void main(String[] args) {

        //2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
        //an anonymous inner class from this interface.
        MyFunctionalInterface lambdaOne = () -> {
            System.out.println("Welcome to my lambda");
        };
        lambdaOne.myMethodOne();
        //Anon inner class
        MyFunctionalInterface myAnonClass = new MyFunctionalInterface() {
            @Override
            public void myMethodOne() {
                System.out.println("I'm in an Anonynoums Inner Class!");
            }
        };
        myAnonClass.myMethodOne();

        System.out.println();
//        4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
//                *          an anonymous inner class from this interface.

        MyFunctionalInterfaceTwo lambdaTwo = (int a) -> {
            return a + 5;
        };
        System.out.println(lambdaTwo.myMethodTwo(10));

        //Inner anon class
        MyFunctionalInterfaceTwo myAnonClassTwo = new MyFunctionalInterfaceTwo() {
            @Override
            public int myMethodTwo(int a) {
                return a * a;
            }
        };

        int x = myAnonClassTwo.myMethodTwo(67);
        System.out.println(x);

//        6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
//                *          an anonymous inner class from this interface.

        MyFunctionalInterfaceThree lambdaThree = (int a, int b) -> {
            int c = a + b;
            String s = Character.getName(c);
            return s.toCharArray()[0];

        };

        System.out.println(lambdaThree.myMethodThree(3, 54));

        MyFunctionalInterfaceThree myAnonClassThree = new MyFunctionalInterfaceThree() {
            @Override
            public char myMethodThree(int a, int b) {
                return Character.forDigit(a, b);
            }
        };
        System.out.println(myAnonClassThree.myMethodThree(3, 54));



        //Using Runnable interface
        new Thread(() -> {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I'm runnable");

        }).start();

//        7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.

        //Using Comparator Functional Interface - not from function package, but still really cool and quite useful
        Employee efim = new Employee("efim",5, 34.5);
        Employee oliver = new Employee("oliver",17, 15.67);

        Comparator<Employee> compareByHours = (e1, e2) -> {

            return (e1.hoursWorked - e2.hoursWorked);

        };

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(efim);
        employees.add(oliver);
        employees.add(new Employee("Donald", 5, 143535435345d));

        //Sort by efficiency
        Collections.sort(employees, (e1, e2) -> {
            double hourlyRateE1 = e1.salary / e1.hoursWorked;
            double hourlyRateE2 = e2.salary / e2.hoursWorked;

            return (int) (hourlyRateE1 - hourlyRateE2);
        });
        for (Employee e : employees) {
            System.out.println(e.name + " " + e.salary);
        }

        //Using Predicate functional Interface - this one is from the java.util.function package

        Predicate<Integer> moreThanHundred = i -> (i > 100);
        System.out.println("Using Predicate functional interface: " + moreThanHundred.test(5));
    }


}

class Employee {
    String name;
    int hoursWorked;
    double salary;

    public Employee(String name, int hoursWorked, double salary) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.salary = salary;
    }
}

//1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
@FunctionalInterface
interface MyFunctionalInterface {
    public void myMethodOne();
}

//3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
//        *          value of the same type as the parameter

@FunctionalInterface
interface MyFunctionalInterfaceTwo {
    public int myMethodTwo(int a);
}

//5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
//        *          value

@FunctionalInterface
interface MyFunctionalInterfaceThree {
    public char myMethodThree(int a, int b);
}
