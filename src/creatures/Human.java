package creatures;

import devices.Car;
import interfaces.Selleable;

import java.time.LocalDateTime;


public class Human implements Selleable {
    String firstName;
    String lastName;
    Integer yearOfBirth;
    Pet pet;
    Animal animal;
    Double cash = 0.0;
    private Car car;
    private Double salary;
    private Double prevSalary;
    private LocalDateTime salaryGetDate;
    public Human(String firstName, String lastName,Integer yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }
    public Double getCash( ){return this.cash;}
    public void setCash(Double cash){ this.cash = cash;}
    public Car getCar(){
        return car;
    }
    public void setCar(Car car){
        double carValue = car.getValue();
        if(this.salary >= carValue){
            System.out.println("Udalo sie kupic samochod");
            this.car = car;
        } else if (this.salary >= (carValue / 12)){
            System.out.println("Udalo sie kupic samochod na kredyt");
            this.car = car;
        } else {
            System.out.println("zapisz się na studia i znajdź nową robotę albo idź po\n" +
                    "podwyżkę");
        }
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
    public void sell(Human seller, Human buyer, Double price){
        if(buyer.cash < price){
            return;
        }
        if(this instanceof Human){
            System.out.println("Can't sell humans!");
        }
    }
}
