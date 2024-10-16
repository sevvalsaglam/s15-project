package org.example;

import org.example.library.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Kütüphane ve kütüphaneciyi oluştur
        Library library = new Library();
        Librarian librarian = new Librarian("Selen Solmaz", "password789", UserType.LIBRARIAN,library);
        library.addUser(librarian);

        // Kitapları oluştur
        Book book1 = new Book("Yüzyıllık Yalnızlık", "Gabriel Garcia Marquez", 50.0,Category.CLASSICS,"312313");
        Book book2 = new Book("Sefiller", "Victor Hugo", 40.0,Category.CLASSICS,"2435454");
        Book book3 = new Book("Bülbülü Öldürmek", "Harper Lee", 30.0, Category.CLASSICS,"423424");

        // Kitapları kütüphaneye ekle
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);

        // Kullanıcıları oluştur
        User user1 = new User("Şevval Sağlam", "userpassword", UserType.REGULAR);
        User user2 = new User("Ali Can", "userpassword2", UserType.REGULAR);

        // Kullanıcıları kütüphaneye ekle
        librarian.addUser(user1);
        librarian.addUser(user2);

        // Kullanıcının kitap ödünç alma işlemi
        user1.borrowBook(book1, library); // Şevval Sağlam, Yüzyıllık Yalnızlık'ı ödünç alır
        user1.borrowBook(book2, library); // Şevval Sağlam, Sefiller'i ödünç alır

        // Ödünç alma işlemi sonrası kullanıcıdan bir kitap iade etme işlemi
        user1.returnBook(book1,library); // Şevval Sağlam, Yüzyıllık Yalnızlık'ı iade eder.

        // Kullanıcının kitap sayısını kontrol et
        System.out.println(user1.getName() + " toplam " + user1.getBorrowedBooks().size() + " kitap ödünç aldı.");

        // Diğer kullanıcı kitap ödünç alıyor
        user2.borrowBook(book3, library); // Ali Can, Bülbülü Öldürmek'i ödünç alır

        // Ödünç alınan kitaplar ve cezalar
        System.out.println("Ödünç alınan kitaplar:");
        for (Book book : user1.getBorrowedBooks()) {
            System.out.println("- " + book.getTitle());
        }

        System.out.println("Cezası olan kullanıcılar:");
        if (user1.hasPenalty(library)) {
            System.out.println(user1.getName() + " ceza almıştır.");
        } else {
            System.out.println(user1.getName() + " ceza almamıştır.");
        }


            //TRANSACTION
            // Kitap ödünç alma işlemi oluşturma
            Transaction transaction = new Transaction(book1,user1, LocalDate.now(),Action.ODUNC_ALMA);
            library.addTransaction(transaction);
            System.out.println(user1.getName() + " " + book1.getTitle() + " kitabını ödünç aldı.");

            // Kitap iadesi
            transaction.setReturned(true);
            transaction.setReturnDate(LocalDate.now().plusDays(10));
            System.out.println(user1.getName() + " " + book1.getTitle() + " kitabını iade etti.");

    }
}

