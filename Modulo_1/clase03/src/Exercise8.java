import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte number;

        System.out.print("Enter an age: ");
        number = Byte.parseByte(input.nextLine());

        if(number > -1 && number < 6){
            System.out.println("Early Childhood.");
        }else if(number > 5 && number < 12){
            System.out.println("Childhood.");
        }else if(number > 11 && number < 19){
            System.out.println("Adolescence.");
        }else if(number > 18 && number < 27){
            System.out.println("Youth.");
        }else if(number > 26 && number < 60){
            System.out.println("Adulthood.");
        }else if(number > 58){
            System.out.println("Elderly person.");
        }else{
            System.out.println("Invalid age input.");
        }

        input.close();
    }
}
