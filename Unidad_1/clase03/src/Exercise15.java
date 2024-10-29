import java.util.Scanner;

public class Exercise15{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a number: ");
            number = input.nextInt();

            if (number == 0) {
                System.out.println("Is zero, exiting.");
            } else if (number < 0) {
                System.out.println("Is negative.");
            } else {
                System.out.println("Is positive.");
            }
        } while (number != 0);

        input.close();
    }
}