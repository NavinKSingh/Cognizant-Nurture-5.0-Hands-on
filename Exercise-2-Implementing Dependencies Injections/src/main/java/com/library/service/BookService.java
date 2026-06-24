package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via CONSTRUCTOR!");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via SETTER!");
    }

    public BookService() {}

    public void addBook(String bookName) {
        System.out.println("\nBookService: Adding book - " + bookName);
        bookRepository.saveBook(bookName);
    }

    public void searchBook(String bookName) {
        System.out.println("\nBookService: Searching book - " + bookName);
        String result = bookRepository.findBook(bookName);
        System.out.println("BookService: Result -> " + result);
    }

    public void removeBook(String bookName) {
        System.out.println("\nBookService: Removing book - " + bookName);
        bookRepository.deleteBook(bookName);
    }

    public void showAllBooks() {
        System.out.println("\nBookService: Fetching all books...");
        bookRepository.listAllBooks();
    }
}