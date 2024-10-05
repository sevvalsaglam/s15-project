package org.example.library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Transaction {

    private User user;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;  // Kitabın iade tarihi
    private String action;         // İşlem türü (ödünç alma, iade vb.)
    private double penalty;        // Ceza tutarı

    // Constructor
    public Transaction(User user, Book book, LocalDate borrowDate, String action) {
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.action = action;
        this.returnDate = null;    // İade tarihi başlangıçta null
        this.penalty = 0.0;        // Ceza başlangıçta 0 olarak ayarlanır
    }

    // Getter ve Setter metodları
    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getAction() {
        return action;
    }

    public double getPenalty() {
        return penalty;
    }

    // Kitabın iade tarihini ayarlayan metod
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        System.out.println("İade tarihi ayarlandı: " + returnDate);
    }

    // Ceza tutarını ayarlayan metod
    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    // Kitabın ne kadar süre geciktiğini hesaplayan metod
    public long calculateLateDays() {
        if (returnDate == null) {
            return 0;  // Eğer iade tarihi ayarlanmamışsa gecikme yok
        }
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(borrowDate.plusWeeks(2), returnDate);
        return (daysBetween > 0) ? daysBetween : 0;  // 14 gün sonrası gecikme
    }
}
