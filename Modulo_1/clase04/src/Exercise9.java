import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String menu = """
                
                Cálculo de Intereses
                1) Calcular Interés Simple
                2) Calcular Interés Compuesto
                3) Salir
                """;
        int opcion;
        do {
            System.out.print(menu);
            System.out.print("Ingresa una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el monto de capital: ");
                    double capitalSimple = Double.parseDouble(input.nextLine());
                    System.out.print("Ingresa la tasa de interés anual (en porcentaje): ");
                    double tasaSimple = Double.parseDouble(input.nextLine()) / 100; // Convertir a decimal
                    System.out.print("Ingresa el tiempo (en años): ");
                    double añosSimple = Double.parseDouble(input.nextLine());
                    double interesSimple = calcularInteresSimple(capitalSimple, tasaSimple, añosSimple);
                    System.out.printf("El interés simple es: %.2f%n", interesSimple);
                    break;
                case 2:
                    System.out.print("Ingresa el monto de capital: ");
                    double capitalCompuesto = Double.parseDouble(input.nextLine());
                    System.out.print("Ingresa la tasa de interés anual (en porcentaje): ");
                    double tasaCompuesto = Double.parseDouble(input.nextLine()) / 100; // Convertir a decimal
                    System.out.print("Ingresa el tiempo (en años): ");
                    double añosCompuesto = Double.parseDouble(input.nextLine());
                    System.out.print("Ingresa el número de veces que se aplica el interés por año: ");
                    double numeroInteresPorAño = Double.parseDouble(input.nextLine());
                    
                    double montoTotal = calcularMontoCompuesto(capitalCompuesto, tasaCompuesto, numeroInteresPorAño, añosCompuesto);
                    double interesCompuesto = montoTotal - capitalCompuesto;
                    
                    System.out.printf("El monto total después de %.1f años es: %.6f%n", añosCompuesto, montoTotal);
                    System.out.printf("El interés compuesto es: %.6f%n", interesCompuesto);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 3);
        
        input.close();
    }

    public static double calcularInteresSimple(double capital, double tasaInteresAnual, double años){
        return capital * tasaInteresAnual * años;
    }

    public static double calcularMontoCompuesto(double capital, double tasaInteresAnual, double numeroInteresPorAño, double años){
        return capital * Math.pow((1 + tasaInteresAnual / numeroInteresPorAño), numeroInteresPorAño * años);

        // return capital *  (1 + Math.pow((tasaInteresAnual / numeroInteresPorAño), numeroInteresPorAño * años));
    }
}
