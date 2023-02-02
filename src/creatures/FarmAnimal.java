package creatures;

public class FarmAnimal extends Animal implements Edible{
    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public Double beEaten() {
        Double weight = this.getWeight();
        this.isAlive = false;
        return weight;
    }
}
