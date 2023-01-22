public class Main {
    public static void main(String[] args) {
        Human czlek = new Human("Rysiek", "Wisnia", 1997);
        Animal dog = new Animal("canis");
        czlek.setPet(dog);
        czlek.pet.takeForAWalk();
        for (int i = 0; i < 16; i++) {
            czlek.pet.takeForAWalk();
            if(i < 5){
                czlek.pet.feed();
            }
        }
    }

}