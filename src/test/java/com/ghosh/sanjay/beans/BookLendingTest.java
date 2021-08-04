package com.ghosh.sanjay.beans;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


public class BookLendingTest {

    private BookLending bookLending1;
    private BookLending bookLending2;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        bookLending1 = BookLending.builder().creationDate(null).dueDate(null).returnDate(null).bookItemBarcode("").memberId("1").build();
        bookLending2 = BookLending.builder().creationDate(null).dueDate(null).returnDate(null).bookItemBarcode("").memberId("1").build();
    }

    @Test
    void equalsTest() {
        assertEquals(bookLending1, bookLending2);
    }

    @Test
    void notEqualsTest() {
        assertNotEquals(bookLending1, BookLending.builder().creationDate(null).dueDate(null).returnDate(null).bookItemBarcode("").memberId("3").build());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
