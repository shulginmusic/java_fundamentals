package labs_examples.enumerations.labs;

import java.util.Scanner;

public class TransportController {
    public static void main(String[] args) {
        System.out.println("Welcome! Which transportation do you need?" +
                "\nI will tell you how much fuel you'll end up burning...");

        System.out.println("Here are the options: ");

        for (Transportation t : Transportation.values()) {
            System.out.println(t);
        }

        Scanner scanner = new Scanner(System.in);


        Transportation t = null;


        System.out.print("Your choice: ");
        String reply = scanner.next();
        switch (reply) {
            case "CAR":
                t = Transportation.CAR;
                break;
            case "SCOOTER":
                t = Transportation.SCOOTER;
                break;
            case "BOAT":
                t = Transportation.BOAT;
                break;
            case "AIRPLANE":
                t = Transportation.AIRPLANE;
                break;
            default:
                System.out.println("Wrong option");
                break;
                //t remains == null
        }


        System.out.println("You have chosen: " + t);
        System.out.println("Your MPG is approximately " + t.getMpg());

    }
}
