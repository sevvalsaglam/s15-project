package org.example.library;

public enum UserType {
    REGULAR(5),  // Maksimum 5 kitap ödünç alabilir
    PREMIUM(10), // Maksimum 10 kitap ödünç alabilir
    LIBRARIAN(Integer.MAX_VALUE); // Sınırsız ödünç alabilir

    private final int maxBorrowableBooks;

    UserType(int maxBorrowableBooks) {
        this.maxBorrowableBooks = maxBorrowableBooks;
    }

    public int getMaxBorrowableBooks() {
        return maxBorrowableBooks;
    }
}