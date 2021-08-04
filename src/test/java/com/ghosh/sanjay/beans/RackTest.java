package com.ghosh.sanjay.beans;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


public class RackTest {

    private Rack rack1;
    private Rack rack2;

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
        rack1 = Rack.builder().number(0).locationIdentifier("").build();
        rack2 = Rack.builder().number(0).locationIdentifier("").build();

    }

    @Test
    void equalsTest() {
        assertEquals(rack1, rack2);
    }

    @Test
    void notEqualsTest() {
    }


    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
}
