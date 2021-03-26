package labs_examples.input_output.labs;


import java.io.*;

/**
 * Input/Output Exercise 2: File encryption
 *
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files.
 *
 *      Then, head back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */

public class Exercise_02 {
    public static void main(String[] args) {
        String readPath = "/Users/dmfan113/Documents/The Picture of Dorian Gray.txt";
        String writePath = "/Users/dmfan113/Documents/dorian_gray_copy.txt";
        BufferedReader fr = null;
        BufferedWriter fw = null;
        try {
            fr = new BufferedReader(new FileReader(readPath));
            fw = new BufferedWriter(new FileWriter(writePath));

            int i = fr.read();

            while (i != -1) {
                //REFERENCE: https://theasciicode.com.ar/ascii-printable-characters/capital-letter-z-uppercase-ascii-code-90.html
                //Encrypt all the capital letters by incrementing the characters by 3
                if (i >= 'A' && i <= 'Z') {
                    i += 3;
                }
                //Encrypt all the lowercase letters by decrementing the characters by 3
                if (i >= 'a' && i <= 'z') {
                    i -= 3;
                }
                System.out.print((char) i);
                fw.write((char) i);
                i = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Close the connections to both files
            try {
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }

        System.out.println("---------------------------\n DECRYPTED:");

        BufferedReader decryptor = null;
        try {
            decryptor = new BufferedReader(new FileReader(writePath));

            int d = decryptor.read();


            while (d != -1) {
                //Decrypt all the capital letters
                if (d > 67 && d < 94) {
                    d -= 3;
                }
                //Decrypt all the lowercase letters
                if (d > 93 && d < 120) {
                    d += 3;
                }
                System.out.print((char) d);
                d = decryptor.read();
            }
        } catch (IOException exc) {
            System.out.println(exc.getLocalizedMessage());
        } finally {
            try {
                if (decryptor != null) {
                    decryptor.close();
                }
            } catch (IOException exc) {
                System.out.println(exc.getLocalizedMessage());
            }
        }
//        int[] nums = java.util.stream.IntStream.rangeClosed(1, 10).toArray();
    }
}


