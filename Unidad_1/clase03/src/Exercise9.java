import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        short numberSheets = 0;
        int priceByUnity = 0;

        System.out.print("Enter the number of sheets you want to buy: ");
        numberSheets = Short.parseShort(input.nextLine());
        
        if(numberSheets > 0){
            if (numberSheets > 0 && numberSheets < 51) {
                priceByUnity = 50000;
            } else if (numberSheets > 50 && numberSheets < 101) {
                priceByUnity = 45000;
            } else if (numberSheets > 100 && numberSheets < 151) {
                priceByUnity = 40000;
            } else if (numberSheets > 150 && numberSheets < 201) {
                priceByUnity = 35000;
            } else if (numberSheets > 200) {
                priceByUnity = 25000;
            } 

            System.out.printf("You are going to buy %d sheets.%n", numberSheets);
            System.out.printf("Total price is: $%d%n.", (numberSheets * priceByUnity));
        }else {
            System.out.println("Incorrect number of sheets.");
        }

        input.close();
    }
}
