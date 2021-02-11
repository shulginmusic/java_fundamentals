package labs_examples.input_output.labs;

import java.io.*;
import java.util.ArrayList;

/**
 *
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 *
 */

public class Exercise_04 {

    public static void main(String[] args) {
        String path = "/Users/dmfan113/Documents/Code/CodingNomads/labs/online-java-fundamentals/src/labs_examples" +
                "/input_output/labs/cities.csv";
        String writePath = "/Users/dmfan113/Documents/Code/CodingNomads/labs/online-java-fundamentals/src/labs_examples" +
                "/input_output/labs/citiesCopy.csv";
        String[] values = new String[0];
        ArrayList<City> cities = new ArrayList<City>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                values = line.split(",");
                cities.add(mapValuesToCityObject(values));
            }
        } catch (IOException exc) {
            System.out.println(exc.getLocalizedMessage());
        }

        //no need to close because we are using try with resources

        //print out each object
        for (City city : cities) {
            System.out.println(city.toString());
        }
        //write the values String[] to new csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePath))) {
            for (City city : cities) {
                writer.write(cityToCSV(city));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String cityToCSV(City city) {
        String line = city.getName() + "," + city.getCountry() +
                "," + city.getEstablished() + "," + city.getPopulation();
        return line;
    }

    private static City mapValuesToCityObject(String[] values) {
        City city = new City();

        city.setCityName(values[0]);
        city.setCountry(values[1]);
        city.setEstablished(Integer.parseInt(values[2]));
        city.setPopulation(Long.parseLong(values[3]));

        return city;
    }
}
