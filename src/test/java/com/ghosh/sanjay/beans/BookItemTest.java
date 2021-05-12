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


	//private String barcode;
        //private boolean isReferenceOnly;
        //private Date borrowed;
        //private Date dueDate;
        //private double price;
    }

    @Test
    void equalsTest() {
        assertEquals( bookItem1, bookItem2 );
    }

    @Test
    void notEqualsTest() {
        assertNotEquals( bookItem1, BookItem.builder().barcode("<barCode>").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).build() );
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
