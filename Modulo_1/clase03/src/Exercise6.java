import  java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        
        System.out.print("Enter a number: ");
        number = Integer.parseInt(input.nextLine());

        boolean divisibleByTwoAndSeven = (number % 2 == 0) && (number % 7 == 0);

        if (divisibleByTwoAndSeven) {
            System.out.printf("%d is divisible by 2 and 7.%n", number);
        } else {
            System.out.printf("%d is not divisible by 2 and 7.%n", number);
        }

        input.close();
    }
}
