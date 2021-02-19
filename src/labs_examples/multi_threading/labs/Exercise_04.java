package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

public class Exercise_04 {
    public static void main(String[] args) {
        Cat bonifacio = new Cat("Boni");

        MyThread t1 = new MyThread("My first thread", bonifacio, 1);
        System.out.println("t1 complete");
        MyThread t2 = new MyThread("My second thread", bonifacio, 5);


    }
}

class MyThread implements Runnable {

    Thread thread;
    Cat cat;

    public MyThread(String name, Cat cat, int priority) {

        this.cat = cat;
        thread = new Thread(this, name);
        thread.setPriority(priority);
        thread.start();

    }

    @Override
    public void run() {
        synchronized (cat) {
            cat.catGreeting();
            System.out.println("Called from " + this.thread.getName());
        }

        cat.catFarewell();

    }
}

class Cat {
    String name;

    Cat (String name) {
        this.name = name;
    }

    void catGreeting() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, my name is " + this.name);
    }

    synchronized void catFarewell() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}