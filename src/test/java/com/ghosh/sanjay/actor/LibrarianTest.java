package com.ghosh.sanjay.actor;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.slf4j.LoggerFactory.getLogger;

import com.ghosh.sanjay.enums.AccountStatus;
import com.ghosh.sanjay.beans.Address;
import com.ghosh.sanjay.beans.Person;

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
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(MockitoExtension.class)
public class LibrarianTest {
	
	private Person person1;
        private Person person2;

        private Address address1;
        private Address address2;

        @Mock
        private Librarian librarian;
        private Librarian librarian1;
        private Librarian librarian2;
        private Librarian librarian3;

	@BeforeEach
        public void before() {
                address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
                address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();

                person1 = Person.builder().name("<NAME-1>").address(address1).email("").phone("").build();
                person2 = Person.builder().name("<NAME-2>").address(address2).email("").phone("").build();

                librarian1 = new Librarian();
                librarian1.setId("");
                librarian1.setPassword("");
                librarian1.setStatus(ACTIVE);
                librarian1.setPerson(person1);

                librarian2 = new Librarian();
                librarian2.setId("");
                librarian2.setPassword("");
                librarian2.setStatus(ACTIVE);
                librarian2.setPerson(person1);

                librarian3 = new Librarian();
                librarian3.setId("");
                librarian3.setPassword("");
                librarian3.setStatus(ACTIVE);
                librarian3.setPerson(person2);
        }


        @Test
        public void testRecoverableAccountNotNull() {
                assertNotNull( librarian );
        }

        @Test
        public void testRecoverablePasswordIsFalse() {
                assertFalse( librarian.resetPassword() );
        }

        @Test
        public void testLibrarianEquals() {
                assertEquals( librarian1, librarian2 );
        }

        @Test
        public void testLibrarianNotEquals() {
                assertNotEquals( librarian1, librarian3 );
        }
}
