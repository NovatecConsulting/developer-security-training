package com.demo.server.data.repository;

import com.demo.server.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code BookRepository} is a JPA book repository. 
 * It servers as an example for springfox-data-rest.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
