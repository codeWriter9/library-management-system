package com.ghosh.sanjay.repositories;


import com.ghosh.sanjay.beans.Rack;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.ghosh.sanjay.beans.BookItem.builder;
import static com.ghosh.sanjay.enums.BookStatus.AVAILABLE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class BookCatalogueRepositoryTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookCatalogueRepository bookCatalogueRepository;

    @Before
    public void before() {
        Assertions.assertThat(bookCatalogueRepository).isNotNull();
    }

    @Test
    public void testBookItemById() {
        bookCatalogueRepository.save(builder().id(1L).copies(2).status(AVAILABLE).barcode("123")
                .placedAt(Rack.builder().id(22L).locationIdentifier("XYZ").number(22).build()).build());
        assertThat(bookCatalogueRepository.findById(1)).isNotNull().isEqualTo(builder().id(1L).copies(2).status(AVAILABLE).barcode("123")
                .placedAt(Rack.builder().id(22L).locationIdentifier("XYZ").number(22).build()).build());
    }

    @Test
    public void testBookItemByBarcode() {
        bookCatalogueRepository.save(builder().id(1L).copies(2).status(AVAILABLE).barcode("123")
                .placedAt(Rack.builder().id(22L).locationIdentifier("XYZ").number(22).build()).build());
        assertThat(bookCatalogueRepository.findByBarcode("123")).isNotNull().isEqualTo(builder().id(1L).copies(2).status(AVAILABLE).barcode("123")
                .placedAt(Rack.builder().id(22L).locationIdentifier("XYZ").number(22).build()).build());
    }

    @After
    public void after() {

    }
}
