import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Human czlek = new Human("Rysiek", "Wisnia", 1997);
        czlek.setSalary(1000);
        Car car = new Car("punto", "fiat", 1001);
        Phone phone = new Phone("S10", "Samsung", 300);
        System.out.println(car);
        System.out.println(phone);
    }
}