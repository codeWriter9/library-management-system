package com.ghosh.sanjay.beans;

import lombok.Data;

@Data
public class Book {


	private String ISBN;
	private String title;
	private String subject;
	private String publisher;
	private String language;
	private int numberOfPages;
	
}
