import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Gestión de Vehículos\n");

        List<Car> cars = List.of(
            new Car("Chevrolet", "Spark", 85, 4),
            new Car("Toyota", "Corolla", 130, 4),
            new Car("Ford", "Mustang", 450, 2)
        );

        // Crear una lista de motos
        List<Motorbike> motorbikes = List.of(
            new Motorbike("Harley-Davidson", "Sportster", 120, true),
            new Motorbike("Yamaha", "R1", 200, false),
            new Motorbike("Honda", "CB500X", 50, false)
        );

        System.out.println("========== CARS ==========");
        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println("\n========== MOTORBIKES ==========");
        for (Motorbike motorbike : motorbikes) {
            System.out.println(motorbike);
        }
    }
}