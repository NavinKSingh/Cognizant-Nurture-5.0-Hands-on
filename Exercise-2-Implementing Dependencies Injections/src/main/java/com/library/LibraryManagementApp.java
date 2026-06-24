package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {

        System.out.println("Loading Spring Application Context...");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n======= Constructor Injection =======");
        BookService constructorService =
                (BookService) context.getBean("bookServiceConstructor");

        constructorService.addBook("Effective Java");
        constructorService.searchBook("Clean Code");
        constructorService.showAllBooks();

        System.out.println("\n======= Setter Injection =======");
        BookService setterService =
                (BookService) context.getBean("bookServiceSetter");

        setterService.addBook("Head First Java");
        setterService.searchBook("Refactoring");
        setterService.removeBook("Design Patterns");

        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("\nSpring Context closed successfully!");
    }
}