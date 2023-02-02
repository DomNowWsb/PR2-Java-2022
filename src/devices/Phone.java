package devices;

public class Phone {
    String model;
    String producer;
    String colour = "Black";
    Boolean isAndroid = true;
    private Double value;
    public Phone(String model, String producer, double value){
        this.model = model;
        this.producer = producer;
        this.value = value;
    }
    public String toString(){
        return "Producer: " + producer + " Model: " + model + " Colour: " + colour + " isAndroid: " + isAndroid;
    }
}
