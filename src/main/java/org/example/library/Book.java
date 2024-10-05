package org.example.library;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private double price;
    private Category category;


    public Book(String title, String author, String isbn, double price, Category category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.price = price;
        this.category=category;
    }

    public Book(String title, String author, double price, Category category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }



    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getAuthor() {
        return author;
    }
}
