package devices;

public class Electric extends Car{
    public Electric(String producer, String model, Integer yearOfProduction, String color, double value) {
        super(producer, model, yearOfProduction, color, value);
    }
    public void refuel(){
        System.out.println("Refueling electric");
    }
}
