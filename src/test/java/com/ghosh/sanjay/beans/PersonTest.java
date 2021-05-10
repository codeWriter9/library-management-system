package com.ghosh.sanjay.beans;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test; // collides with Junit 5 Jupiter Test
import org.junit.runner.RunWith;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;  // collides with junit 4 Test
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

public class PersonTest {

    private Person person1;
    private Person person2;

    private Address address1;
    private Address address2;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
	address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
        address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();

        person1 = Person.builder().name("").address(address1).email("").phone("").build();
	person2 = Person.builder().name("").address(address2).email("").phone("").build();
    }

    @Test
    void succeedingTest() {
	assertEquals( person1, person2 );
    }

    @Test
    void failingTest() {
        //fail("a failing test"); // -- This Test will Fail 
    }

    //@Test
    //@Disabled("for demonstration purposes")  //  -- uncommenting will lead to failure
    //void skippedTest() {
        // not executed
    //}

    //@Test
    //void abortedTest() {
        //assumeTrue("abc".contains("Z"));
        //fail("test should have been aborted");
    //}

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
}
