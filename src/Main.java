public class Main {
    public static void main(String[] args) {
        Human czlek = new Human("Rysiek", "Wisnia", 1997);
        czlek.setSalary(1000);
        Car car = new Car("punto", "fiat", 1001);
        System.out.println();
        czlek.setCar(car);
        czlek.setSalary(4000);
        System.out.println();
        czlek.setCar(car);
    }
}