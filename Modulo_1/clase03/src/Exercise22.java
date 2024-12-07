import java.util.Scanner;

public class Exercise22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String menu = """
                Type an option.
                r) Rock
                p) Paper
                s) Scissors
                """;
        char option, j1, j2;

        do {
            System.out.print(menu);
            System.out.print("Choose an option player 1: ");
            j1 = input.nextLine().toLowerCase().charAt(0);
            System.out.print("Choose an option player 2: ");
            j2 = input.nextLine().toLowerCase().charAt(0);

            if ((j1 == 'r' || j1 == 'p' || j1 == 's') && (j2 == 'r' || j2 == 'p' || j2 == 's')) {
                if (j1 == j2) {
                    System.out.println("Draw");
                } else if ((j1 == 'r' && j2 == 's') || (j1 == 'p' && j2 == 'r') || (j1 == 's' && j2 == 'p')) {
                    System.out.printf("Player 1 wins, %s beats %s.%n", j1, j2);
                } else {
                    System.out.printf("Player 2 wins, %s beats %s.%n", j2, j1);
                }
            } else {
                System.out.println("Invalid input, enter 'r', 'p', or 's'.");
            }

            System.out.print("Do you wish to continue playing?\n1) Yes  2) No\nChoose an option: ");
            option = input.nextLine().charAt(0);

            if (option == '2') {
                System.out.println("Exiting.");
                break;
            }
        } while (true);

        input.close();
    }
}
