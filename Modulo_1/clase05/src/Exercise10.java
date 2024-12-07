import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> configurations = new HashMap<>(); 

        int option;

        do {
            System.out.println("Gestión de configuraciones");
            System.out.println("1. Agregar configuración");
            System.out.println("2. Actualizar configuración");
            System.out.println("3. Mostrar todas las configuraciones");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addConfiguration(scanner, configurations);
                    break;
                case 2:
                    updateConfiguration(scanner, configurations);
                    break;
                case 3:
                    showConfigurations(configurations);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 4);
    }

    private static void addConfiguration(Scanner scanner, Map<String, String> configurations) {
        System.out.print("Ingrese el nombre de la configuración: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la descripción de la configuración: ");
        String description = scanner.nextLine();

        configurations.put(name, description);
        System.out.println("Configuración agregada exitosamente.");
    }

    private static void updateConfiguration(Scanner scanner, Map<String, String> configurations) {
        System.out.print("Ingrese el nombre de la configuración a actualizar: ");
        String name = scanner.nextLine();

        if (configurations.containsKey(name)) {
            System.out.print("Ingrese la nueva descripción para la configuración: ");
            String description = scanner.nextLine();
            configurations.put(name, description);
            System.out.println("Configuración actualizada exitosamente.");
        } else {
            System.out.println("La configuración no existe.");
        }
    }

    private static void showConfigurations(Map<String, String> configurations) {
        if (configurations.isEmpty()) {
            System.out.println("No hay configuraciones almacenadas.");
        } else {
            System.out.println("Configuraciones almacenadas:");
            for (Map.Entry<String, String> entry : configurations.entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + " | Descripción: " + entry.getValue());
            }
        }
    }
}
