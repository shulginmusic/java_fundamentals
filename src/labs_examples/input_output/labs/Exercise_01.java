package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */

class Example {

    public static void main(String[] args) {
        //Init the stream
        BufferedInputStream inBuffer = null;
        //Init the writer
        BufferedWriter bw = null;
        //Set the path for the file to be read
        String path = "/Users/dmfan113/Documents/The Picture of Dorian Gray.txt";
        //Set the path for the file to write to
        String writePath = "/Users/dmfan113/Documents/dorian_gray_copy.txt";
        try {
            //Declare the stream
            inBuffer = new BufferedInputStream(new FileInputStream(path));
            //Declare the writer
            // create the BufferedWriter using the FileWriter
            bw = new BufferedWriter(new FileWriter(writePath));

            //5 bytes a time - set the byte array to hold 5 bytes
            byte[] fiveBytes = new byte[5];
            int bytesRead = 0;

            while ((bytesRead = inBuffer.read(fiveBytes)) != -1) {
                System.out.print(new String(fiveBytes, 0, bytesRead));
                bw.write(new String(fiveBytes, 0, bytesRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inBuffer != null) {
                    inBuffer.close();
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}