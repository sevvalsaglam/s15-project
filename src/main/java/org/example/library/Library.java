package org.example.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;    // Kütüphanedeki kitaplar
    private List<User> users;    // Kütüphanedeki kullanıcılar
    private List<Transaction> transactions; // Ödünç işlemleri

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Kitap ekleme ve çıkarma metodları
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " kütüphaneye eklendi.");
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println(book.getTitle() + " kütüphaneden çıkarıldı.");
    }

    // Kullanıcı ekleme ve çıkarma metodları
    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " kütüphaneye eklendi.");
    }

    public void removeUser(User user) {
        users.remove(user);
        System.out.println(user.getName() + " kütüphaneden çıkarıldı.");
    }

    // Kullanıcıları döndüren metod
    public List<User> getAllUsers() {
        return users;
    }

    // Transaction ekleme metodu
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Ödünç işlemini kitaba göre bulma metodu
    public Transaction getTransactionByBook(Book book) {
        for (Transaction transaction : transactions) {
            if (transaction.getBook().equals(book)) {
                return transaction;
            }
        }
        return null;
    }

    // Tüm kitapları döndüren metod
    public List<Book> getAllBooks() {
        return books;
    }

    // Kütüphanedeki mevcut kitapları yazdırma
    public void printAllBooks() {
        System.out.println("Kütüphanedeki Kitaplar:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " - " + book.getAuthor());
        }
    }
}
