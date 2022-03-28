package AirlineReservation;

public class Flight {
    private String number;
    private String departure;
    private String arrival;
    private String depDate;
    private String arrDate;
    private String depTime;
    private String arrTime;

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public Flight(String number, String departure, String arrival, String depDate, String arrDate, String depTime, String arrTime) {
        this.number = number;
        this.departure = departure;
        this.arrival = arrival;
        this.depDate = depDate;
        this.arrDate = arrDate;
        this.depTime = depTime;
        this.arrTime = arrTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number='" + number + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", depDate='" + depDate + '\'' +
                ", arrDate='" + arrDate + '\'' +
                ", depTime='" + depTime + '\'' +
                ", arrTime='" + arrTime + '\'' +
                '}';
    }
}

