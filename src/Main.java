import creatures.Animal;
import creatures.FarmAnimal;
import creatures.Human;
import creatures.Pet;
import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Human h1 = new Human("Iza", "Kowalska", 1997);
        Human h2 = new Human("Paulina", "Malina", 1999);
        Human h3 = new Human("Jenna", "Jameson", 1974);
        h2.setCash(800.0);
        Pet dog = new Pet("canis", "Mis");
        FarmAnimal cow = new FarmAnimal("");
        System.out.println(dog);
        dog.feed(cow.beEaten());
        System.out.println(dog);
        h3.sell(h1, h2, 400.0);
    }
}