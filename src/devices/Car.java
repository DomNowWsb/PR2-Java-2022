package devices;

import creatures.Human;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public abstract class Car extends Devices implements Comparable<Car>{
    private Double mileage = 0.0;
    public List<Human> ownersList = new LinkedList<>();

    public List<CarTransactionRecord> transactionHistory = new LinkedList<>();
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
    public void sell(Human seller, Human buyer, Double price) throws Exception {

        if(buyer.getCash() < price){
            throw new Exception("Buyer doesn't have enough cash");
        }
        if(this.ownersList.get(this.ownersList.size() - 1) != seller){
            throw new Exception("Seller isn't the owner of this Car");
        }
        if(!seller.hasCar(this)){
            throw new Exception("Seller doesn't have this Car");
        }
        if(!buyer.hasFreeGarageSpace()){
            throw new Exception("Buyer doesn't have enough free garage space");
        }

        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        seller.removeCar(this);
        buyer.addCar(this);
        this.addCarOwner(buyer);
        this.addTransactionRecord(seller, buyer, price, LocalDateTime.now());
        System.out.println("Buyer bought " + this);
    }
    public void addCarOwner(Human owner){
        ownersList.add(owner);
    }
    public void addTransactionRecord(Human seller, Human buyer, double value, LocalDateTime date){
        CarTransactionRecord record = new CarTransactionRecord(seller, buyer, value, date);
        transactionHistory.add(record);
    }
    public abstract void refuel();
    @Override
    public void turnOn() {
        System.out.println("Przekręcam kluczyk");
        System.out.println("Samochod odpalil");
        this.isOn = true;
    }
    @Override
    public int compareTo(Car o) {
        return this.yearOfProduction - o.yearOfProduction;
    }

}
