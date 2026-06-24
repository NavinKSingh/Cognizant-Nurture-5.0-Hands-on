package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {

        System.out.println("Loading Spring Application Context...");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("\n--- Adding Books ---");
        bookService.addBook("Clean Code");
        bookService.addBook("The Pragmatic Programmer");

        System.out.println("\n--- Searching Book ---");
        bookService.searchBook("Clean Code");

        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("\nSpring Context closed successfully!");
    }
}