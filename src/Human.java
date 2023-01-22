public class Human {
    String firstName;
    String lastName;
    Integer yearOfBirth;
    Animal pet;
    Car car;
    public Human(String firstName, String lastName,Integer yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
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
