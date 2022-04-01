package AirlineReservation;

public class Passenger {
    private String id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private int luggage;
    private String cabin;
    private String email;
    private String billingAddress;

    public Passenger(String id,String name, String surname, String address, String phone, int luggage, String cabin , String email, String billingAddress) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.luggage = luggage;
        this.cabin = cabin;
        this.email=email;
        this.billingAddress= billingAddress;
    }

    public Passenger() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCabin(){ return cabin;}

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
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

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", luggage=" + luggage +
                ", cabin='" + cabin + '\'' +
                ", email='" + email + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }
}
