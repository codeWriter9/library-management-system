package com.ghosh.sanjay.util;

import static java.time.temporal.ChronoUnit.DAYS;

import com.ghosh.sanjay.beans.BookFine;
import com.ghosh.sanjay.beans.BookLending;


public class BookLendingUtil {

	public static BookFine calculateFine(BookLending bookLending) {
		Double amount = 0.0;
		if(bookLending.getReturnDate() != null && bookLending.getDueDate() != null) {
			amount =  DAYS.between(bookLending.getDueDate(), bookLending.getReturnDate()) * 1.0;
		}
		return BookFine.builder().amount(amount).build();
	}

}
