package AirlineReservation;

import java.util.ArrayList;

public class Populate {

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
    public void createFlights() {
        Flight[] arrayOfFlights =
                {new Flight("1456", "TIA", "IST", "28-03-2022", "17-04-2022", "12:00", "2:00"),
                new Flight("1457", "CDG", "MLE", "30-03-2022", "08-04-2022", "11:00", "18:00")
                };

        for(Flight flight : arrayOfFlights){
            System.out.println(flight);
        }
    }
}
