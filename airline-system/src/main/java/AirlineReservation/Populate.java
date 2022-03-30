package AirlineReservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Populate {
    Flight[] arrayOfFlights =
            {new Flight("1400", "TIA", "IST", "01-03-2022",
                    "02-03-2022", "12:00", "2:00",400.00),
                    new Flight("1401", "CDG", "MLE", "02-03-2022",
                            "08-04-2022", "11:00", "18:00",600.50),
                    new Flight("1402", "KBL", "VCE", "03-03-2022",
                            "04-03-2022", "18:00", "19:00",200.30),
                    new Flight("1403", "MLE", "CBR", "03-04-2022",
                            "04-04-2022", "19:00", "21:00",500.50),
                    new Flight("1404", "PVG", "LHR", "03-06-2022",
                            "04-06-2022", "09:00", "10:00",1000),
                    new Flight("1405", "VCE", "IST", "03-07-2022",
                            "05-07-2022", "21:00", "23:00",160.10),
                    new Flight("1406", "JFK", "PVG", "03-07-2022",
                            "04-07-2022", "01:00", "06:00",2000),
                    new Flight("1407", "LHR", "JFK", "03-09-2022",
                            "04-09-2022", "22:00", "23:00",4000.50),
                    new Flight("1408", "KBL", "CBR", "03-10-2022",
                            "04-10-2022", "20:00", "23:00",150.10),
                    new Flight("1409", "PVG", "JFK", "23-11-2022",
                            "24-11-2022", "09:00", "10:00",5000.70),
            };

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


//
//        for (int i = 0; i < airports.size(); i++) {
//            System.out.println(airports.get(i));
//        }
    }
    public void displayFrom(){
        List<String> resultFrom = Arrays.stream(arrayOfFlights).map(Flight::getDeparture).toList();
        resultFrom.forEach(System.out::println);
    }
    public void displayTo(){
        List<String> resultTo = Arrays.stream(arrayOfFlights).map(Flight::getArrival).toList();
        resultTo.forEach(System.out::println);
    }

    public void displayDate() {

        //List<Flight> flightsToList = new ArrayList<>(Arrays.asList(arrayOfFlights));


        List<String> result = Arrays.stream(arrayOfFlights).map(Flight::getDepDate).toList();
        result.forEach(System.out::println);


        //for(Flight flight : arrayOfFlights){
        //    System.out.println(flight);
       // }
    }

    public void createCabin(){
        Cabin[] arrayOfCabins =
                {new Cabin("Economy"),
                new Cabin("Business")};
        List<Cabin> cabins = Arrays.stream(arrayOfCabins).toList();
        for (Cabin cabin : cabins) {
            System.out.println(cabin);
        }


    }

    public List checkFlight(String from, String to, String depDate){
        List<Flight> result = Arrays.stream(arrayOfFlights).filter(c -> c.getDeparture().equals(from) && c.getArrival().equals(to) && c.getDepDate().equals(depDate)).toList();

        return result;
    }



}
