package com.ghosh.sanjay.controller;

import com.ghosh.sanjay.service.BookCatalogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/catalogue")
@Api(value = "Guidelines")
@Slf4j
public class BookCatalogueController {

    @Autowired
    private BookCatalogService bookCatalogueService;

}
