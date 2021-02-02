package labs_examples.static_nonstatic.labs;

import labs_examples.objects_classes_methods.labs.oop.C_blackjack.Deck;

public class StaticNonStatic {


    public static void someStaticMethod() {

        //A static method calling another static method in the same class
        someOtherStaticMethod();

        //A static method calling a non-static method within the same class
        StaticNonStatic test = new StaticNonStatic();
        test.someNonStaticMethod();

        //A static method calling a static method in another class
        double x = Math.cos(56.0);
        System.out.println(x);

        // A static method calling a non-static method in another class
        Apples manyApples = new Apples();
        manyApples.appleStatement();

        //A non-static method calling a non-static method in the same class



    }

    public static void someOtherStaticMethod() {
        System.out.println("Executing another static method");


    }

    public void someNonStaticMethod() {
        System.out.println("Executing non static method");
        //A non-static method calling a non-static method in the same class
        yetAnotherNonStaticMethod();
        //6) A non-static method calling a non-static method in another class
        Deck cardDeck = new Deck();
        cardDeck.populateDeck();
        //A non-static method calling a static method in another class
        int y = Math.abs(5);
        System.out.println(y);
    }

    public void yetAnotherNonStaticMethod() {
        System.out.println("blablabla");
        //A non-static method calling a static method in the same class
        someStaticMethod();
    }

    public static class Apples {
        public void appleStatement() {
            System.out.println("I like apples");
        }
    }
}


