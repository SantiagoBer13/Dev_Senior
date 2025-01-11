public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.printf("Enviando SMS: %n%s.%n", message);
    }
    
}
