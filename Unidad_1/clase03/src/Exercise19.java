import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            int n1 = 0, n2 = 1, n3;

            if (number == 1) {
                System.out.print(n1);
            } else if (number == 2) {
                System.out.printf("%d %d", n1, n2);
            } else {
                System.out.printf("%d %d ", n1, n2);
                for (int i = 0; i < (number - 2); i++) {
                    n3 = n2;
                    n2 = n1 + n2;
                    n1 = n3;
                    System.out.printf("%d ", n2);
                }
            }
        }

        input.close();
    }
}