package com.ghosh.sanjay.beans;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


public class AddressTest {

    private Address address1;
    private Address address2;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
        address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
    }

    @Test
    void equalsTest() {
        assertEquals(address1, address2);
    }

    @Test
    void notEqualsTest() {
        assertNotEquals(address1, Address.builder().streetAddress("<No-Name>").city("").state("").zipCode("").country("").build());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
}
