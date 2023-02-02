import creatures.Animal;
import creatures.Human;
import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Human h1 = new Human("Iza", "Kowalska", 1997);
        Human h2 = new Human("Paulina", "Malina", 1999);
        Human h3 = new Human("Jenna", "Jameson", 1974);
        h2.setCash(800.0);
        Animal dog = new Animal("canis");
        h1.setPet(dog);
        System.out.println("Iza cash: " + h1.getCash());
        System.out.println("Paulina cash: " + h2.getCash());
        dog.sell(h1, h2, 200.0);
        System.out.println("Iza cash: " + h1.getCash());
        System.out.println("Paulina cash: " + h2.getCash());
        System.out.println(h1.getPet());
        System.out.println(h2.getPet());

        h3.sell(h1, h2, 400.0);
    }
}