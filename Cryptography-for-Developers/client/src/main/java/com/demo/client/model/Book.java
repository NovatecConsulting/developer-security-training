package com.demo.client.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

/**
 * {@code Book} represents a client side book entity.
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class Book extends BookRequest {

    private UUID id;
}
