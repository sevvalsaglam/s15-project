package org.example.library;

import java.util.List;

public interface LibraryOperations {

    void addBook(Book book);
    void removeBook(Book book);
    void addUser(User user);
    void removeUser(User user);
    List<Book> getAllBooks();
    List<User> getAllUsers();
    void printAllBooks();
    Transaction getTransactionByBook(Book book);
}
