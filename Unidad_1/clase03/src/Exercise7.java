import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first side: ");
        int a = input.nextInt();

        System.out.print("Enter the second side: ");
        int b = input.nextInt();

        System.out.print("Enter the third side: ");
        int c = input.nextInt();

        //Verifica que los valores de los lados sean mayores a 0, y que la suma de dos lados cualquiera sean mayores al tercer lado.
        if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
            System.out.println("The lengths can form a triangle.");
        } else {
            System.out.println("The lengths cannot form a triangle.");
        }

        input.close();
    }
}
