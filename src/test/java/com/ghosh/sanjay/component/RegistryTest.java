package com.ghosh.sanjay.component;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.slf4j.LoggerFactory.getLogger;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.enums.AccountStatus;
import com.ghosh.sanjay.beans.Address;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.beans.Person;
import com.ghosh.sanjay.exceptions.BookAlreadyCheckedoutException;
import com.ghosh.sanjay.exceptions.BookNotFoundException;
import com.ghosh.sanjay.exceptions.MemberCheckoutLimitExceededException;

import java.io.IOException;

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

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Registry.class})
public class RegistryTest {

	@Autowired
	private Registry registry;
	
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
                bookItem1 = BookItem.builder().barcode("1234567890").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(2).build();
                bookItem2 = BookItem.builder().barcode("1234567891").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();
		bookItem3 = BookItem.builder().barcode("1234567892").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(2).build();
                bookItem4 = BookItem.builder().barcode("1234567893").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();

                address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
                address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
		address3 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();

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

		member3 = new Member();
                member3.setId("3");
                member3.setPassword("");
                member3.setStatus(ACTIVE);
                member3.setPerson(person3);
        }

        @Test
        public void testNotNull() {
                assertNotNull( registry );
        }

        @Test
        public void testAddBookItem() {
		assertTrue( registry.addBookItem( bookItem2 ) );
        }

	@Test
	public void testCheckoutBookItem() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException  {
		assertTrue( registry.addMember( member1 ) );
		assertTrue( registry.addBookItem( bookItem1 ) );
		assertTrue( registry.checkoutBookItem( bookItem1, member1 ) );
	}

	@Test
	public void testCheckinBookItemWithoutCheckout() {
		assertFalse( registry.checkinBookItem( bookItem1, member1 ) );
	}

	@Test
        public void testCheckinBookItem() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
		assertTrue( registry.addMember( member1 ) );
		assertTrue( registry.addMember( member2 ) );
		assertTrue( registry.addBookItem( bookItem2 ) );
		assertTrue( registry.checkoutBookItem( bookItem2, member2 ) );
		assertTrue( registry.checkinBookItem( bookItem2, member2 ) );
        }
	
	@Test
	public void testAddMember() {
		assertTrue( registry.addMember( member1 ) );
	}

	@Test
	public void testHasMember() {
		assertTrue( registry.addMember( member1 ) );
		assertNotNull( registry.booksCheckedOutByMember( "1" ) );
	}

	@Test
        public void testBlockMember() {
		registry.addMember( member1 );
		assertTrue( registry.blockMember( member1  ) );
        }

        @Test
        public void testUnBlockMember() {
		assertTrue( registry.addMember( member1 ) );
                assertTrue( registry.blockMember( member1  ) );
		assertTrue( registry.unBlockMember( member1 ) );
        }

	@Test
	public void testRegistryHasMember() {
		assertTrue( registry.addMember( member1 ) );
                assertTrue( registry.addMember( member2 ) );
		assertTrue( registry.hasMemberCheckedOutBook( member1 ) );
		assertTrue( registry.hasMemberCheckedOutBook( member2 ) );
		assertFalse( registry.hasMemberCheckedOutBook( member3 ) );
	}


	@Test
	public void testTotalCheckoutBooks() {
		assertEquals( registry.totalCheckedoutBooks( member1 ), Integer.valueOf(0));
	}

	@Test
        public void testTotalCheckoutBooks2() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
		assertTrue( registry.addMember( member1 ) );
                assertTrue( registry.addMember( member2 ) );
		assertTrue( registry.addBookItem( bookItem1 ) );
                assertTrue( registry.checkoutBookItem( bookItem1, member1 ) );
                assertEquals( registry.totalCheckedoutBooks( member1 ), Integer.valueOf(1));
        }

	@Test
        public void testTotalCheckoutBooks3() throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
		assertTrue( registry.addMember( member1 ) );
                assertTrue( registry.addMember( member2 ) );
                assertTrue( registry.addBookItem( bookItem1 ) );
		assertTrue( registry.addBookItem( bookItem2 ) );
		assertTrue( registry.addBookItem( bookItem3 ) );
		assertTrue( registry.addBookItem( bookItem4 ) );
                assertTrue( registry.checkoutBookItem( bookItem1, member1 ) );
		assertTrue( registry.checkoutBookItem( bookItem2, member1 ) );
		assertTrue( registry.checkoutBookItem( bookItem3, member1 ) );		
                assertEquals( registry.totalCheckedoutBooks( member1 ), Integer.valueOf(3));
        }

	@Test
	public void testSearchBook() throws BookNotFoundException {
		assertTrue( registry.addBookItem( bookItem1 ) );
		assertTrue( registry.isBookAvailable( bookItem1.getBarcode() ) );
	}

	@Test
	public void testFillBookDetails() {
		assertTrue( registry.addBookItem( bookItem1 ) );
		assertTrue( registry.isBookAvailable( bookItem1.getBarcode() ) );
		assertEquals( registry.fetchBookDetails( bookItem1.getBarcode()), bookItem1 );
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
