package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring Context loaded successfully!");

        LibraryService service = (LibraryService) context.getBean("libraryService");

        service.addBook("Clean Code");
        service.addBook("Effective Java");
        service.listBooks();
        service.removeBook("Clean Code");

        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("Application closed successfully.");
    }
}