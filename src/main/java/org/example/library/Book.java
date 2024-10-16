package org.example.library;

import java.util.Objects;

public class Book {
    private String title;        // Kitap başlığı
    private String author;       // Kitap yazarı
    private double price;        // Kitap fiyatı
    private boolean isAvailable; // Kitabın mevcut olup olmadığını belirtir
    private Category category;   // Kitabın kategorisi (enum)
    private String isbn;         // Kitabın barkod numarassı


    // Constructor

    // Kütüphaneye kitap eklemek için kullanılacak olan constructor:
    public Book(String title, String author, double price, Category category, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;  // Kitap başlangıçta kütüphanede mevcut olarak ayarlanır
        this.category = category;
        this.isbn = isbn;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public Book(String title) {
        this.title = title;
    }

    // Getter ve Setter methodları
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", category=" + category +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    // Kitaplar barkod numaralarına göre kontrol edileceği için equals methodu isbn variable'ını alıyor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }
}
