package org.example.library;

import java.util.List;

public class Librarian extends User implements LibraryOperations {

    private Library library;

    // Kütüphaneci oluşturmak için kullanılacak constructor:
    public Librarian(String name, String password, UserType userType, Library library) {
        super(name, password, UserType.LIBRARIAN);
        this.library = library; // Library nesnesini ayarlayın
    }

    @Override
    public void addBook(Book book) {
        library.addBook(book);  // Library sınıfındaki addBook metodunu çağırır
    }

    // Kitap çıkarma
    @Override
    public void removeBook(Book book) {
        library.removeBook(book);  // Library sınıfındaki removeBook metodunu çağırır
    }

    // Kullanıcı ekleme
    @Override
    public void addUser(User user) {
        library.addUser(user);  // Library sınıfındaki addUser metodunu çağırır
    }

    // Kullanıcı çıkarma
    @Override
    public void removeUser(User user) {
        library.removeUser(user);  // Library sınıfındaki removeUser metodunu çağırır
    }

    // Tüm kitapları listeleme
    @Override
    public List<Book> getAllBooks() {
        return library.getAllBooks();  // Library sınıfındaki getAllBooks metodunu çağırır
    }

    // Tüm kullanıcıları listeleme
    @Override
    public List<User> getAllUsers() {
        return library.getAllUsers();  // Library sınıfındaki getAllUsers metodunu çağırır
    }

    // Tüm kitapları yazdırma
    @Override
    public void printAllBooks() {
        library.printAllBooks();  // Library sınıfındaki printAllBooks metodunu çağırır
    }

    // Kitaba göre ödünç alma işlemini bulma
    @Override
    public Transaction getTransactionByBook(Book book) {
        return library.getTransactionByBook(book);  // Library sınıfındaki getTransactionByBook metodunu çağırır
    }
}
