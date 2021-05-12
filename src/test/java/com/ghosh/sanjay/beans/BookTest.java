package com.ghosh.sanjay.beans;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
        assertEquals( book1, book2 );
    }

    @Test
    void notEqualsTest() {
	assertNotEquals( book1, book3  );
    }


    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
