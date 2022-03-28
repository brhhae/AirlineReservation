package AirlineReservation;

public class Order {
    private  int number;
    private int price;
    private String created;
    private String payment;
    private String getPaymentMade;
    private String billingAddress;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getGetPaymentMade() {
        return getPaymentMade;
    }

    public void setGetPaymentMade(String getPaymentMade) {
        this.getPaymentMade = getPaymentMade;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Order(int number, int price, String created, String payment, String getPaymentMade, String billingAddress) {
        this.number = number;
        this.price = price;
        this.created = created;
        this.payment = payment;
        this.getPaymentMade = getPaymentMade;
        this.billingAddress = billingAddress;


    }
}
