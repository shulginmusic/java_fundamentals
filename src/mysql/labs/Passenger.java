package mysql.labs;
//I use SQL naming conventions for some of the variables so it's easier to make the mental connection to SQL
//while coding in Java
public class Passenger {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String meal_preference;

    public Passenger() {
    }

    public Passenger(int id, String first_name, String last_name, int age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    //Constructor with meal preference, which is NULL by default


    public Passenger(int id, String first_name, String last_name, int age, String meal_preference) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.meal_preference = meal_preference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMeal_preference() {
        return meal_preference;
    }

    public void setMeal_preference(String meal_preference) {
        this.meal_preference = meal_preference;
    }

    @Override
    //No meal preference here because it is optional
    //You can use the getMeal_preference method instead
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                '}';
    }
}
