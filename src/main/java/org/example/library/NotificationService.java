package org.example.library;

public class NotificationService {
    public void sendNotification(User user, String message) {
        System.out.println("Bildirim: " + user.getName() + " - " + message);
    }
}
