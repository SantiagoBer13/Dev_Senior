import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char letter;

        System.out.print("Enter a letter: ");
        letter = input.nextLine().charAt(0);
        
        if (letter >= 'a' && letter <= 'z') {
            System.out.println("The letter is lowercase.");
        } else if (letter >= 'A' && letter <= 'Z') {
            System.out.println("The letter is uppercase.");
        } else {
            System.out.printf("%s is not a letter", letter);
        }

        // Second option
        // if (Character.isLowerCase(letter)) {
        //     System.out.println("The letter is lowercase.");
        // } else {
        //     System.out.println("The letter is uppercase.");
        // }

        input.close();
    }
}
