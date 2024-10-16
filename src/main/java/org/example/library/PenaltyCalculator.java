package org.example.library;

public class PenaltyCalculator {
    public static double calculatePenalty(Book book, long daysLate) {
        if (daysLate <= 7) {
            return book.getPrice() * 0.25;
        } else if (daysLate <= 14) {
            return book.getPrice() * 0.50;
        } else if (daysLate <= 21) {
            return book.getPrice() * 0.75;
        } else {
            return book.getPrice();
        }
    }
}