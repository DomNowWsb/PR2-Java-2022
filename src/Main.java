import creatures.Animal;
import creatures.FarmAnimal;
import creatures.Human;
import creatures.Pet;
import devices.Application;
import devices.Car;
import devices.LPG;
import devices.Phone;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Human h1 = new Human("Iza", "Kowalska", 1997);
        h1.setCash(3000.0);
        h1.setSalary(3000.0);
        Human h2 = new Human("Paulina", "Malina", 1999);
        h2.setSalary(4000.0);
        h2.setCash(4000.0);

        Phone ph1 = new Phone("Samsung", "S10", 2015, true, "Black", 200.0, 300.0);

        h1.setPhone(ph1);
        Application app1 = new Application("Musico", 200.0);
        ph1.installAnnApp("Music");
        ph1.installAnnApp("Video");
        ph1.installAnnApp("GooglePlay");
        ph1.installAnnApp(app1);

        List<Application> ph1Apps = ph1.sortApps();
        for(Application app : ph1Apps){
            System.out.println(app);
        }
        List<Application> ph1AppsPrice = ph1.sortAppsByPrice();
        for(Application app : ph1AppsPrice){
            System.out.println(app);
        }

        LPG car = new LPG("Fiat", "Punto", 1997, "Black", 1000.0);

        h1.addCar(car);

        car.refuel();

        car.sell(h1, h2, 200.0);
        System.out.println(h2.getCar(0));
        System.out.println(car.transactionHistory);
        System.out.println(h2.getCarsValue());
    }
}