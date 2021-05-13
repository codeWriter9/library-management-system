package com.ghosh.sanjay.service;

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
import com.ghosh.sanjay.component.Registry;

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
@ContextConfiguration(classes = {BookLendingService.class, Registry.class})
public class BookLendingServiceTest {
	
	@Autowired
	private BookLendingService bookLendingService;

	@Autowired
	private Registry registry;
	
	 private BookItem bookItem1;
        private BookItem bookItem2;

        private Address address1;
        private Address address2;

        private Person person1;
        private Person person2;

        private Member member1;
        private Member member2;

        @BeforeEach
        public void before() {
                bookItem1 = BookItem.builder().barcode("").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();
                bookItem2 = BookItem.builder().barcode("").referenceOnly(false).borrowed(null).dueDate(null).price(0.0).copies(1).build();

                address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
                address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();

                person1 = Person.builder().name("<NAME-1>").address(address1).email("").phone("").build();
                person2 = Person.builder().name("<NAME-2>").address(address2).email("").phone("").build();

                member1 = new Member();
                member1.setId("");
                member1.setPassword("");
                member1.setStatus(ACTIVE);
                member1.setPerson(person1);

                member2 = new Member();
                member2.setId("");
                member2.setPassword("");
                member2.setStatus(ACTIVE);
                member2.setPerson(person1);
        }

        @Test
        public void testNotNull() {
		assertNotNull( registry );
                assertNotNull( bookLendingService );
        }

	@Test
	public void testCheckoutBookItem() {
		registry.addBookItem( bookItem1 );
		assertTrue( bookLendingService.checkoutBookItem( bookItem1 ) );
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
        }	
	

}
