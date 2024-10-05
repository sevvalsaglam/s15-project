package org.example;

import org.example.library.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Kütüphaneyi oluşturuyoruz
        Library library = new Library();
        // Kütüphaneci ve kullanıcıları oluşturuyoruz
        Librarian librarian = new Librarian("Şevval Sağlam", "sivas58",UserType.LIBRARIAN);
        Member member1 = new Member("Selen Solmaz", "kastamonu37", UserType.REGULAR);
        Member member2 = new Member("Nisa Akyüz", "of61", UserType.PREMIUM);

        // Kullanıcıları kütüphaneye ekliyoruz
        library.addUser(member1);
        library.addUser(member2);

        Book book1 = new Book("Anna Karenina1", "Lev Tolstoy",100.0, Category.CLASSIC);
        Book book2 = new Book("Anna Karenina2", "Lev Tolstoy",150.0,Category.CLASSIC );
        Book book3 = new Book("Anna Karenina3", "Lev Tolstoy", 120.0,Category.CLASSIC );

        // Kitapları kütüphaneye ekliyoruz
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);
        librarian.addBook(library, book3);

        // Kullanıcı 1, 2 kitap ödünç alıyor
        member1.borrowBook(book1, library);
        member1.borrowBook(book2, library);

        // Kullanıcı 2, 1 kitap ödünç alıyor
        member2.borrowBook(book3, library);


        // Ödünç alınan kitapları ve kullanıcıları görüntüleyelim
        System.out.println("Selen'in ödünç aldığı kitaplar:");
        List<Book> selenBooks = member1.getBorrowedBooks();
        for (Book book : selenBooks) {
            System.out.println(book.getTitle());
        }

        System.out.println("Nisa'nın ödünç aldığı kitaplar:");
        List<Book> nisaBooks = member2.getBorrowedBooks();
        for (Book book : nisaBooks) {
            System.out.println(book.getTitle());
        }



        // Alice'in kitabı 10 gün gecikti
        Transaction transaction1 = library.getTransactionByBook(book1);
        transaction1.setReturnDate(transaction1.getBorrowDate().plusDays(24)); // 10 gün gecikme
        PenaltyCalculator calculator = new PenaltyCalculator();
        double penalty1 = calculator.calculatePenalty(transaction1, book1.getPrice());
        transaction1.setPenalty(penalty1); // Ceza ayarlanıyor
        System.out.println("\nAlice'in gecikme cezası: " + transaction1.getPenalty() + " TL");

// Bob'un kitabı 22 gün gecikti
        Transaction transaction2 = library.getTransactionByBook(book3);
        transaction2.setReturnDate(transaction2.getBorrowDate().plusDays(36)); // 22 gün gecikme
        double penalty2 = calculator.calculatePenalty(transaction2, book3.getPrice());
        transaction2.setPenalty(penalty2); // Ceza ayarlanıyor
        System.out.println("Bob'un gecikme cezası: " + transaction2.getPenalty() + " TL");



        // Kitapları iade etme
        member1.returnBook(book1, library);
        member2.returnBook(book3, library);

        // Kitapların iade edilip edilmediğini kontrol edelim
        System.out.println("Selen'in iade ettiği kitaplar:");
        selenBooks = member1.getBorrowedBooks();

        if (selenBooks.isEmpty()) {
            System.out.println("Tüm kitaplar iade edildi.");
        }

        System.out.println("Nisa'nın iade ettiği kitaplar:");
        nisaBooks = member2.getBorrowedBooks();
        if (nisaBooks.isEmpty()) {
            System.out.println("Tüm kitaplar iade edildi.");
        }

    }
}