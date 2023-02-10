package com.demo.server.controller;

import com.demo.server.data.entity.Book;
import lombok.extern.slf4j.Slf4j;
import com.demo.server.model.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.demo.server.service.BookService;

import java.util.UUID;

/**
 * {@code BookController} exposes book service.
 */
@RestController
@Slf4j
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody BookRequest request) {
        return service.create(request);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE}, value = "/books/{id}")
    public Book read(@PathVariable("id") UUID id) {
        return service.read(id);
    }
}
