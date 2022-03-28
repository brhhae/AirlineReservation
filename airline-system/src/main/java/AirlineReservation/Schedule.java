package AirlineReservation;

public class Schedule {
    private int number;
    private String luggage;
    private String extraLuggage;
    private String cabin;

    public Schedule(int number, String luggage, String extraLuggage, String cabin) {
        this.number = number;
        this.luggage = luggage;
        this.extraLuggage = extraLuggage;
        this.cabin = cabin;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getExtraLuggage() {
        return extraLuggage;
    }

    public void setExtraLuggage(String extraLuggage) {
        this.extraLuggage = extraLuggage;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }
}
