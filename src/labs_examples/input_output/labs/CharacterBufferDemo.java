package labs_examples.input_output.labs;
import java.io.*;

public class CharacterBufferDemo {
    // *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
    public static void main(String[] args){

        try{
            // create the FileWriter (writes character by character)
            FileWriter fw = new FileWriter("cities.txt");
            // create the BufferedWriter using the FileWriter
            BufferedWriter bw = new BufferedWriter(fw);

            // write some text (line by line) to the file
            bw.write("Dubai");
            bw.newLine();
            bw.write("Moscow");
            bw.newLine();
            bw.write("Сан-Франциско");

            // close the connections to the file
            bw.close();
            fw.close();

        }catch(IOException e1){
            System.out.println("error detected");
            e1.printStackTrace();
        }

        try{
            // create the FileReader (reads character by character)
            FileReader fr = new FileReader("cities.txt");
            // create the BufferedReader using the FileReader
            BufferedReader br = new BufferedReader(fr);

            // now we can read whole lines at a time
            String line = br.readLine();

            // while there are more lines
            while(line!=null){
                // print the line
                System.out.println(line);
                // get the next line and loop (if it's not null)
                line = br.readLine();
            }

            // close the connections to the file
            br.close();
            fr.close();

        }catch(IOException e2){
            System.out.println("error detected");
            e2.printStackTrace();
        }
    }
}
