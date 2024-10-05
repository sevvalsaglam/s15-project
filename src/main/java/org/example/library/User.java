package org.example.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private List<Book> borrowedBooks;
    private UserType userType;  // UserType değişkeni eklendi

    // Constructor (userType ile)
    public User(String name, String password, UserType userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;  // userType constructor'a eklendi
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter ve Setter metodları
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Kitap ödünç alma işlemi
    public void borrowBook(Book book, Library library) {
        if (borrowedBooks.size() < 5) {
            borrowedBooks.add(book);
            library.addTransaction(new Transaction(this, book, LocalDate.now()));
            System.out.println(name + " kitabı ödünç aldı: " + book.getTitle());
        } else {
            System.out.println(name + " en fazla 5 kitap ödünç alabilir.");
        }
    }

    // Kitap iade etme işlemi
    public void returnBook(Book book, Library library) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            Transaction transaction = library.getTransactionByBook(book);
            if (transaction != null) {
                transaction.setReturnDate(LocalDate.now());
            }
            System.out.println(name + " kitabı iade etti: " + book.getTitle());
        } else {
            System.out.println(name + " bu kitabı ödünç almamış.");
        }
    }
}
