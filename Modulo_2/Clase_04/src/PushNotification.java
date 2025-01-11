public class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.printf("Enviando notificación push: %n%s.%n", message);
    }

}
