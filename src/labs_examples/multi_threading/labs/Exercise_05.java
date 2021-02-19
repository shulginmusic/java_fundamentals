package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 */

public class Exercise_05 {
    public static void main(String[] args) {
        Cat cat = new Cat("Johny");
        aThread t1 = new aThread("first thread", cat, 2);
        aThread t2 = new aThread("second thread", cat, 6);

        t1.thread.start();
        t2.thread.start();

        try {
            Thread.sleep(500);
            t1.waitThis();
            Thread.sleep(1000);
            t2.waitThis();
            t1.thread.notify();
            Thread.sleep(1000);
            t2.thread.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 class aThread implements Runnable {

    Thread thread;
    Cat cat;

    public aThread(String name, Cat cat, int priority) {

        this.cat = cat;
        thread = new Thread(this, name);
        thread.setPriority(priority);

    }

    @Override
    public void run() {
        synchronized (cat) {
            cat.catGreeting();
            System.out.println("Called from " + this.thread.getName());
        }

        cat.catFarewell();
    }

    public void waitThis() {
        try {
            this.thread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

