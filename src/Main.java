public class Main {
    public static void main(String[] args) {
        Human czlek = new Human("Rysiek", "Wisnia", 1997);

        czlek.setSalary(2000);
        System.out.println();
        czlek.getSalary();
        System.out.println();
        czlek.setSalary(2200);
        System.out.println();
        czlek.getSalary();
        System.out.println();
        czlek.getSalary();
    }
}