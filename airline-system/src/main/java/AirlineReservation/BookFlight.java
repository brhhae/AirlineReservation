package AirlineReservation;

public class BookFlight {
        private String flightNo;
        private double price;
        private String cabin;
        private Passenger passenger;

        public BookFlight() {

        }

    public BookFlight(String flightNo, double price, String cabin, Passenger passenger) {
        this.flightNo = flightNo;
        this.price = price;
        this.cabin= cabin;
        this.passenger=passenger;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
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

    @Override
    public String toString() {
        return "BookFlight{" +
                "flightNo='" + flightNo + '\'' +
                ", price=" + price +
                ", cabin='" + cabin + '\'' +
                ", passenger=" + passenger.toString() +
                '}';
    }
}
