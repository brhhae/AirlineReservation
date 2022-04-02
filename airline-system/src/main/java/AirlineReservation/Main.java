package AirlineReservation;
import java.util.*;

public class Main {
    static Populate airport=new Populate();
    static Scanner input=new Scanner(System.in);
    static Passenger passenger;
    static BookFlight bookFlight = new BookFlight();
    static Calculate calculate = new Calculate();

    //static Cabin cabin = new Cabin();
    static String classInput;
    static double luggagePrice = 0.00;
    static double classPrice = 0.00;
    static double totalPrice;
    static double basePrice;
    static int capacity;
    static List<Flight> result;
    static String from;
    static String to;

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
        System.out.println("Press 0 to exit.");
        System.out.println();

        int choice = getChoice();
        switch (choice) {
            case 1 -> bookFlight();
            case 2 -> searchTicket();
            case 3 -> viewTicket();
            default -> System.exit(0);
        }
    }

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
    public static void bookFlight(){
        System.out.println("Book Flight Details");
        selectDestination();
        System.out.println("Please select the date:");
        airport.displayDate();
        String depDateInput = input.next();

        System.out.println("Please select the class:");
        airport.createCabin();
        classInput = input.next();
        result = airport.checkFlight(from, to, depDateInput);
        if (result.size() != 0){
            System.out.println("Available flights for " + from + " " + to + " " + depDateInput + ":" + result);
        }
        else {
            System.out.println("There are no flights available!");
            bookFlight();
            return;
        }


        if(confirmFlight().equals("Y")){

        }else if(confirmFlight().equals("N")){
            bookFlight();
            return;
        }else{
            System.out.println("Undefined input. Please enter Y or N to confirm!");
            confirmFlight();

        }

        if(result.get(0).getCapacity() > 0) {
            bookFlight.setFlightNo(result.get(0).getNumber());
        }else{
            System.out.println("No seats available for this flight!");
            bookFlight();
            return;
        }

        finalizeBooking();


    }

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

        System.out.println("Please select the class:");
        airport.createCabin();
        classInput = input.next();
        bookFlight.setFlightNo(result.get(0).getNumber());
        finalizeBooking();

    }

    public static void viewTicket(){
        printFlightDetails();
        startPage();

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
        if (luggage > 1){
            luggagePrice = calculate.calculateLuggage(luggage);
            System.out.println("Extra luggage fee is: " + luggagePrice);
        }
        System.out.println("Class: " + classInput );
        checkClassFee();
        passenger = new Passenger(id,name, surname, address, phone, luggage, classInput, email, billingAddress);
        checkTotalFee();

    }
    public static String confirmFlight(){
        System.out.println("Confirm flight information? Y/N");
        return getUserInput();
    }
    public static String confirmChoice(){
        return getUserInput();
    }

    private static String getUserInput(){
        return input.next();
    }

    private static void checkClassFee(){
        if(!classInput.equals("Economy") && !classInput.equals("Business")){
            System.out.println("Class does not exist. You will be assigned to Economy!");
            classInput = "Economy";
        }if (classInput.equals("Business")){
            classPrice = calculate.calculateClassFee(classInput);
            System.out.println("The class fee is: " + classPrice);
        }
    }

    private static void checkTotalFee(){
        basePrice = result.get(0).getBasePrice();
        totalPrice = calculate.calculateTotalFee(luggagePrice,classPrice,basePrice);
        System.out.println("Total flight fee: " + totalPrice);
    }

    private static void printFlightDetails(){
        System.out.println("Your flight details: ");
        System.out.println(bookFlight.toString());
    }

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
            passengerDetails();
        }
        else{
            System.out.println("Undefined input. Please enter Y or N to confirm!");
            confirmFlight();
        }
    }

}
