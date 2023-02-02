package devices;

public class LPG extends Car{

    public LPG(String producer, String model, Integer yearOfProduction, String color, double value) {
        super(producer, model, yearOfProduction, color, value);
    }
    public void refuel(){
        System.out.println("Refueling LPG");
    }
}
