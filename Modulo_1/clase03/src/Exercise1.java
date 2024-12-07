import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(input.nextLine());

        if (number == 0) {
            System.out.println("Is zero.");
        } else if (number > 0) {
            System.out.printf("%d is positive.%n", number);
        } else {
            System.out.printf("%d is negative.%n", number);
        }

        input.close();
    }
}