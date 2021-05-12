package com.ghosh.sanjay.beans;

import com.ghosh.sanjay.enums.BookFormat;
import com.ghosh.sanjay.enums.BookStatus;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookItem extends Book {
	
	private String barcode;
  	private boolean referenceOnly;
  	private Date borrowed;
  	private Date dueDate;
  	private double price;
	private BookFormat format;
	private BookStatus status;
	private Date dateOfPurchase;
	private Date publicationDate;
	private Rack placedAt;


}
