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
        assertEquals( bookLending1, bookLending2 );
    }

    @Test
    void notEqualsTest() {
        assertNotEquals( bookLending1, BookLending.builder().creationDate(null).dueDate(null).returnDate(null).bookItemBarcode("").memberId("3").build() );
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
