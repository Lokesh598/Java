package org.java.learning.designpatterns.creational.factory.notification;


//single responsibility principle ✔✔
//Open-Closed principle ✔✔

// this promotes loos coupling

public interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an Email notification");
    }
}

class SMSNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending a SMS notification");
    }
}

class PushNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending a Push notification");
    }
}

//common class for all type.
//here we are encapsulating the object creation logic

class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty())
            return null;

        switch (type) {
            case "Email":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();

            case "Push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

class Main {
    public static void main(String[] args) {
        //central object creation

        NotificationFactory nf = new NotificationFactory();

        Notification n1 = nf.createNotification("Email");
        n1.notifyUser();

        Notification n2 = nf.createNotification("SMS");
        n2.notifyUser();

        Notification n3 = nf.createNotification("Push");
        n3.notifyUser();
    }
}