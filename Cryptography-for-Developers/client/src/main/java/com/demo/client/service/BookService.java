package com.demo.client.service;

import com.demo.client.model.Book;
import com.demo.client.model.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * {@code BookService} provides CRUD functionality on book by calling Book server REST service.
 */
@Service
public class BookService {

    private final RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Book create(BookRequest request) {
        return restTemplate.postForObject("/books", request, Book.class);
    }

    public Book read(UUID id) {
        return restTemplate.getForObject("/books/{0}", Book.class, id);
    }
}
