import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in degrees Celsius: ");
        double celsius = Double.valueOf(input.nextLine());

        double fahrenheit = celsius * 9 / 5 + 32;
        double kelvin = celsius + 273.15;

        System.out.printf("%.2f degrees Celsius = %.2f degrees Fahrenheit%n", celsius, fahrenheit);
        System.out.printf("%.2f degrees Celsius = %.2f degrees Kelvin%n", celsius, kelvin);

        input.close();
    }
}
