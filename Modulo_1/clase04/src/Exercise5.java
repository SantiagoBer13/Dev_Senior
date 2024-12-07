import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cálculo de Promedio de tres números");
        System.out.print("Ingresa el primer número: ");
        int numero1 = input.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int numero2 = input.nextInt();
        System.out.print("Ingresa el tercer número: ");
        int numero3 = input.nextInt();
        double promedio = calcularPromedio(numero1, numero2, numero3);
        System.out.printf("El promedio de los tres números es %.1f", promedio);
        input.close();
    }

    public static double calcularPromedio(int num1, int num2, int num3){
        return (num1 + num2 + num3) / 3.0;
    }
}
