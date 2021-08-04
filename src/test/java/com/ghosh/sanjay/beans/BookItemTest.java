package com.ghosh.sanjay.beans;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


public class BookItemTest {

    private BookItem bookItem1;
    private BookItem bookItem2;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        bookItem1 = BookItem.builder().barcode("").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).build();
        bookItem2 = BookItem.builder().barcode("").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).build();

    }

    @Test
    void equalsTest() {
        assertEquals(bookItem1, bookItem2);
    }

    @Test
    void notEqualsTest() {
        assertNotEquals(bookItem1, BookItem.builder().barcode("<barCode>").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).build());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
