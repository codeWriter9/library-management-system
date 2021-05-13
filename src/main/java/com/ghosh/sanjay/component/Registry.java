package com.ghosh.sanjay.component;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;
import static com.ghosh.sanjay.enums.AccountStatus.BLOCKED;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.beans.BookItem;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Registry {

	private Map<String, BookItem> bookItems = new HashMap<>();
	private Map<String, Member> members = new HashMap<>();

	void resetCache() {
		bookItems.clear();
		members.clear();
	}

	public boolean addBookItem(BookItem bookItem) {
		if(!bookItems.containsKey(bookItem.getBarcode())) {
                        bookItems.put(bookItem.getBarcode(), bookItem);
                        return true;
                }
                return false;
	}

 	public boolean checkoutBookItem(BookItem bookItem) {
		if(bookItems.containsKey(bookItem.getBarcode()) && bookItems.get(bookItem.getBarcode()) != null) {
			bookItems.put(bookItem.getBarcode(), null);
			return true;
		}
		return false;
	}

	public boolean addMember(Member member) {
		if(!members.containsKey(member.getId())) {
                        members.put(member.getId(), member);
                        return true;
                }
                return false;
	}

	public boolean blockMember(Member member) {
		if(members.containsKey(member.getId()) && members.get(member.getId()) != null) {
			member.setStatus(BLOCKED);
			members.put(member.getId(), member);
			return true;
		}
		return false;
	}

	public boolean unBlockMember(Member member) {
		if(members.containsKey(member.getId()) && members.get(member.getId()) != null) {
                        member.setStatus(ACTIVE);
                        members.put(member.getId(), member);
                        return true;
                }
		return false;
	}


}
