package labs_examples.input_output.labs;

import java.io.*;
import java.util.Scanner;

public class ByteBufferDemo {
    public static void main(String[] args) {
        // *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextInt();
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream("num.txt"));
            System.out.println(num);
            out.write((int) num);
        } catch (IOException exc) {
            System.out.println(exc.getLocalizedMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException exc) {
                System.out.println(exc.getLocalizedMessage());
            }
        }
    }
}
