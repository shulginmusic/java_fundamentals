package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */
public class Exercise_01 {
    public static void main(String[] args) {
        //Here is one way
        MyThread threadOne = new MyThread("My first thread");


        //Here is another way
        MyOtherRunnable threadTwo = new MyOtherRunnable();
        Thread t = new Thread(threadTwo, "My other thread");
        t.setPriority(5);
        t.start();



    }

    private static class MyThread implements Runnable {

        Thread thread;

        public MyThread(String name) {
            thread = new Thread(this, name);
            thread.setPriority(1);
            thread.start();

        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println(this.thread.getName() + " is running");
            }

        }
    }

    private static class MyOtherRunnable implements Runnable {
        @Override
        public void run(){
            for (int i = 0; i < 50; i++) {
                System.out.println("I'm in " + Thread.currentThread().getName() + "!");
            }

        }
    }
}



