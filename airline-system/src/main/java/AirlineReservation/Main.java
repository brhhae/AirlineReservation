package AirlineReservation;
import java.util.*;

public class Main {
    // initialize objects
    static Populate airport=new Populate(); //creates a Populate object to use the methods of that class
    static Scanner input=new Scanner(System.in);
    static Passenger passenger; // initializes a passenger object to store passenger information
    static BookFlight bookFlight = new BookFlight(); // creates a bookflight object to use the methods of that class
    static Calculate calculate = new Calculate(); // creates a Calculate object to use the methods of that class

    // initialize variables here to use them globally in multiple methods
    static String classInput;
    static double luggagePrice = 0.00;
    static double classPrice = 0.00;
    static double totalPrice;
    static double basePrice;
    static int capacity;
    static List<Flight> result;  // stores the flight information selected by the user
    static String from;
    static String to;

    //main method contains the method that initializes our application
    public static void main(String[] args) {
      startPage();
    }

    // the method that contains our application
    public static void startPage(){
        System.out.println("Hello!");
        System.out.println("Where do you want to explore?");
        System.out.println();
        System.out.println("1.Book a flight");
        System.out.println("2.Search Ticket");
        System.out.println("3.View Ticket");
        System.out.println();
        System.out.println("Press 0 to exit.");
        System.out.println();

        // the switch case is used instead of if, else if because it handles every case neater. There is also a default
        // case which handles any input that's valid (an int), but not the input we want (1,2 or 3)
        // the getChoice method will prevent the user to enter a non int input (will explain how it works below)
        int choice = getChoice();
        switch (choice) {
            case 1 -> bookFlight();
            case 2 -> searchTicket();
            case 3 -> viewTicket();
            default -> System.exit(0);
        }
    }

    // this method is used to check if the input entered is valid. Because if the user enters a letter instead of 1,2 or 3
    // Java will give an error and terminate the program. In order to avoid this InputMismatch exception, we use try and catch blocks
    // to catch this error. If the input is a valid number, then the method will return that correct input and it will save it
    // in the switch case. If the input is not valid, then Java will throw an exception and it will ask for the input again
    // this method will repeat until the input is valid, in other words while(true)
    public static int getChoice(){
        while(true){
            try {
                return input.nextInt();
            }catch(InputMismatchException e){
                input.next();
                System.out.println("Invalid input! Please select 1 to book a flight, 2 to search for tickets, 3 to view ticket or 0 to exit!");
            }
        }
    }

    // this method allows the user to book a flight.
    public static void bookFlight(){
        System.out.println("Book Flight Details");
        selectDestination();
        System.out.println("Please select the date:");
        airport.displayDate();
        String depDateInput = input.next();

        // ask the user to select a class
        selectClass();
        classInput = input.next();

        // result stores the list that the checkFlight method returns
        result = airport.checkFlight(from, to, depDateInput);

        // if the list is not empty, then display it to the user
        // if the list is empty, then inform the user and ask them to select again
        if (result.size() != 0){
            System.out.println("Available flights for " + from + " " + to + " " + depDateInput + ":" + result);
        }
        else {
            System.out.println("There are no flights available!");
            bookFlight();
            return;
        }

        // ask the user if they want to select the flight
        if(confirmFlight().equals("Y")){

        }else if(confirmFlight().equals("N")){
            bookFlight();
            return;
        }else{
            System.out.println("Undefined input. Please enter Y or N to confirm!");
            confirmFlight();
        }

        // after the user confirms their flight, check if there is capacity on the plane to have this passenger
        // if there is enough capacity, then set the flight number and confirm it
        // if there isn't capacity, inform the user and return to bookFLight method
        if(result.get(0).getCapacity() > 0) {
            bookFlight.setFlightNo(result.get(0).getNumber());
        }else{
            System.out.println("No seats available for this flight!");
            bookFlight();
            return;
        }

        // this method is the final stage of booking, stored in a method because we use it in search ticket too
        finalizeBooking();
    } // end of the bookFlight method

    // this method allows the user to search for available flights just by Departure and Destination
    public static void searchTicket(){
        selectDestination();
        result = airport.checkScheduledFlights(from, to);
        if (result.size() != 0){
            System.out.println("Available flights for " + from + " " + to + " " + ":" + result);
        }
        else {
            System.out.println("There are no flights available!");
            searchTicket();
            return;
        }

        System.out.println("Would you like to select this flight?");
        String answer = input.next();
        if(answer.equals("Y")){

        }else if(answer.equals("N")){
            searchTicket();
        }else{
            System.out.println("Undefined input. Please enter Y or N to confirm!");
            confirmChoice();
        }

        // ask the user to select the class because they didn't do it until now
        selectClass();
        classInput = input.next();

        // set the flight number and store it in booked flights class
        bookFlight.setFlightNo(result.get(0).getNumber());
        // call the method that asks for passenger information
        finalizeBooking();
    }

    // this method allows the user to view their ticket information and redirects them to the start page
    public static void viewTicket(){
        printFlightDetails();
        startPage();
    }

    // this method takes passenger information as input
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

        if (luggage > 1){
            luggagePrice = calculate.calculateLuggage(luggage);
            System.out.println("Extra luggage fee is: " + luggagePrice);
        }

        System.out.println("Class: " + classInput );
        checkClassFee(); //calls the method to display class fee

        // save passenger info in Passenger class because we will access it later
        passenger = new Passenger(id,name, surname, address, phone, luggage, classInput, email, billingAddress);
        checkTotalFee(); // calls the method to display total fee of the flight
    }

    // this method contains asks for the input to confirm the flight (used in multiple places)
    public static String confirmFlight(){
        System.out.println("Confirm flight information? Y/N");
        return getUserInput();
    }

    // similar to confirm flight, but asks the user to confirm choice
    public static String confirmChoice(){
        return getUserInput();
    }

    private static String getUserInput(){
        return input.next();
    }

    // check if there is an extra class fee and assigns the passenger to Economy if they entered the wrong input
    private static void checkClassFee(){
        if(!classInput.equals("Economy") && !classInput.equals("Business")){
            System.out.println("Class does not exist. You will be assigned to Economy!");
            classInput = "Economy";
        }if (classInput.equals("Business")){
            classPrice = calculate.calculateClassFee(classInput);
            System.out.println("The class fee is: " + classPrice);
        }
    }

    // checks the total fee by calling the calculate method and displays it to the user
    private static void checkTotalFee(){
        basePrice = result.get(0).getBasePrice();
        totalPrice = calculate.calculateTotalFee(luggagePrice,classPrice,basePrice);
        System.out.println("Total flight fee: " + totalPrice);
    }

    // method that shows the flight details to the user
    private static void printFlightDetails(){
        System.out.println("Your flight details: ");
        System.out.println(bookFlight.toString());
    }
    // method that allows the user to select departure and arrival airports (it's a separate method because it's used in multiple places)
    private static void selectDestination(){
        System.out.println("From:");
        airport.displayFrom();
        from = input.next();
        System.out.println("To: ");
        airport.displayTo();
        to = input.next();
        while(from.equals(to)){
            System.out.println("Please select again");
            to = input.next();
        }
    }

    // calls the method to display available cabins (separate method because we use it in multiple places)
    private static void selectClass(){
        System.out.println("Please select the class:");
        airport.createCabin();
    }

    // this method stores every information when the user confirms it
    // final step of booking where we set the values if the user confirms their flight.
    // we also decrease the capacity of the plane whenever a flight is booked and return to the start page
    private static void finalizeBooking(){

        passengerDetails();

        if(confirmFlight().equals("Y")){
            bookFlight.setCabin(classInput);
            bookFlight.setPrice(totalPrice);
            bookFlight.setPassenger(passenger);
            capacity = result.get(0).getCapacity();
            result.get(0).setCapacity(capacity--);
            printFlightDetails();
            startPage();

        }else if(confirmFlight().equals("N")){
            finalizeBooking();
        }
        else{
            System.out.println("Undefined input. Please enter Y or N to confirm!");
            confirmFlight();
        }
    }

}
