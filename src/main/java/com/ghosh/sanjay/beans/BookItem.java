package com.ghosh.sanjay.beans;

import com.ghosh.sanjay.enums.BookFormat;
import com.ghosh.sanjay.enums.BookStatus;

import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static javax.persistence.FetchType.EAGER;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class BookItem extends Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String barcode;
    private boolean referenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    @ManyToOne(targetEntity=Rack.class, fetch= EAGER)
    private Rack placedAt;
    private Integer copies;


}
