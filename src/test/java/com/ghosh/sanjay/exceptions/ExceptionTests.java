package com.ghosh.sanjay.exceptions;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;

import static org.junit.jupiter.api.Assertions.*;


import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.beans.Address;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.beans.Person;
import com.ghosh.sanjay.component.Ledger;
import com.ghosh.sanjay.component.Registry;

import com.ghosh.sanjay.service.BookLendingService;
import com.ghosh.sanjay.service.BookCatalogService;
import com.ghosh.sanjay.util.BookLendingUtil;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BookLendingService.class, Registry.class, Ledger.class, BookCatalogService.class, BookLendingUtil.class})
public class ExceptionTests {

    @Autowired
    private Registry registry;

    @Autowired
    private Ledger ledger;

    @Autowired
    private BookLendingService bookLendingService;

    @Autowired
    private BookCatalogService bookCatalogService;

    @Autowired
    private BookLendingUtil bookLendingUtil;

    private BookItem bookItem1;
    private BookItem bookItem2;
    private BookItem bookItem3;
    private BookItem bookItem4;

    private Address address1;
    private Address address2;
    private Address address3;

    private Person person1;
    private Person person2;
    private Person person3;

    private Member member1;
    private Member member2;
    private Member member3;


    @BeforeEach
    public void before() {
        bookItem1 = BookItem.builder().barcode("B1").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(2).build();
        bookItem2 = BookItem.builder().barcode("B2").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();
        bookItem3 = BookItem.builder().barcode("B3").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(2).build();
        bookItem4 = BookItem.builder().barcode("B4").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();

        address1 = Address.builder().streetAddress("sa1").city("c1").state("s1").zipCode("01").country("").build();
        address2 = Address.builder().streetAddress("sa2").city("c2").state("s2").zipCode("02").country("").build();
        address2 = Address.builder().streetAddress("sa3").city("c3").state("s3").zipCode("03").country("").build();

        person1 = Person.builder().name("P1").address(address1).email("").phone("").build();
        person2 = Person.builder().name("P2").address(address2).email("").phone("").build();
        person3 = Person.builder().name("P3").address(address2).email("").phone("").build();

        member1 = new Member();
        member1.setId("1");
        member1.setPassword("");
        member1.setStatus(ACTIVE);
        member1.setPerson(person1);

        member2 = new Member();
        member2.setId("2");
        member2.setPassword("");
        member2.setStatus(ACTIVE);
        member2.setPerson(person2);

        member2 = new Member();
        member2.setId("3");
        member2.setPassword("");
        member2.setStatus(ACTIVE);
        member2.setPerson(person3);
    }

    @Test
    public void testNotNull() {
        assertNotNull(registry);
        assertNotNull(bookLendingService);
    }


    @Test
    public void testCheckoutBookItem() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
        assertTrue(registry.addMember(member1));
        assertTrue(registry.addBookItem(bookItem1));
        assertTrue(registry.checkoutBookItem(bookItem1, member1));
        assertThrows(BookAlreadyCheckedoutException.class, () -> registry.checkoutBookItem(bookItem1, member1));
    }


    @Test
    public void testCheckoutBookItem2() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
        assertTrue(registry.addMember(member1));
        assertTrue(registry.addBookItem(bookItem1));
        assertTrue(registry.addBookItem(bookItem2));
        assertTrue(registry.addBookItem(bookItem3));
        assertTrue(registry.addBookItem(bookItem4));
        assertTrue(registry.checkoutBookItem(bookItem1, member1));
        assertTrue(registry.checkoutBookItem(bookItem2, member1));
        assertTrue(registry.checkoutBookItem(bookItem3, member1));
        assertThrows(MemberCheckoutLimitExceededException.class, () -> registry.checkoutBookItem(bookItem4, member1));
    }

    @Test
    public void testBookFinePending() throws BookFinePendingException {
    }


    @AfterEach
    public void after() {
        bookItem1 = null;
        bookItem2 = null;
        bookItem3 = null;
        bookItem4 = null;
        address1 = null;
        address2 = null;
        address3 = null;
        person1 = null;
        person2 = null;
        person3 = null;
        member1 = null;
        member2 = null;
        member3 = null;
        registry.resetCache();
    }


}
