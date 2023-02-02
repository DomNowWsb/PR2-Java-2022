import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("punto", "fiat", 1997, "Black", 2000);
        Phone phone = new Phone("S10", "Samsung", 2013, true, "Black" ,200.0, 200.0);
        car.turnOn();
        phone.turnOn();
    }
}