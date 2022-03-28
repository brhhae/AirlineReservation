package AirlineReservation;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Where do you want to explore?");
        System.out.println();
        System.out.println("1.Book a flight");
        System.out.println("2.Search Ticket");
        System.out.println("3.View Ticket");
        System.out.println();
       // System.out.println("4.Sign up");

        Scanner input=new Scanner(System.in);
        Populate airport=new Populate();

        int choice= input.nextInt();

        if (choice == 1){
            System.out.println("Please enter the codes only!");
            System.out.println("From:");
            airport.createAirports();
            String from = input.next();
            System.out.println("To: ");
            airport.createAirports();
            String to = input.next();
            while(from.equals(to)){
                System.out.println("Are you Crazy!" +
                        "what the hell is wrong with you????");
                System.out.println("Please select again");
                to = input.next();
            }
            System.out.println("Please select the date:");
            airport.createFlights();


        }
    }


}
