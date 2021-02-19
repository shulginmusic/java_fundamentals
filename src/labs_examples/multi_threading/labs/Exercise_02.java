package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */

public class Exercise_02 {
    public static void main(String[] args) {
        MyThread thread = new MyThread("My thread");
        thread.start();
    }

    private static class MyThread extends Thread {

        MyThread (String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " is running");
        }
    }
}
