package creatures;

import devices.Car;
import devices.Phone;
import interfaces.Sellable;

import java.time.LocalDateTime;


public class Human extends Animal{
    private static final Integer DEFAULT_GARAGE_SIZE = 3;
    String firstName;
    String lastName;
    Integer yearOfBirth;
    Pet pet;
    Animal animal;
    Phone phone;
    Double cash = 0.0;
    private Car[] garage;
    private Double salary;
    private Double prevSalary;
    private LocalDateTime salaryGetDate;
    public Human(String firstName, String lastName,Integer yearOfBirth){
        super("homo sapiens");
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }
    public Human(String firstName, String lastName,Integer yearOfBirth, Car[] garageArg){
        super("homo sapiens");
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.garage = garageArg;
    }
    public Human(String firstName, String lastName,Integer yearOfBirth, Integer garageArg){
        super("homo sapiens");
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.garage = new Car[garageArg];
    }
    public Double getCash( ){return this.cash;}
    public void setCash(Double cash){ this.cash = cash;}
    public Car[] getCar(){
        return garage;
    }
    public Car getCar(Integer garageSlot){
        return garage[garageSlot];
    }

    public void setCar(Car car, Integer parkingPlaceNumber){
        Integer freeGarageSlot = checkGarageEmptySlot();
        double carValue = car.getValue();
        if(this.salary >= carValue){
            System.out.println("Udalo sie kupic samochod");
            this.garage[freeGarageSlot] = car;
            car.addCarOwner(this);
            return;
        } else if (this.salary >= (carValue / 12)){
            System.out.println("Udalo sie kupic samochod na kredyt");
            this.garage[freeGarageSlot] = car;
            car.addCarOwner(this);
            return;
        } else {
            System.out.println("zapisz się na studia i znajdź nową robotę albo idź po\n" +
                    "podwyżkę");
            return;
        }
    }
    public boolean hasCar(Car car){
        for (int i = 0; i < garage.length; i++) {
            if(garage[i] == car){
                return true;
            }
        }
        return false;
    }
    public boolean hasFreeGarageSpace(){
        for (int i = 0; i < garage.length; i++) {
            if(garage[i] == null){
                return true;
            }
        }
        return false;
    }
    public double getCarsValue(){
        double carsValue = 0;
        for (Car car: garage) {
            if (car != null){
                carsValue += car.getValue();
            }
        }
        return carsValue;
    }

    public void addCar(Car car) throws Exception {
        Integer freeGarageSlot = checkGarageEmptySlot();
        if (freeGarageSlot == -1){
            throw new Exception("Human doesn't have enough garage space");
        }
        if (hasCar(car)){
            throw new Exception("Cant have the same car on multiple parking spots");
        }
        garage[freeGarageSlot] = car;
        car.addCarOwner(this);
    }
    public void removeCar(Car car) throws Exception {
        Integer garageSlot = -1;
        for (int i = 0; i < garage.length; i++) {
            if(garage[i] == car){
                garageSlot = i;
            }
        }
        if(garageSlot == -1){
            throw new Exception("Human doesn't have this car");
        }
        garage[garageSlot] = null;
    }
    public void setCar(Car car){
        Integer freeGarageSlot = checkGarageEmptySlot();
        double carValue = car.getValue();
        if(this.salary >= carValue){
            System.out.println("Udalo sie kupic samochod");
            this.garage[freeGarageSlot] = car;
            return;
        } else if (this.salary >= (carValue / 12)){
            System.out.println("Udalo sie kupic samochod na kredyt");
            this.garage[freeGarageSlot] = car;
            return;
        } else {
            System.out.println("zapisz się na studia i znajdź nową robotę albo idź po\n" +
                    "podwyżkę");
            return;
        }
    }
    public Integer checkGarageEmptySlot(){
        for (int i = 0; i < garage.length; i++) {
            if(garage[i] == null){
                return i;
            }
        }
        return -1;
    }
    public void setSalary(double newSalary){
        if (newSalary < 0 ){
            System.out.println("Can't set negative salary");
            return;
        }
        System.out.println("Nowe dane zostały wysłane do systemu księgowego");
        System.out.println("Prosimy o odebranie aneksu do umowy od pani Hani z kadr");
        System.out.println("ZUS i US już wiedzą o zmianie wypłaty i nie ma sensu ukrywać dochodu");
        this.salary = newSalary;
    }

    public double getSalary(){
        if(salaryGetDate != null){
            System.out.println("Poprzednia data pobrania wyplaty to: " + this.salaryGetDate);
            System.out.println("Poprzednia wartość wypłaty to: " + this.prevSalary);
            this.salaryGetDate = LocalDateTime.now();
            this.prevSalary = this.salary;
            return this.salary;
        }
        this.salaryGetDate = LocalDateTime.now();
        this.prevSalary = this.salary;
        System.out.println("Brak daty poprzedniego pobrania wyplaty");
        return this.salary;
    }
    public void setPet(Pet pet){
        this.pet = pet;
    }
    public void setPet(){
        this.pet = null;
    }
    public Pet getPet(){
        return this.pet;
    }
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    public void setAnimal(){
        this.animal = null;
    }
    public Animal getAnimal(){
        return this.animal;
    }
    public void setPhone(Phone phone){
        phone.addOwner(this);
        this.phone = phone;
    }
    public Phone getPhone(){return this.phone;}
    public void sell(Human seller, Human buyer, Double price){
        if(buyer.cash < price){
            return;
        }
        if(this instanceof Human){
            System.out.println("Can't sell humans!");
        }
    }

}
