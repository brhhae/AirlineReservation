package AirlineReservation;

public class Calculate {

    public Calculate(){

    }

    // calculates luggage fee by taking the number of luggages as parameter
    // subtracts 1 from the parameter because the first luggage is included in the base price of the flight
    // multiplies by 20 because that's the extra fee
    public double calculateLuggage(int luggage){
       return (luggage-1) * 20.00;
    }

    // assigns an extra fee for business class
    // returns 1 if the input equals anything else
    public double calculateClassFee(String classInput){
        if(classInput.equals("Business")){
            return 150.00;
        }else{
            return 1;
        }
    }

    // calculates total fee of the flight
    public double calculateTotalFee(double luggagePrice, double classPrice, double basePrice){
        return luggagePrice + classPrice + basePrice;
    }
}
