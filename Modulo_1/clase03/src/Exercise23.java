import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows;
        int countAsteriscos = 1;
        int countSpacios;

        do {
            System.out.print("Enter the diamont size (it must be a positive odd number): ");
            rows = input.nextInt();
        } while (rows <= 0 || rows % 2 == 0);

        for (int i = 0; i < rows; i++) {
            countSpacios = (rows - countAsteriscos) / 2;

            for (int j = 0; j < countSpacios; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < countAsteriscos; k++) {
                System.out.print("*");
            }
            System.out.println();

            if (i < rows / 2) {
                countAsteriscos += 2;
            } else {
                countAsteriscos -= 2;
            }
        }

        input.close();
    }
}
