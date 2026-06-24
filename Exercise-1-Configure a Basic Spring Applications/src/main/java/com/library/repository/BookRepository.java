package com.library.repository;

public class BookRepository {

    public void saveBook(String bookName) {
        System.out.println("BookRepository: '" + bookName + "' saved to database!");
    }

    public String findBook(String bookName) {
        System.out.println("BookRepository: Searching for '" + bookName + "'...");
        return bookName;
    }
}