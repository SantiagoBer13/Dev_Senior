public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.printf("Enviando correo: %n%s.%n", message);
    }
    
}
