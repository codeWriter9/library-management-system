package com.ghosh.sanjay.service;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;

import static org.junit.jupiter.api.Assertions.*;


import com.ghosh.sanjay.actor.Member;

import com.ghosh.sanjay.beans.Address;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.beans.BookLending;
import com.ghosh.sanjay.beans.Person;
import com.ghosh.sanjay.component.Ledger;
import com.ghosh.sanjay.component.Registry;
import com.ghosh.sanjay.exceptions.BookAlreadyCheckedoutException;
import com.ghosh.sanjay.exceptions.BookFinePendingException;
import com.ghosh.sanjay.exceptions.BookNotFoundException;
import com.ghosh.sanjay.exceptions.MemberCheckoutLimitExceededException;
import com.ghosh.sanjay.repositories.BookCatalogueRepository;
import com.ghosh.sanjay.util.BookLendingUtil;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BookLendingService.class, BookLendingUtil.class, Registry.class, Ledger.class, BookCatalogueRepository.class})
public class BookLendingServiceTest {

    @Autowired
    private BookLendingService bookLendingService;

    @Autowired
    private Registry registry;

    @Autowired
    private Ledger ledger;

    @Autowired
    private BookLendingUtil bookLendingUtil;

    @MockBean
    private BookCatalogueRepository bookCatalogueRepository;

    private BookItem bookItem1;
    private BookItem bookItem2;

    private Address address1;
    private Address address2;

    private Person person1;
    private Person person2;

    private Member member1;
    private Member member2;

    private BookLending bookLending1;
    private BookLending bookLending2;

    @BeforeEach
    public void before() {
        bookItem1 = BookItem.builder().barcode("1234567890").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();
        bookItem2 = BookItem.builder().barcode("2345678901").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();

        address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
        address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();

        person1 = Person.builder().name("<NAME-1>").address(address1).email("").phone("").build();
        person2 = Person.builder().name("<NAME-2>").address(address2).email("").phone("").build();

        bookLending1 = BookLending.builder().creationDate(null).dueDate(null).returnDate(null).bookItemBarcode("").memberId("1").build();
        bookLending2 = BookLending.builder().creationDate(null).dueDate(null).returnDate(null).bookItemBarcode("").memberId("1").build();

        member1 = new Member();
        member1.setId("1");
        member1.setPassword("");
        member1.setStatus(ACTIVE);
        member1.setPerson(person1);

        member2 = new Member();
        member2.setId("2");
        member2.setPassword("");
        member2.setStatus(ACTIVE);
        member2.setPerson(person1);
    }

    @Test
    public void testNotNull() {
        assertNotNull(registry);
        assertNotNull(ledger);
        assertNotNull(bookLendingService);
    }

    @Test
    public void testCheckoutBookItem() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
        assertTrue(registry.addMember(member1));
        assertTrue(registry.addMember(member2));
        assertTrue(registry.addBookItem(bookItem1));
        assertTrue(bookLendingService.checkoutBookItem(bookItem1, member1));
    }

    @Test
    public void testCheckinBookItemWithoutCheckout() {
        assertFalse(bookLendingService.checkinBookItem(bookItem1, member1));
    }

    @Test
    public void testCheckinBookItem() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
        assertTrue(registry.addMember(member1));
        assertTrue(registry.addMember(member2));
        assertTrue(registry.addBookItem(bookItem2));
        assertTrue(bookLendingService.checkoutBookItem(bookItem2, member2));
        assertTrue(bookLendingService.checkinBookItem(bookItem2, member2));
    }

    @Test
    public void testCheckinBookItemPendingFine() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
        assertTrue(registry.addMember(member1));
        assertTrue(registry.addMember(member2));
        assertTrue(registry.addBookItem(bookItem2));
        assertTrue(bookLendingService.checkoutBookItem(bookItem2, member2));
        assertTrue(bookLendingService.checkinBookItem(bookItem2, member2));
    }

    @Test
    public void testTotalCheckoutBooks() {
        assertEquals(bookLendingService.totalCheckedoutBooks(member1), Integer.valueOf(0));
    }

    @Test
    public void testTotalCheckoutBooks2() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
        assertTrue(registry.addMember(member1));
        assertTrue(registry.addMember(member2));
        assertTrue(registry.addBookItem(bookItem1));
        assertTrue(registry.checkoutBookItem(bookItem1, member1));
        assertEquals(bookLendingService.totalCheckedoutBooks(member1), Integer.valueOf(1));
    }

    @Test
    public void testSearchBook() {
        assertTrue(registry.addBookItem(bookItem1));
        assertTrue(bookLendingService.isBookAvailable(bookItem1.getBarcode()));
    }

    @Test
    public void testFillBookDetails() {
        assertTrue(registry.addBookItem(bookItem1));
        assertTrue(bookLendingService.isBookAvailable(bookItem1.getBarcode()));
        assertEquals(bookLendingService.fetchBookDetails(bookItem1.getBarcode()), bookItem1);
    }

    @AfterEach
    public void after() {
        bookItem1 = null;
        bookItem2 = null;
        address1 = null;
        address2 = null;
        person1 = null;
        person2 = null;
        member1 = null;
        member2 = null;
        registry.resetCache();
    }


}
