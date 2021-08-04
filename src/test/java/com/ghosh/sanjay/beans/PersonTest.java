package com.ghosh.sanjay.beans;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


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
    void equasTest() {
        assertEquals(person1, person2);
    }

    @Test
    void notEqualsTest() {
        assertNotEquals(person1, Person.builder().name("<No-Name>").address(address2).email("").phone("").build());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
}
