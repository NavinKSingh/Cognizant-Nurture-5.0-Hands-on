package com.library.repository;

public class BookRepository {

    private String[] books = {
            "Clean Code",
            "The Pragmatic Programmer",
            "Design Patterns",
            "Refactoring"
    };

    public void saveBook(String bookName) {
        System.out.println("BookRepository: '" + bookName + "' saved to database!");
    }

    public String findBook(String bookName) {
        System.out.println("BookRepository: Searching for '" + bookName + "'...");
        for (String book : books) {
            if (book.equalsIgnoreCase(bookName)) {
                return "FOUND -> " + book;
            }
        }
        return "NOT FOUND -> " + bookName;
    }

    public void deleteBook(String bookName) {
        System.out.println("BookRepository: '" + bookName + "' deleted from database!");
    }

    public void listAllBooks() {
        System.out.println("BookRepository: Listing all books:");
        for (String book : books) {
            System.out.println("  - " + book);
        }
    }
}