package labs_examples.input_output.labs;

import java.io.*;

public class TwoAdditionalByteStreams {

    // *    1) Demonstrate the usage of at least two additional Byte Streams
    ObjectOutputStream objectOut = null;
    public static void main(String[] args) {
        //Declare a POJO
        Phone myPhone = new Phone("apple", "iphone 11 pro max", 2019);
        //Write the POJO to a file
        try {
            //Declare and write using objectOut
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("phone.txt"));
            objectOut.writeObject(myPhone);
            objectOut.close(); //But why can't I close in finally block?!
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Declare new Pojo
        Phone aPhone = null;
        try {
            //Declare input stream
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("phone.txt"));
            //Read the object from file
            aPhone = (Phone) objectIn.readObject();
            objectIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert aPhone != null;
        System.out.println(aPhone.toString());
    }
}

class Phone implements Serializable {
    String brand;
    String model;
    int year;

    Phone (String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
