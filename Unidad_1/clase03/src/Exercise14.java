import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a positive number (negative number to exit): ");
            number = input.nextInt();

            if (number >= 0) {
                int cube = number * number * number;
                System.out.printf("%d cubed: %d%n", number, cube);
            }
        } while (number > 0);

        input.close();
    }
}
