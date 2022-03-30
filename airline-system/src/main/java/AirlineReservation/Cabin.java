package AirlineReservation;

public class Cabin {
    private String cabinClass;

    public Cabin(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    @Override
    public String toString() {
        return "Cabin{" +
                "cabinClass='" + cabinClass + '\'' +
                '}';
    }
}
