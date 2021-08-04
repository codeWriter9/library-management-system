package com.ghosh.sanjay.beans;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


public class BookFineTest {

    private BookFine bookFine1;
    private BookFine bookFine2;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        bookFine1 = BookFine.builder().amount(0.0).build();
        bookFine2 = BookFine.builder().amount(0.0).build();

    }

    @Test
    void equalsTest() {
        assertEquals(bookFine1, bookFine2);
    }

    @Test
    void notEqualsTest() {
        assertNotEquals(bookFine1, BookFine.builder().amount(1.0).build());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
