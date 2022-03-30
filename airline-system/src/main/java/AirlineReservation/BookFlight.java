package AirlineReservation;

public class BookFlight {
        private String flightNo;
        private double price;
        private int cabinID;
        private Passenger passenger;

    public BookFlight(String flightNo, double price,int cabinID, Passenger passenger) {
        this.flightNo = flightNo;
        this.price = price;
        this.cabinID= cabinID;
        this.passenger=passenger;
    }

    public int getCabinID() {
        return cabinID;
    }

    public void setCabinID(int cabinID) {
        this.cabinID = cabinID;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
