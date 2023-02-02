package devices;
import interfaces.Sellable;
public abstract class Devices implements Sellable {

    final String producer;
    final String model;
    final Integer yearOfProduction;
    String color;
    Boolean isOn = false;
    private Double value = 0.0;

    public Devices(String producer, String model, Integer yearOfProduction, String color, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.color = color;
        this.value = value;
    }
    public Devices(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }
    public abstract void turnOn();
    public Double getValue(){
        return this.value;
    }
    public String toString(){
        return "Producer: " + producer + " Model: " + model + " Year of production: " + yearOfProduction;
    }
}
