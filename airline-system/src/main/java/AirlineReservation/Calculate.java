package AirlineReservation;

public class Calculate {

    public Calculate(){

    }

    public double calculateLuggage(int luggage){
       return (luggage-1) * 20.00;
    }
    public double calculateClassFee(String classInput){
        if(classInput.equals("Business")){
            return 150.00;
        }else{
            return 1;
        }
    }

    public double calculateTotalFee(double luggagePrice, double classPrice, double basePrice){
        return luggagePrice + classPrice + basePrice;
    }
}
