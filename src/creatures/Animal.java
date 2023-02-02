package creatures;

import interfaces.Sellable;

public abstract class Animal implements Feedable, Sellable {
    private static final Double DEFAULT_DOG_WEIGHT = 10.5;
    private static final Double DEFAULT_CAT_WEIGHT = 4.0;
    private static final Double DEFAULT_ELEPHANT_WEIGHT = 700.0;
    private static final Double DEFAULT_ANIMAL_WEIGHT = 40.0;
    private static final Double DEFAULT_HUMAN_WEIGHT = 70.0;

    final String species;
    Boolean isAlive;
    private Double weight;
    public Animal(String species){
        this.isAlive = true;
        this.species = species;
        switch (species) {
            case "canis" : this.weight = DEFAULT_DOG_WEIGHT; break;
            case "felis" : this.weight = DEFAULT_CAT_WEIGHT; break;
            case "elephant" : this.weight = DEFAULT_ELEPHANT_WEIGHT; break;
            case "homo sapiens" : this.weight = DEFAULT_HUMAN_WEIGHT; break;
            default : this.weight = DEFAULT_ANIMAL_WEIGHT;
        }
    }
    public String toString(){
        return "Species: " + species + " Weight: " + weight;
    }
    public void feed(){
        if(this.isAlive == false){
            System.out.println("It can't eat because it is not alive");
            return;
        }
        this.weight += 1.0;
    }
    public void feed(Double foodWeight){
        if(this.isAlive == false){
            System.out.println("It can't eat because it is not alive");
            return;
        }
        this.weight += foodWeight;
    }
    public void takeForAWalk(){
        if(this.isAlive == false){
            System.out.println("You can't take a dead animal for a walk");
            return;
        }
        this.weight -= 1.0;
        if(this.weight <= 0){
            this.isAlive = false;
            System.out.println("Your pet died because you didn't feed him enough");
        }
    }
    public Double getWeight(){
        if(!this.isAlive){
            System.out.println("Animal died, doesn't have weight");
            return 0.0;
        }
        return this.weight;
    }
    public void sell(Human seller, Human buyer, Double price){
        if(seller.getPet() != this){
            return;
        }
        if(buyer.cash < price){
            return;
        }
        buyer.cash -= price;
        seller.cash += price;
        seller.setAnimal();
        buyer.setAnimal(this);
        System.out.println("Buyer bought " + this);
    }
}
