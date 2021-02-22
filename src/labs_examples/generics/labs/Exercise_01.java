package labs_examples.generics.labs;

/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

public class Exercise_01 {
    public static void main(String[] args) {
        MyClass<String> language = new MyClass<>();
        language.setT("Russian");
        System.out.println(language.getT());

        MyClass<Boolean> male = new MyClass<>();
        male.setT(true);
        System.out.println(male.getT());

    }
}

class MyClass<T> {
   private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


}
