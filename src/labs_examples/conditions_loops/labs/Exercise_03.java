package labs_examples.conditions_loops.labs;
import java.util.Scanner;


/**
 * Conditions and Loops Exercise 3: Months of the year
 *
 *      Take in a number from the user and print "January", "February", ... "December", or "Other"
 *      if the number from the user is 1, 2,... 12, or other respectively. Use a "switch" statement.
 *
 */
//How do you use while loop here??
public class Exercise_03 {

    public static void main(String[] args) {
        String month = getMonth();
        System.out.println(month);
    }

    public static int getNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number and I will give you"
                + " the month of the year");
        int num = scanner.nextInt();
        // System.out.println("test " + num);
        return num;

    }

    public static String getMonth() {
        int num = getNum();
        String month;
        switch (num) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "Other";
        }
        return month;
    }
}

