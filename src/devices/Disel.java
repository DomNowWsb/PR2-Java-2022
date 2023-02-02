package devices;

public class Disel extends Car{
    public Disel(String producer, String model, Integer yearOfProduction, String color, double value) {
        super(producer, model, yearOfProduction, color, value);
    }
    public void refuel(){
        System.out.println("Refueling disel");
    }
}
