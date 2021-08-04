package com.ghosh.sanjay.beans;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


public class BookTest {

    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        book1 = new Book();
        book1.setISBN("");
        book1.setTitle("");
        book1.setSubject("");
        book1.setPublisher("");
        book1.setLanguage("");
        book1.setNumberOfPages(0);

        book2 = new Book();
        book2.setISBN("");
        book2.setTitle("");
        book2.setSubject("");
        book2.setPublisher("");
        book2.setLanguage("");
        book2.setNumberOfPages(0);

        book3 = new Book();
        book3.setISBN("<NO-ISBN>");
        book3.setTitle("");
        book3.setSubject("");
        book3.setPublisher("");
        book3.setLanguage("");
        book3.setNumberOfPages(0);
    }

    @Test
    void equalsTest() {
        assertEquals(book1, book2);
    }

    @Test
    void notEqualsTest() {
        assertNotEquals(book1, book3);
    }


    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
