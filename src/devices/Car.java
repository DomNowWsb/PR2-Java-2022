package devices;

public class Car extends Devices{
    private Double mileage = 0.0;

    public Car(String producer, String model, Integer yearOfProduction,String color, double value) {
        super(producer, model, yearOfProduction, color, value);
    }
    public String toString(){
        return "Producer: " + producer + " Model: " + model + " Colour: " + color + " Mileage: " + mileage;
    }
    public Double getValue(){
        return super.getValue();
    }
    @Override
    public void turnOn() {
        System.out.println("Przekręcam kluczyk");
        System.out.println("Samochod odpalil");
        this.isOn = true;
    }
}
