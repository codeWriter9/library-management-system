package com.ghosh.sanjay.beans;


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

}
