package org.example.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();          // Kütüphanedeki kitapların listesi
    private List<User> users = new ArrayList<>();          // Kütüphanedeki kullanıcıların listesi
    private List<Transaction> transactions = new ArrayList<>(); // Kütüphanedeki işlemlerin listesi

    // Kitap ekleme
    public void addBook(Book book) {
        books.add(book);
    }

    // Kitap çıkarma
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Kullanıcı ekleme
    public void addUser(User user) {
        users.add(user);
    }

    // Kullanıcı çıkarma
    public void removeUser(User user) {
        users.remove(user);
    }

    // Tüm kitapları döndürme
    public List<Book> getAllBooks() {
        return books;
    }

    // Tüm kullanıcıları döndürme
    public List<User> getAllUsers() {
        return users;
    }

    // Tüm işlemleri döndürme
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    // Yeni bir işlem ekleme
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Kullanıcıya ait tüm işlemleri döndüren metot
    public List<Transaction> getTransactionsForUser(User user) {
        List<Transaction> userTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getUser().equals(user)) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }

    // Kitaba göre ödünç alma işlemini bulma
    public Transaction getTransactionByBook(Book book) {
        for (Transaction transaction : transactions) {
            if (transaction.getBook().equals(book)) {
                return transaction;
            }
        }
        return null; // Eğer kitapla eşleşen bir işlem yoksa null döner
    }

    // Gecikmiş işlemleri döndüren metot
    public List<Transaction> getDelayedTransactions() {
        List<Transaction> delayedTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getLateDays() > 0) {
                delayedTransactions.add(transaction);
            }
        }
        return delayedTransactions;
    }

    // Tüm kitapları yazdırma
    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " - " + book.getAuthor());
        }
    }
}