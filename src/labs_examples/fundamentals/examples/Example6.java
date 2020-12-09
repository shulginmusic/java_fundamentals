package labs_examples.fundamentals.examples;

/*
  Demonstrate the for loop.

  Call this file ForDemo.java.
*/
class ForDemo {
    public static void main(String args[]) {
        int count;
        int aNewNum = 67894;

        //for(initialization; condition; iteration) statement;
        for(count = 0; count < aNewNum; count = count+1)
            System.out.println("This is count: " + count);

        System.out.println("Done!");
    }
}