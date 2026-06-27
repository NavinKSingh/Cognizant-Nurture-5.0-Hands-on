package com.library;

public class LibraryService {

    public void addBook(String bookName) {
        System.out.println("Book added: " + bookName);
    }

    public void removeBook(String bookName) {
        System.out.println("Book removed: " + bookName);
    }

    public void listBooks() {
        System.out.println("Listing all books in the library.");
    }
}