package com.ghosh.sanjay.util;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.slf4j.LoggerFactory.getLogger;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.enums.AccountStatus;
import com.ghosh.sanjay.beans.Address;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.beans.BookFine;
import com.ghosh.sanjay.beans.BookLending;
import com.ghosh.sanjay.beans.Person;
import com.ghosh.sanjay.exceptions.BookAlreadyCheckedoutException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class BookLendingUtilTest {


    private BookFine bookFine1;
    private BookFine bookFine2;
    private BookLending bookLending1;
    private BookLending bookLending2;


    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
	bookFine1 = BookFine.builder().amount(0.0).build();
        bookFine2 = BookFine.builder().amount(0.0).build();
	ZonedDateTime returnDate = LocalDate.of(2021, 05, 19).atStartOfDay( ZoneId.of("UTC") );
	ZonedDateTime dueDate = LocalDateTime.of(2021, 05, 14, 0, 0).atZone( ZoneId.of("UTC") );
	ZonedDateTime creationDate = LocalDateTime.of(2021, 05, 01, 0, 0).atZone( ZoneId.of("UTC") );
	bookLending1 = BookLending.builder().creationDate(null).dueDate(null).returnDate(null).bookItemBarcode("").memberId("1").build();
        bookLending2 = BookLending.builder().creationDate(creationDate).dueDate(dueDate).returnDate(returnDate).bookItemBarcode("").memberId("1").build();
    }


    @Test
    void testCalculateFine() {
	assertEquals( BookLendingUtil.calculateFine( bookLending1 ).getAmount(), Double.valueOf(0.0));
    }

    @Test
    void testCalculateFine2() {
        assertEquals( BookLendingUtil.calculateFine( bookLending2 ).getAmount(), Double.valueOf(5.0) );
    }


    @AfterEach
    void tearDown() {
	bookFine1 = null;
        bookFine2 = null;
        bookLending1 = null;
        bookLending2 = null;
    }

    @AfterAll
    static void tearDownAll() {
    }

}
