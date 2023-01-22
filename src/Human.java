import java.time.LocalDateTime;


public class Human {
    String firstName;
    String lastName;
    Integer yearOfBirth;
    Animal pet;
    Car car;
    private Double salary;
    private Double prevSalary;
    private LocalDateTime salaryGetDate;
    public Human(String firstName, String lastName,Integer yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
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
    public void setPet(Animal pet){
        this.pet = pet;
    }
    public void setPet(){
        this.pet = null;
    }
    public void setCar(Car car){
        this.car = car;
    }
}
