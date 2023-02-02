package devices;

import creatures.Human;

import java.time.LocalDateTime;

public class CarTransactionRecord {
    public Human seller;
    public Human buyer;
    public double value;
    public LocalDateTime date;

    public CarTransactionRecord(Human seller, Human buyer, double value, LocalDateTime date){
        this.seller = seller;
        this.buyer = buyer;
        this.value = value;
        this.date = date;
    }

    @Override
    public String toString() {
        return "CarTransactionClass{" +
                "seller=" + seller +
                ", buyer=" + buyer +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
