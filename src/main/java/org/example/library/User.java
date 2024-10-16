package org.example.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private List<Book> borrowedBooks; // Ödünç alınan kitapların listesi
    private UserType userType; // Kullanıcı türü

    // Kullanıcı oluşturan constructor
    public User(String name, String password, UserType userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
        this.borrowedBooks = new ArrayList<>(); // List başlatılıyor
    }

    // Kitap ödünç alan kullanıcı
    public User(String name, String password, List<Book> borrowedBooks, UserType userType) {
        this.name = name;
        this.password = password;
        this.borrowedBooks = borrowedBooks != null ? borrowedBooks : new ArrayList<>(); // Null kontrolü yapılıyor
        this.userType = userType;
    }

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>(); // List başlatılıyor
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public UserType getUserType() {
        return userType;
    }

    // Kullanıcının ceza durumunu kontrol etme
    public boolean hasPenalty(Library library) {
        List<Transaction> transactions = library.getTransactionsForUser(this); // Bu kullanıcıya ait işlemleri alıyoruz
        for (Transaction transaction : transactions) {
            if (transaction.isPenaltyApplied()) {
                return true; // Eğer herhangi bir işlemde ceza varsa, true döner
            }
        }
        return false; // Hiçbir ceza uygulanmamışsa false döner
    }

    // Kullanıcının kitap ödünç alması
    public void borrowBook(Book book, Library library) {
        // Eğer borrowedBooks null ise başlat
        if (borrowedBooks == null) {
            borrowedBooks = new ArrayList<>();
        }

        List<Transaction> transactions = library.getTransactionsForUser(this);
        if (this.hasPenalty(library)) {
            System.out.println(this.getName() + " mevcut cezası olduğu için kitap ödünç alamaz.");
            return;
        }

        if (transactions.size() >= 5) {
            System.out.println(this.getName() + " zaten 5 kitap ödünç aldı. Daha fazla kitap alamaz.");
        } else {
            // "NO_PENALTY" ya da uygun bir string değeri buraya koyun
            Transaction transaction = new Transaction(book, this, LocalDate.now(), Action.CEZASI_YOK);
            library.addTransaction(transaction);
            borrowedBooks.add(book); // Kitabı borrowedBooks listesine ekle
            System.out.println(this.getName() + " " + book.getTitle() + " kitabını ödünç aldı.");
        }
    }

    // Kullanıcının ödünç aldığı kitabı iade etmesi
    public void returnBook(Book book, Library library) {
        // borrowedBooks listesini kontrol et
        if (borrowedBooks != null && borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            System.out.println(name + " adlı kullanıcı " + book.getTitle() + " kitabını iade etti.");
            // İşlem güncellemesi için kütüphaneye iade işlemi eklenebilir
            // Örneğin, burada bir Transaction oluşturulup kütüphaneye eklenebilir
            // library.addTransaction(new Transaction(book, this, LocalDate.now(), "Returned"));
        } else {
            System.out.println(name + " adlı kullanıcı " + book.getTitle() + " kitabını ödünç almadı.");
        }
    }
}