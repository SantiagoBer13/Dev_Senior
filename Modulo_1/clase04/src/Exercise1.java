import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String menu = """
                
                Conversión de Temperaturas
                1) Celsius a Fahrenheit.
                2) Fahrenheit a Celsius.
                
                """;
        System.out.print(menu);
        System.out.print("Ingresa una opción: ");
        byte opcion = Byte.parseByte(input.nextLine());

        switch (opcion) {
            case 1 -> {
                System.out.print("Temperatura en Celsius: ");
                double celsius = Double.parseDouble(input.nextLine());
                double fahrenheit = celsiusToFahrenheit(celsius);
                System.out.printf("Temperatura en Fahrenheit es: %.1f%n", fahrenheit);
            }
            case 2 -> {
                System.out.print("Temperatura en Fahrenheit: ");
                double fahrenheit = Double.parseDouble(input.nextLine());
                double celsius = fahrenheitToCelsius(fahrenheit);
                System.out.printf("Temperatura en Celsius es: %.1f%n", celsius);
            }
            default -> System.out.println("Opción incorrecta.");
        }

        input.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
