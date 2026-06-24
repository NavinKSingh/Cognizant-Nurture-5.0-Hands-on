package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter required for XML-based injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected successfully!");
    }

    public void addBook(String bookName) {
        System.out.println("BookService: Request to add book - " + bookName);
        bookRepository.saveBook(bookName);
    }

    public void searchBook(String bookName) {
        System.out.println("BookService: Request to search book - " + bookName);
        String found = bookRepository.findBook(bookName);
        System.out.println("BookService: Book found! -> " + found);
    }
}