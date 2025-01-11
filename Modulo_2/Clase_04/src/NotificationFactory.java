public class NotificationFactory {
    public Notification getTypeNotification(TypeNotification typeNotification){
        switch (typeNotification) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            default:
                return null;
        }
    }
}
