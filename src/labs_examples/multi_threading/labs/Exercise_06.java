package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

public class Exercise_06 {
    //Many thanks to this tutorial on helping me understand the logic behind this: https://javaknowledge4jobs.blogspot.com/2019/04/print-even-and-odd-numbers-using-two.html

    public static void main(String[] args) {
        //Declare the object to synchronize on
        PrintEvenOdd printEvenOrOdd = new PrintEvenOdd(1, 100);
        //Declare the threads
        Thread even = new Thread(new myThreadClass(printEvenOrOdd, true), "Even Thread");
        Thread odd = new Thread(new myThreadClass(printEvenOrOdd, false), "Odd Thread");
        //Start the threads
        even.start();
        odd.start();

    }
}

//Runnable class for the two threads
class myThreadClass implements Runnable {
    //Pass the object to synchronize on
    PrintEvenOdd printEvenOrOdd;
    boolean isEven;

    public myThreadClass(PrintEvenOdd printEvenOrOdd, boolean isEven) {
        this.printEvenOrOdd = printEvenOrOdd;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        if (this.isEven) {
            printEvenOrOdd.printEven();
        } else {
            printEvenOrOdd.printOdd();
        }
    }
}

class PrintEvenOdd {
    int start;
    int end;

    public PrintEvenOdd(int start, int end) {
        this.start = start;
        this.end = end;
    }

    void printEven() {
        while (this.start <= this.end) {
            //Synchronized block to handle the operations inside while loop
            //Synchronized prevents threads from accessing an object simultaneously
            synchronized (this) {
                if (this.start % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + start);
                    //increment the object's start variable
                    start++;
                    notify(); //wakes up the next thread
                } else {
                    try {
                        wait(); //wait if num isn't even
                    } catch (InterruptedException exc) {
                        System.out.println(exc.getLocalizedMessage());
                    }
                }
            }
        }
    }

    void printOdd() {
        while (this.start <= this.end) {
            synchronized (this) {
                //opposite logic compared to printEven(), due to the != operator
                if (this.start % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + start);
                    start++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException exc) {
                        System.out.println(exc.getLocalizedMessage());
                    }
                }
            }
        }
    }
}

