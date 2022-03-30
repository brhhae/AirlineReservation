package AirlineReservation;

public class Cabin {
    private String E;
    private String B;

    public Cabin(String e, String b) {
        E = e;
        B = b;
    }


    public String getE() {
        return E;
    }

    public String getB() {
        return B;
    }

    public void setE(String e) {
        E = e;
    }

    public void setB(String b) {
        B = b;
    }

    @Override
    public String toString() {
        return "Cabin{" +
                "E='" + E + '\'' +
                ", B='" + B + '\'' +
                '}';
    }
}
