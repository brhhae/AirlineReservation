package AirlineReservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Populate {

    // array of flights that are scheduled

    Flight[] arrayOfFlights =
            {new Flight("1400", "TIA", "IST", "01-03-2022",
                    "02-03-2022", "12:00", "2:00",400.00,108),
                    new Flight("1401", "CDG", "MLE", "02-03-2022",
                            "08-04-2022", "11:00", "18:00",600.50,108),
                    new Flight("1402", "KBL", "VCE", "03-03-2022",
                            "04-03-2022", "18:00", "19:00",200.30,108),
                    new Flight("1403", "MLE", "CBR", "03-04-2022",
                            "04-04-2022", "19:00", "21:00",500.50,108),
                    new Flight("1404", "PVG", "LHR", "03-06-2022",
                            "04-06-2022", "09:00", "10:00",1000,108),
                    new Flight("1405", "VCE", "IST", "03-07-2022",
                            "05-07-2022", "21:00", "23:00",160.10,108),
                    new Flight("1406", "JFK", "PVG", "03-07-2022",
                            "04-07-2022", "01:00", "06:00",2000,108),
                    new Flight("1407", "LHR", "JFK", "03-09-2022",
                            "04-09-2022", "22:00", "23:00",4000.50,108),
                    new Flight("1408", "KBL", "CBR", "03-10-2022",
                            "04-10-2022", "20:00", "23:00",150.10,108),
                    new Flight("1409", "PVG", "JFK", "23-11-2022",
                            "24-11-2022", "09:00", "10:00",5000.70,108),
            };

    // array of cabins that exist
    Cabin[] arrayOfCabins =
            {new Cabin("Economy"),
                    new Cabin("Business")};

    // array of airports that exist

    public void createAirports() {
        ArrayList<String> airports = new ArrayList();

        Airport[] arrayOfAirports = {new Airport("TIA", "Tirane","Albania"),
                new Airport("JFK", "New York","USA"),
                new Airport("IST", "Istanbul","Turkey"),
                new Airport("KBL", "Kabul","Afghanistan"),
                new Airport("VCE", "Venice","Italy"),
                new Airport("LHR", "London","UK"),
                new Airport("CDG", "Paris","France"),
                new Airport("PVG", "Shanghai","China"),
                new Airport("CBR", "Canberra","Australia"),
                new Airport("MLE", "Male","Maldives")
        };

        for(Airport airport : arrayOfAirports){
            System.out.println(airport);
        }
    }

    // this method displays the list of departure airports for the user to pick and prints out the results vertically
    public void displayFrom(){
        List<String> resultFrom = Arrays.stream(arrayOfFlights).map(Flight::getDeparture).toList();
        resultFrom.forEach(System.out::println);
    }

    // this method displays the list of arrival airports for the user to pick and prints out the results vertically
    public void displayTo(){
        List<String> resultTo = Arrays.stream(arrayOfFlights).map(Flight::getArrival).toList();
        resultTo.forEach(System.out::println);
    }

    // this method displays the list of dates for the user to pick and prints out the results vertically
    public void displayDate() {
        List<String> result = Arrays.stream(arrayOfFlights).map(Flight::getDepDate).toList();
        result.forEach(System.out::println);
    }

    // displays the list of cabins to the user to pick and prints out the results vertically
    public void createCabin(){
        List<String> cabins = Arrays.stream(arrayOfCabins).map(Cabin::getCabinClass).toList();
        cabins.forEach(System.out::println);
    }

    // filters the list of scheduled flights by using inputs from the user
    // checks if flights exist for departure and arrival airports as well as the departure date
    public List checkFlight(String from, String to, String depDate){
        List<Flight> result = Arrays.stream(arrayOfFlights).filter(c -> c.getDeparture().equals(from) && c.getArrival().equals(to) && c.getDepDate().equals(depDate)).toList();
        return result;
    }

    // filters the list of scheduled flights for searching ticket module
    // checks if flights exist for departure and arrival airports as well as enough capacity
    public List checkScheduledFlights(String from, String to){
        List<Flight> availableFlights = Arrays.stream(arrayOfFlights).filter(c -> c.getDeparture().equals(from) && c.getArrival().equals(to) && c.getCapacity() > 0).toList();
        return availableFlights;
    }



}
