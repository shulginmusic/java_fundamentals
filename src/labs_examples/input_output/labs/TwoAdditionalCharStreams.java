package labs_examples.input_output.labs;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class TwoAdditionalCharStreams {
    public static void main(String[] args) {
        CharArrayReader charReader = null;
        CharArrayWriter charWriter = null;
        char [] country = "United Arab Emirates".toCharArray();
        try {
            charReader = new CharArrayReader(country);
            int c;
            while ((c = charReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert charReader != null;
            charReader.close();
        }
        System.out.println();
        try {
            charWriter = new CharArrayWriter();
            charWriter.write("Hello, my name is Efim!");
            char [] greeting = charWriter.toCharArray();
            for (char c : greeting) {
                System.out.print(c);
            }
            System.out.println("\nCharacter array length: " + greeting.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
