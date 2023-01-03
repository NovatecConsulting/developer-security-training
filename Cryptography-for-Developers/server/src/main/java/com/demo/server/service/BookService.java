package com.demo.server.service;

import com.demo.server.data.entity.Book;
import com.demo.server.data.repository.BookRepository;
import com.demo.server.error.exception.DataNotFoundException;
import com.demo.server.model.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * {@code BookService} provides CRUD functionality on book.
 */
@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Book create(BookRequest request) {
        Book entity = new Book();
        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());

        return repository.save(entity);

    }

    public Book read(UUID id) {
        Optional<Book> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }

        throw new DataNotFoundException("Book with ID " + id + " not found.");
    }
}