package devices;

public class Phone extends Devices {
    String colour = "Black";
    private Boolean isAndroid = true;
    private Double screenSize;

    public Phone(String producer, String model, Integer yearOfProduction, Boolean isAndroid, String color, Double screenSize, Double value){
        super(producer, model, yearOfProduction, color, value);
        this.isAndroid = isAndroid;
        this.screenSize = screenSize;
        this.isOn = false;
    }
    public String toString(){
        return "Producer: " + producer + " Model: " + model + " Colour: " + colour + " isAndroid: " + isAndroid;
    }
    @Override
    public void turnOn() {
        System.out.println("Wciskam guzik");
        System.out.println("Telefon włączony");
        this.isOn = true;
    }
}
