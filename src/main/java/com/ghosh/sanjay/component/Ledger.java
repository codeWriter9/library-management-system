package com.ghosh.sanjay.component;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.enums.AccountStatus;
import com.ghosh.sanjay.beans.Address;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.beans.BookLending;
import com.ghosh.sanjay.beans.Person;
import com.ghosh.sanjay.exceptions.BookAlreadyCheckedoutException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Ledger {

	private Map<String, BookLending> memberIdToBookLending = new HashMap<>();


	public boolean hasBookFinePending(Member member) {
		return memberIdToBookLending.containsKey( member.getId() );
	}


	public boolean addBookFine(Member member, BookLending bookLending) {
		memberIdToBookLending.put( member.getId(), bookLending );
		return true;
	}


}
