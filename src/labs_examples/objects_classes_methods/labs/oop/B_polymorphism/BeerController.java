package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class BeerController {
    public static void main(String[] args) {
        class GermanBeer {
            //overloading
            public void statement() {
                System.out.println("I like to drink German beer");
            }
            public void statement(boolean withFriends) {
                if (withFriends) {
                    System.out.println("I like to drink German beer with friends");
                } else {
                    System.out.println("I like to drink German beer");
                }
            }
            public boolean isDark() {
                return false;
            }
        }
        //overriding
        class Dunkel extends GermanBeer {
            @Override
            public boolean isDark() {
                return true;
            }
        }
        //Original method
        GermanBeer warsteiner = new GermanBeer();
        System.out.println(warsteiner.isDark());
        //Overridden
        Dunkel hbDunkel = new Dunkel();
        System.out.println(hbDunkel.isDark());

    }
}
