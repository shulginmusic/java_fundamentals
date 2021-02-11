package labs_examples.input_output.labs;

import java.io.*;

//	  *    4) Demonstrate the use of the DataInputStream and DataOutputStream
public class DataInputStreamDemo {
    public static void main(String[] args) {
        String path = "/Users/dmfan113/Documents/Code/CodingNomads/labs/online-java-fundamentals/src/labs_examples" +
                "/input_output/labs/data.txt";
        DataInputStream dataIn = null;
        DataOutputStream dataOut = null;

        //Some vars to write
        double age = 26.3432;
        int year = 2021;
        int yearBorn = 1994;
        String color = "зелёный";
        boolean isOld = false;
        try {
            dataIn = new DataInputStream(new FileInputStream(path));
            dataOut = new DataOutputStream(new FileOutputStream(path));
            //Write some stuff
            dataOut.writeDouble(age);
            dataOut.writeInt(year);
            dataOut.writeInt(yearBorn);
            dataOut.writeChars(color);//this is interesting
            dataOut.writeBoolean(isOld);

            byte [] chars = new byte[14];
            ////
            System.out.println(dataIn.readDouble());
            System.out.println(dataIn.readInt());
            System.out.println(dataIn.readInt());
            dataIn.readFully(chars);//huh?
            for (byte b : chars) {
                System.out.print(b + " ");
            }
//            System.out.println(dataIn.readChar());
//            System.out.println(dataIn.readBoolean());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert dataIn != null;
            try {
                dataIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert dataOut != null;
            try {
                dataOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
