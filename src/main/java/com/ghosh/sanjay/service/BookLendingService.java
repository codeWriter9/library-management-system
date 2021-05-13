package com.ghosh.sanjay.service;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.component.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLendingService {
	
	@Autowired
	private Registry registry;


	public boolean checkoutBookItem(BookItem bookItem) {
		return registry.checkoutBookItem( bookItem );
	}

}
