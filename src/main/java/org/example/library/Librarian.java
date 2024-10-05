package org.example.library;

public class Librarian extends User{
    public Librarian(String name, String password, UserType userType) {
        super(name, password, userType);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println(book.getTitle() + " kütüphaneye eklendi.");
    }

    public void removeBook(Library library, Book book) {
        library.removeBook(book);
        System.out.println(book.getTitle() + " kütüphaneden kaldırıldı.");
    }
}
