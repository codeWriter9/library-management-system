package com.ghosh.sanjay;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LibraryManagementSystem implements CommandLineRunner {


    @Override
    public void run(String... args) {
        log.info("---Library--Management-System---");
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LibraryManagementSystem.class, args);
    }

}