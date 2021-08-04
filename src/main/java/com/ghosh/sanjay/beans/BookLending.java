package com.ghosh.sanjay.beans;

import java.time.ZonedDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookLending {

    private ZonedDateTime creationDate;
    private ZonedDateTime dueDate;
    private ZonedDateTime returnDate;
    private String bookItemBarcode;
    private String memberId;

}
