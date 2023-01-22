public class Car {
    String model;
    String producer;
    private Double value;

    public Car(String model, String producer, double value){
        this.model = model;
        this.producer = producer;
        this.value = value;
    }
    public Double getValue(){
        return this.value;
    }
}
