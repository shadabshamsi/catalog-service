package com.shadabshamsi.catalogservice.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.shadabshamsi.catalogservice.domain.Book;
import com.shadabshamsi.catalogservice.domain.BookRepository;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        var book1 = Book.of("1234567890", "Head First Java", "Kathy Sierra", 15.5, null);
        var book2 = Book.of("4567890123", "Spring Boot in Action", "Craig Walls", 25.0, null);

        bookRepository.saveAll(List.of(book1, book2));
    }
}
