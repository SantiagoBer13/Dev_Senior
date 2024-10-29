import java.util.Scanner;

public class Exercise21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte option;
        double miles = 0, km = 0;
        String menu = """
                
                Menu
                1) Miles to kilometers.
                2) Kilometers to miles.
                3) Exit.
                """;
        do {
            System.out.print(menu);
            System.out.print("Enter an option (1, 2, 3): ");
            option = input.nextByte();
            String output = "";

            if (option == 1) {
                System.out.print("Enter the miles: ");
                miles = input.nextDouble();
                km = miles * 1.60934;
                output = miles + " miles = " + km + " kilometers";
            } else if (option == 2) {
                System.out.print("Enter the kilometers: ");
                km = input.nextDouble();
                miles = km * 0.621371;
                output = km + " kilometers = " + miles + " miles";
            } else if (option == 3) {
                System.out.println("Exiting.");
                continue;
            } else {
                System.out.println("Enter a valid option.");
                continue;
            }

            System.out.println(output);
        } while (option != 3);

        input.close();
    }
}
