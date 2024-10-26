import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        float firstNmber = Float.valueOf(input.nextLine());
        
        System.out.print("Enter the second number: ");
        float secondNmber = Float.valueOf(input.nextLine());
        
        System.out.print("Enter the third number: ");
        float thirdNmber = Float.valueOf(input.nextLine());
        
        double average = (firstNmber + secondNmber + thirdNmber) / 3;
        
        System.out.printf("Arithmetic average of (%f, %f, %f) is: %f%n", firstNmber, secondNmber, thirdNmber, average);
        
        input.close();
    }
}
