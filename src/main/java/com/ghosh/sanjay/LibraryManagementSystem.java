package com.ghosh.sanjay;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystem implements CommandLineRunner {

    private static Logger LOG = getLogger(lookup().lookupClass());


    @Override
    public void run(String... args) {
        LOG.info("---Library--Management-System---");
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LibraryManagementSystem.class, args);
    }

}
