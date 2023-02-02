package devices;

public class Car {
    String model;
    String producer;
    String colour = "Black";
    private Double value;
    private Double mileage = 0.0;

    public Car(String model, String producer, double value){
        this.model = model;
        this.producer = producer;
        this.value = value;
    }
    public String toString(){
        return "Producer: " + producer + " Model: " + model + " Colour: " + colour + " Mileage: " + mileage;
    }
    public Double getValue(){
        return this.value;
    }
}
