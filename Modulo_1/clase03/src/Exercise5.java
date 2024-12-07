import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char letter;

        System.out.print("Enter a letter: ");
        letter = input.nextLine().charAt(0);
        
        if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
                letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
                System.out.println(letter + " is a vowel.");
            } else {
                System.out.println(letter + " is a consonant.");
            }
        } else {
            System.out.printf("%s is not a letter", letter);
        }

        // Second option
        // if (Character.isLetter(letter)) {
        //     if ("aeiouAEIOU".indexOf(letter) != -1) {
        //         System.out.println(letter + " is a vowel.");
        //     } else {
        //         System.out.println(letter + " is a consonant.");
        //     }
        // } else {
        //     System.out.printf("%s is not a letter", letter);
        // }

        input.close();
    } 
}
