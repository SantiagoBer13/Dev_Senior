import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int firstBrother, secondBrother;

        System.out.print("Enter the number of the first brother in the meeting (1, 2, or 3): ");
        firstBrother = input.nextInt();
        while (firstBrother < 1 || firstBrother > 3) {
            System.out.print("Invalid input. Enter 1, 2, or 3: ");
            firstBrother = input.nextInt();
        }

        System.out.print("Enter the number of the second brother in the meeting (1, 2, or 3): ");
        secondBrother = input.nextInt();
        while (secondBrother < 1 || secondBrother > 3 || secondBrother == firstBrother) {
            if (secondBrother == firstBrother) {
                System.out.print("Duplicate entry. Please enter a different number: ");
            } else {
                System.out.print("Invalid input. Please enter 1, 2, or 3: ");
            }
            secondBrother = input.nextInt();
        }

        if (firstBrother != 1 && secondBrother != 1) {
            System.out.println("Brother 1 is late.");
        } else if (firstBrother != 2 && secondBrother != 2) {
            System.out.println("Brother 2 is late.");
        } else {
            System.out.println("Brother 3 is late.");
        }

        input.close();
    }
}
