import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter rectangle length: ");
        float length = Float.valueOf(input.nextLine());

        System.out.print("Enter rectangle width: ");
        float width = Float.valueOf(input.nextLine());

        float perimeter = (length * 2) + (width * 2);
        float area = length * width;
        
        System.out.printf("Rectangle perimeter is: %.2f%n", perimeter);
        System.out.printf("Rectangle area is: %.2f%n", area);
        
        input.close();
    }
}
