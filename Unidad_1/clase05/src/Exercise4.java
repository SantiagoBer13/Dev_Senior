import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> emails = new HashSet<>();
        do{
            System.out.println("Verificación de duplicados en una lista de correos electrónicos.");
            System.out.print("Ingresa correo electrónico: ");
            String email = input.nextLine();
            validateEmail(emails, email);
            System.out.println("¿Deseas continuar? (si/no)");
            String option = input.nextLine().toLowerCase();
            if (option.equals("no")) {
                System.out.println("Saliendo.");
                break;
            } else if (!option.equals("si")) {
                System.out.println("Opción no válida.");
            }
        }while(true);
        System.out.println("Correos Ingresados.");
        showEmails(emails);
        input.close();
    }

    private static void showEmails(Set<String> emails) {
        for (String email : emails) {
            System.out.println(email);
        }
    }

    private static void validateEmail(Set<String> emails, String email) {
        if(email.contains("@")){
            if(!emails.add(email)){
                System.out.printf("Email duplicado: %s.%n", email);
            }
            
        }else{
            System.out.println("Ingresa un correo valido");
        }
    }
}
