package AirlineReservation;

public class Passenger {
    private String name;
    private String surname;
    private String address;
    private String phone;
    private int luggage;
    private char cabin;
    private String email;

    public Passenger(String name, String surname, String address, String phone, int luggage, char cabin , String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.luggage = luggage;
        this.cabin = cabin;
        this.email=email;
    }

    public void createPassenger(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public char getCabin() {
        return cabin;
    }

    public void setCabin(char cabin) {
        this.cabin = cabin;
    }

}
