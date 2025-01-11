import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Gestión de Notificaciones (Factory)");

        int option;
        int getOut;

        do {
            showMenu();
            option = getValidOption(sc, 1, 3, "Ingresa tu opción: ",
                    "Opción inválida. Por favor, elige una opción entre 1 y 3.");

            NotificationFactory nf = new NotificationFactory();
            Notification notification = getNotificationByOption(nf, option);
            String message = getMessage(sc, "Ingresa el mensaje de la notificación: ");
            notification.send(message);

            getOut = getValidOption(sc, 1, 2, "¿Deseas enviar otra notificación? 1) Sí, 2) No: ",
                    "Opción inválida. Por favor, elige 1 (Sí) o 2 (No).");

            if (getOut == 2) {
                System.out.println("Gracias por usar el sistema de notificaciones. ¡Hasta pronto!");
            }
        } while (getOut == 1);

        sc.close();
    }

    public static void showMenu() {
        String message = """
                Menú
                1) Notificación por correo.
                2) Notificación por SMS.
                3) Notificación PUSH.
                """;
        System.out.println(message);
    }

    public static int getValidOption(Scanner sc, int min, int max, String prompt, String errorMessage) {
        int option;
        while (true) {
            System.out.print(prompt);

            option = Integer.parseInt(sc.nextLine());
            if (option >= min && option <= max) {
                break;
            }

            System.out.println(errorMessage);
        }
        return option;
    }

    public static Notification getNotificationByOption(NotificationFactory nf, int option) {
        switch (option) {
            case 1:
                return nf.getTypeNotification(TypeNotification.EMAIL);
            case 2:
                return nf.getTypeNotification(TypeNotification.SMS);
            case 3:
                return nf.getTypeNotification(TypeNotification.PUSH);
            default:
                throw new IllegalArgumentException("Opción no válida.");
        }
    }

    public static String getMessage(Scanner sc, String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }
}
