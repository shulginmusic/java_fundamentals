package mysql.labs;

import java.sql.*;


/*
*  MySQL Exercise 4:
*
*   Now that you have mastered your air travel database, it's time to connect this DB to a Java application
*   using JDBC. You can start simple here and build your way up. Within a Java application, using JDBC, please
*   demonstrate how to:
*
*   Note: CRUD means (Create, Read, Update, Delete)
*
*       1.) CRUD new flights
*       2.) CRUD new passengers
*       3.) Bonus: flex those JDBC muscles! How nice, clean, useful can you make this? Show us what you've got!
*
 */

import java.sql.Connection;
import java.util.ArrayList;

//I use SQL naming conventions for some of the variables in this exercise file and other POJOs
// so it's easier to make the mental connection to SQL
//while coding in Java

public class Exercise_04 {

    public static void main(String[] args) {
        /*
        Just as a casual example - each of these operations should be in it's own method. Feel free to
        create all required classes/methods to accomplish this.

        createFlight(...);
        queryFlight(...);
        updateFlight(...);
        deleteFlight(...);

        createPassenger(...);
        queryPassenger(...);
        updatePassenger(...);
        deletePassenger(...);
        ...
         */

        //Declare the required JDBC objects...
        Connection connection = null;
        Statement statement = null;
//        ResultSet resultSet = null;

        try {
            //Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            //Setup the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost/efim_air?" +
                    "user=root&password=YOURPASSWORDHERE");

            //Declare statement object using the method in the connection interface
            statement = connection.createStatement();

            //--------------------------------------------------------------------------

            //JDBC UTILIZATION EXAMPLES BELOW:

            //CRUD Flights

            //CREATE

            //Commented out so new flights don't keep appearing after each run
//            createFlight(statement, 3, 2, 2, 400, 3,
//                    "2021-09-02");

            //READ
            String flightQuery = "SELECT f.id, c1.city_name AS Departure, c2.city_name AS Destination, f.gallons_required, f.date\n" +
                    "FROM flights f\n" +
                    "JOIN cities c1\n" +
                    "ON f.departure_city_id = c1.id\n" +
                    "JOIN cities c2\n" +
                    "ON f.destination_city_id = c2.id\n" +
                    "ORDER BY f.id;";

            queryFlights(statement, flightQuery);

            //UPDATE
            String flightUpdate = "UPDATE efim_air.flights SET gallons_required = 435 WHERE (id = 1);";
            updateFlights(statement, flightUpdate); //Something strange: it only updates after the the second time...why?

            //DELETE
            String flightDelete;
            deleteFlights(statement, 25); //Something strange: it only deletes after the the second time...why?

            //--------------------------------------------------------------------------
            System.out.println("\n\n--------------------------------------------------------------------------\n\n");
            //CRUD Passengers

            //CREATE
            //Commented out so new passengers don't keep appearing after each run
//            createPassenger(statement, "Efim", "Shulgin", 26);

            //READ
            String passengerQuery = "SELECT * FROM passengers";
            queryPassengers(statement, passengerQuery);

            //UPDATE
            String updatePassengerQuery = "UPDATE efim_air.passengers SET age = 43 WHERE (id = 5)";
            updatePassengers(statement, updatePassengerQuery); //Something strange: it only updates after the the second time...why?

            //DELETE
            deletePassengers(statement, 22); //Something strange: it only updates after the the second time...why?

            //EXTRA

            //Get all passengers on a particular flight

            queryPassengersOnFlight(statement, 1);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //Close the all the JDBC objects
            try {
                statement.close();
//                resultSet.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    //CRUD FLIGHT Methods

    //I use SQL naming conventions for some of the variables so it's easier to make the mental connection to SQL
    //while coding in Java

    private static void createFlight(Statement statement, int departure_city_id, int destination_city_id,
                                     int aircraft_id, int gallons_required,
                                     int pilot_id, String date) throws SQLException {
        String flightQuery = "INSERT INTO efim_air.flights" +
                " (departure_city_id, destination_city_id, aircraft_id," +
                " gallons_required, pilot_id, date)" +
                " VALUES ('" + departure_city_id +
                "', '" + destination_city_id +
                "', '" + aircraft_id +
                "', '" + gallons_required +
                "', '" + pilot_id +
                "', '" + date +
                "');";
        int createFlightResultSet = statement.executeUpdate(flightQuery);
        //Since this a void method, we don't return this int
    }

    //This method prints out whatever flights the query passed to it selected
    //As long as the columns are: id, Departure, Destination, gallons_required, date
    private static void queryFlights(Statement statement, String query) throws SQLException {

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Flight> flightArrayList= new ArrayList<Flight>();
        while (resultSet.next()) {
            Flight f = new Flight();
            f.setId(resultSet.getInt("id"));
            f.setDeparture(resultSet.getString("Departure"));
            f.setDestination(resultSet.getString("Destination"));
//            f.setAircraft(resultSet.getInt("aircraft_id"));
            f.setGallons_required(resultSet.getInt("gallons_required"));
//            f.setPilot(resultSet.getInt("pilot_id"));
            f.setDate(resultSet.getDate("date"));
            flightArrayList.add(f);
        }

        for (Flight f : flightArrayList) {
            System.out.println(f.toString());
        }
        //Close the resultSet
        resultSet.close();
    }

    //The following method updates the Flights table

    private static void updateFlights(Statement statement, String updateFlightQuery) throws SQLException {
        int updateFlights = statement.executeUpdate(updateFlightQuery);
    }

    //The following method deletes a record from the Flights table
    private static void deleteFlights(Statement statement, String deleteQuery) throws SQLException {
        int deleteFlights = statement.executeUpdate(deleteQuery);
    }
    //Overloaded method signature that allows to quickly delete flight by its id
    private static void deleteFlights(Statement statement, int flightID) throws SQLException {
        int deleteFlights = statement.executeUpdate("DELETE FROM flights WHERE (id = '" + flightID + "');");
    }

    //CRUD Passengers methods

    private static void createPassenger(Statement statement, String first_name, String last_name,
                                     int age) throws SQLException {
        String createPassengerQuery = "INSERT INTO efim_air.passengers" +
                " (first_name, last_name, age)" +
                " VALUES ('" + first_name +
                "', '" + last_name +
                "', '" + age +
                "');";
        int createPassenger = statement.executeUpdate(createPassengerQuery);
        //Since this a void method, we don't return this int
    }

    //Let's overload this method to include the meal preference data, which is NULL by default
    //in the MySQL passengers table

    private static void createPassenger(Statement statement, String first_name, String last_name,
                                        int age, String meal_preference) throws SQLException {
        String createPassengerQuery = "INSERT INTO efim_air.passengers" +
                " (first_name, last_name, age, meal_preference)" +
                " VALUES ('" + first_name +
                "', '" + last_name +
                "', '" + age +
                "', '" + meal_preference +
                "');";
        int createPassenger = statement.executeUpdate(createPassengerQuery);
        //Since this a void method, we don't return this int
    }

    private static void queryPassengers(Statement statement, String query) throws SQLException {

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Passenger> passengerArrayList= new ArrayList<Passenger>();
        while (resultSet.next()) {
            Passenger p = new Passenger();
            p.setId(resultSet.getInt("id"));
            p.setFirst_name(resultSet.getString("first_name"));
            p.setLast_name(resultSet.getString("last_name"));
//            f.setAircraft(resultSet.getInt("aircraft_id"));
            p.setAge(resultSet.getInt("age"));
//            f.setPilot(resultSet.getInt("pilot_id"));
            p.setMeal_preference(resultSet.getString("meal_preference"));
            passengerArrayList.add(p);
        }

        for (Passenger p : passengerArrayList) {
            System.out.println(p.toString());
            if (p.getMeal_preference() != null) {
                System.out.println("* " + p.getFirst_name()
                        + " " + p.getLast_name()
                        + " meal preference: "
                        + p.getMeal_preference());
            }
        }
        //Close the resultSet
        resultSet.close();
    }

    //The following method updates the passengers table

    private static void updatePassengers(Statement statement, String updatePassengerQuery) throws SQLException {
        int updatePassengers = statement.executeUpdate(updatePassengerQuery);
    }

    //The following method deletes a record from the passengers table
    private static void deletePassengers(Statement statement, String deleteQuery) throws SQLException {
        int deletePassengers = statement.executeUpdate(deleteQuery);
    }

    //Overloaded method signature that allows to quickly delete a passenger by their id
    private static void deletePassengers(Statement statement, int passengerID) throws SQLException {
        int deleteFlights = statement.executeUpdate("DELETE FROM passengers WHERE (id = '" + passengerID + "');");
    }

    //EXTRA methods

    private static void queryPassengersOnFlight(Statement statement, int flightID) throws SQLException {

        String query = "SELECT * FROM passengers p\n" +
                "JOIN tickets t\n" +
                "ON p.id = t.passenger_id\n" +
                "JOIN flights f\n" +
                "ON t.flight_id = f.id\n" +
                "WHERE f.id = '" + flightID + "';";

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Passenger> passengerArrayList= new ArrayList<Passenger>();
        while (resultSet.next()) {
            Passenger p = new Passenger();
            p.setId(resultSet.getInt("id"));
            p.setFirst_name(resultSet.getString("first_name"));
            p.setLast_name(resultSet.getString("last_name"));
//            f.setAircraft(resultSet.getInt("aircraft_id"));
            p.setAge(resultSet.getInt("age"));
//            f.setPilot(resultSet.getInt("pilot_id"));
            p.setMeal_preference(resultSet.getString("meal_preference"));
            passengerArrayList.add(p);
        }

        System.out.println("\n---------\nPassengers on flight id: " + flightID);
        for (Passenger p : passengerArrayList) {
            System.out.println(p.toString());
            if (p.getMeal_preference() != null) {
                System.out.println("* " + p.getFirst_name()
                        + " " + p.getLast_name()
                        + " meal preference: "
                        + p.getMeal_preference());
            }
        }
        //Close the resultSet
        resultSet.close();
    }
}

