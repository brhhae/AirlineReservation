package AirlineReservation;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Main {
    static Populate airport=new Populate();
    static Scanner input=new Scanner(System.in);
    static Passenger passenger;
    static BookFlight bookFlight;
    //static Cabin cabin = new Cabin();
    static String classInput;
    public static void main(String[] args) {
      startPage();
    }

    public static void startPage(){
        System.out.println("Hello!");
        System.out.println("Where do you want to explore?");
        System.out.println();
        System.out.println("1.Book a flight");
        System.out.println("2.Search Ticket");
        System.out.println("3.View Ticket");
        System.out.println();
        // System.out.println("4.Sign up");

        int choice= input.nextInt();

        if (choice == 1){
            bookFlight();


        }
    }
    public static void bookFlight(){
        System.out.println("Book Flight Details");
        System.out.println("From:");
        airport.displayFrom();
        String from = input.next();
        System.out.println("To: ");
        airport.displayTo();
        String to = input.next();
        while(from.equals(to)){
            //System.out.println("Are you Crazy!" +"what the hell is wrong with you????");
            System.out.println("Please select again");
            to = input.next();
        }
        System.out.println("Please select the date:");
        airport.displayDate();
        String depDateInput = input.next();

        System.out.println("Please select the class:");
        airport.createCabin();
        classInput = input.next();
        List<Flight> result = airport.checkFlight(from, to, depDateInput);
        if (result.size() != 0){
            System.out.println("Available flights for " + from + " " + to + " " + depDateInput + ":" + result);
        }
        else{
            System.out.println("There are no flights available!");
            bookFlight();
        }


        if(confirmFlight().equals("Y")){
            bookFlight.setFlightNo(result.get(0).getNumber());

        }else if(confirmFlight().equals("N")){
            bookFlight();
        }else{
            System.out.println("Undefined input. Please enter Y or N to confirm!");
            confirmFlight();

        }

        passengerDetails();

        if(confirmFlight().equals("Y")){

        }else if(confirmFlight().equals("N")){
            passengerDetails();
        }
        else{
            System.out.println("Undefined input. Please enter Y or N to confirm!");
            confirmFlight();
        }


    }


    private static void passengerDetails(){
        System.out.println("Please enter Passenger information: ");
        System.out.println("ID:");
        String id = input.next();
        System.out.println("Name: ");
        String name = input.next();
        System.out.println("Surname:");
        String surname = input.next();
        System.out.println("Email: ");
        String email = input.next();
        System.out.println("Phone number: ");
        String phone = input.next();
        System.out.println("Address: ");
        String address = input.next();
        System.out.println("Billing address: ");
        String billingAddress = input.next();
        System.out.println("How many luggages will you carry? Extra luggage fee of $20 will apply for more than 1 luggage.");
        int luggage = input.nextInt();
        System.out.println("Class: " + classInput );
        passenger = new Passenger(id,name, surname, address, phone, luggage, classInput, email, billingAddress);
    }
    public static String confirmFlight(){
        System.out.println("Confirm flight information? Y/N");
        return getUserInput();
    }

    private static String getUserInput(){
        return input.next();
    }
}
