package AirlineReservation;

public class BookFlight {
        private String name;
        private int price;
        private String created;
        private String payment;
        private int paymentMade;
        private char billingAddress;

    public BookFlight(String name, int price, String created, String payment, int paymentMade, char billingAddress) {
        this.name = name;
        this.price = price;
        this.created = created;
        this.payment = payment;
        this.paymentMade = paymentMade;
        this.billingAddress = billingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPaymentMade() {
        return paymentMade;
    }

    public void setPaymentMade(int paymentMade) {
        this.paymentMade = paymentMade;
    }

    public char getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(char billingAddress) {
        this.billingAddress = billingAddress;
    }
}
