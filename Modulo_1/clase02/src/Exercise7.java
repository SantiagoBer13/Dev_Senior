import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float firstNumber = 0, secondNumber = 0;

        System.out.print("Enter the first number: ");
        firstNumber = Float.valueOf(input.nextLine());

        System.out.print("Enter the second number: ");
        secondNumber = Float.valueOf(input.nextLine()); 

        System.out.printf("Addition: %f%n", (firstNumber + secondNumber));
        System.out.printf("Subtraction: %f%n", (firstNumber - secondNumber));
        System.out.printf("Multiplication: %f%n", (firstNumber * secondNumber));
        System.out.printf("Division: %f%n", (firstNumber / secondNumber));

        input.close();
    }
}
