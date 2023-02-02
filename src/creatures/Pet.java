package creatures;

public class Pet extends Animal{
    final String name;
    public Pet(String species, String name) {
        super(species);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", isAlive=" + isAlive + '\'' +
                ", weight=" + getWeight() +
                '}';
    }
    @Override
    public void sell(Human seller, Human buyer, Double price){
        if(seller.getPet() != this){
            return;
        }
        if(buyer.cash < price){
            return;
        }
        buyer.cash -= price;
        seller.cash += price;
        seller.setPet();
        buyer.setPet(this);
        System.out.println("Buyer bought " + this);
    }
}
