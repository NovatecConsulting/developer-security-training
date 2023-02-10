package com.demo.client.controller;

import com.demo.client.model.Book;
import com.demo.client.model.BookRequest;
import com.demo.client.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * {@code BookClientController} exposes server side book service API.
 */
@RestController
@Slf4j
public class BookClientController {

    private final BookService service;

    @Autowired
    public BookClientController(BookService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/client/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody BookRequest request) {
        return service.create(request);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE}, value = "/client/books/{id}")
    public Book read(@PathVariable("id") UUID id) {
        return service.read(id);
    }
}
