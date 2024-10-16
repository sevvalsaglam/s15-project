package org.example.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportingService {

    private Library library;

    public ReportingService(Library library) {
        this.library = library;
    }

    public Map<Book, Integer> getMostBorrowedBooks() {
        Map<Book, Integer> borrowCount = new HashMap<>();

        for (Transaction transaction : library.getAllTransactions()) {
            Book book = transaction.getBook();
            borrowCount.put(book, borrowCount.getOrDefault(book, 0) + 1);
        }

        return borrowCount;
    }

    public List<Transaction> getMostDelayedBooks() {
        List<Transaction> delayedTransactions = library.getDelayedTransactions();
        delayedTransactions.sort((t1, t2) -> Long.compare(t2.getLateDays(), t1.getLateDays()));
        return delayedTransactions;
    }
}