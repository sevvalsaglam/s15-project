package org.example.library;

import java.time.LocalDate;

public class Transaction {
    private Book book;            // İşlemdeki kitap
    private User user;            // İşlemi gerçekleştiren kullanıcı
    private LocalDate borrowDate; // Ödünç alınma tarihi
    private LocalDate returnDate; // İade tarihi
    private Action action;        // İşlem türü (ödünç alma/iade)
    private double penalty;       // Gecikme cezası
    private boolean penaltyApplied; // Ceza durumu
    private String penaltyStatus; // Ödünç işleminin ceza durumu
    private boolean isReturned;

    public Transaction(Book book, User user, LocalDate borrowDate, Action action) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.action = action;
    }

    public Transaction(Book book, User user, Action action) {
        this(book, user, LocalDate.now(), action);
    }

    // Getters ve Setters
    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public long getLateDays() {
        if (returnDate != null) {
            long daysLate = LocalDate.now().toEpochDay() - returnDate.toEpochDay();
            return daysLate > 0 ? daysLate : 0;
        }
        return 0;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public boolean isPenaltyApplied() {
        return penaltyApplied;
    }
    public void setReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }
}
