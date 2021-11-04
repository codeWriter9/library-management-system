package com.ghosh.sanjay.controller;

import com.ghosh.sanjay.component.Registry;
import com.ghosh.sanjay.config.AppConfig;
import com.ghosh.sanjay.service.BookCatalogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = {AppConfig.class, BookCatalogueController.class, BookCatalogService.class, Registry.class})
public class BookCatalogueControllerTest {

    @Autowired
    private BookCatalogueController bookCatalogueController;

    @MockBean
    private BookCatalogService bookCatalogService;

    @MockBean
    private Registry registry;

    @Test
    public void testNotNull() {
        assertThat(bookCatalogueController).isNotNull();
        assertThat(bookCatalogService).isNotNull();
        assertThat(registry).isNotNull();
    }
}