package mysql.labs;

import java.sql.Date;

//I use SQL naming conventions for some of the variables so it's easier to make the mental connection to SQL
//while coding in Java

public class Flight {

    private int id;
    private String departure;
    private String destination;
    private Aircraft aircraft;
    private int gallons_required;
    private Pilot pilot;
    private Date date;

    public Flight() {

    }

    //Simple constructor without the Aircraft / Pilot objects

    public Flight(int id, String departure, String destination, int gallons_required, Date date) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.gallons_required = gallons_required;
        this.date = date;
    }

    //Constructor including Aircraft / Pilot

    public Flight(int id, String departure, String destination,
                  Aircraft aircraft, int gallons_required, Pilot pilot, Date date) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.aircraft = aircraft;
        this.gallons_required = gallons_required;
        this.pilot = pilot;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public int getGallons_required() {
        return gallons_required;
    }

    public void setGallons_required(int gallons_required) {
        this.gallons_required = gallons_required;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Removed the details of the Aircraft and Pilot object from the toString() method (for now)
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", gallons_required=" + gallons_required +
                ", date=" + date +
                '}';
    }
}
