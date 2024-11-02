import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opcion;
        do {
            String menu = """
                    
                    Conversión de Unidades
                    1) metros a kilómetros.
                    2) kilómetros a metros.
                    3) gramos a kilogramos.
                    4) kilogramos a gramos.
                    5) Salir
                    """;
            System.out.print(menu);
            System.out.print("Elige una opción: ");
            opcion = input.nextLine();
            
            double metros, km, gramos, kg;

            switch (opcion) {
                case "1":
                    System.out.print("Ingresa los metros: ");
                    metros = Double.parseDouble(input.nextLine());
                    km = metrosAKilometros(metros);
                    System.out.printf("%.1f m son %.1f km.%n", metros, km);
                    break;
                case "2":
                    System.out.print("Ingresa los kilómetros: ");
                    km = Double.parseDouble(input.nextLine());
                    metros = kilometrosAMetros(km);
                    System.out.printf("%.1f km son %.1f m.%n", km, metros);
                    break;
                case "3":
                    System.out.print("Ingresa los gramos: ");
                    gramos = Double.parseDouble(input.nextLine());
                    kg = gramosAKilogramos(gramos);
                    System.out.printf("%.1f g son %.1f kg.%n", gramos, kg);
                    break;
                case "4":
                    System.out.print("Ingresa los kilogramos: ");
                    kg = Double.parseDouble(input.nextLine());
                    gramos = kilogramosAGramos(kg);
                    System.out.printf("%.1f kg son %.1f g.%n", kg, gramos); 
                    break;
                case "5":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (!opcion.equals("5"));
        input.close();
    }

    public static double metrosAKilometros(double metros){
        return metros / 1000;
    }

    public static double kilometrosAMetros(double kilometros){
        return kilometros * 1000;
    }

    public static double gramosAKilogramos(double gramos){
        return gramos / 1000;
    }

    public static double kilogramosAGramos(double kilogramos){
        return kilogramos * 1000;
    }
}
