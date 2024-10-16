package org.example.library;

public class NotificationService {

    // Bildirim göndermek için kullanılan metot
    public void sendNotification(User user, String message) {
        // Kullanıcıya bildirim gönderme mantığı burada olacak
        // Örneğin: Sistem çıktısına bildirim mesajı yazdırılabilir
        System.out.println("Bildirim: " + user.getName() + " - " + message);
    }

    // Kitap iade tarihine yaklaşan kullanıcıya hatırlatma göndermek için bir metot
    public void sendReturnReminder(User user, Book book) {
        String message = "Merhaba " + user.getName() + ", '" + book.getTitle() + "' kitabının iade tarihi yaklaşıyor!";
        sendNotification(user, message);
    }

    // Ceza bildirimi göndermek için bir metot
    public void sendPenaltyNotification(User user, double penaltyAmount) {
        String message = "Merhaba " + user.getName() + ", gecikmeden dolayı cezanız: " + penaltyAmount + " TL";
        sendNotification(user, message);
    }
}
