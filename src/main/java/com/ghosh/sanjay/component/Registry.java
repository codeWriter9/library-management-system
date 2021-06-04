package com.ghosh.sanjay.component;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;
import static com.ghosh.sanjay.enums.AccountStatus.BLOCKED;
import static com.ghosh.sanjay.constants.Constants.MEMBER_CHECKOUT_LIMIT;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.exceptions.BookAlreadyCheckedoutException;
import com.ghosh.sanjay.exceptions.MemberCheckoutLimitExceededException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Registry {

	private Map<String, BookItem> bookItems = new HashMap<>();
	private Map<String, Member> members = new HashMap<>();
	private Map<String, Integer> barCodeToCopies = new HashMap<>();
	private Map<String, Integer> memberIdToFines = new HashMap<>();
	private Map<String, Map<String, Integer>> memberIdToCheckout = new HashMap<>();
	private Map<String, String> memberIdToBarcode = new HashMap<>();

	public void resetCache() {
		bookItems.clear();
		members.clear();
		barCodeToCopies.clear();
		memberIdToFines.clear();
		memberIdToCheckout.clear();
		memberIdToBarcode.clear();
	}

	public BookItem fetchBookDetails(String barcode) {		
		return bookItems.get( barcode );
	}

	public boolean isBookAvailable( String barcode ) {
		if(barcode != null && !"".equals(barcode)) {
			if( bookItems.get( barcode ) != null ) {
				return true;
			} 
		}
		return false;
	}
	

	public boolean addBookItem(BookItem bookItem) {
		if(!bookItems.containsKey(bookItem.getBarcode())) {
                        bookItems.put(bookItem.getBarcode(), bookItem);
			barCodeToCopies.put(bookItem.getBarcode(), bookItem.getCopies());
                        return true;
                }
                return false;
	}

	public boolean hasMemberCheckedOutBook(Member member) {
		return  memberIdToCheckout.containsKey( member.getId());
	}

	public Map<String, Integer> booksCheckedOutByMember(String memberId) {
		return  memberIdToCheckout.get( memberId );
	}
	

 	public boolean checkoutBookItem(BookItem bookItem, Member member) throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
		if( bookItems.containsKey( bookItem.getBarcode()) && barCodeToCopies.get( bookItem.getBarcode()) != 0 ) {
			if( hasMemberCheckedOutBook( member ) 
				&& booksCheckedOutByMember( member.getId() ).containsKey( bookItem.getBarcode()  ) ) { 
					throw new BookAlreadyCheckedoutException();
			}
			else if( totalCheckedoutBooks( member ) >= MEMBER_CHECKOUT_LIMIT )
					throw new MemberCheckoutLimitExceededException();
                        else {
				barCodeToCopies.put(bookItem.getBarcode(), barCodeToCopies.get(bookItem.getBarcode()) - 1);
	                        memberIdToBarcode.put(bookItem.getBarcode(), member.getId());
				Map booksForMemberId = memberIdToCheckout.get(member.getId());
				booksForMemberId.put( bookItem.getBarcode(), 1);
				memberIdToCheckout.put(member.getId(), booksForMemberId);
			}
			return true;
		}
		return false;
	}


	public boolean checkinBookItem(BookItem bookItem, Member member) {
		if( hasMemberCheckedOutBook( member ) && booksCheckedOutByMember( member.getId() ).containsKey( bookItem.getBarcode() ) ) {
			barCodeToCopies.put(bookItem.getBarcode(), barCodeToCopies.get(bookItem.getBarcode()) + 1);
			memberIdToCheckout.put(member.getId(), memberIdToCheckout.get(member.getId()));
			memberIdToBarcode.put(member.getId(), bookItem.getBarcode());
			return true;
		}
		return false;
	}

	public boolean addMember(Member member) {
		if(!members.containsKey(member.getId())) {
                        members.put(member.getId(), member);
			memberIdToBarcode.put(member.getId(), null);
			memberIdToCheckout.put(member.getId(), new HashMap<>());
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

	public Integer totalCheckedoutBooks(Member member) {
		if(memberIdToCheckout.containsKey(member.getId())) {
			Integer sum = 0;
			for(String barcode : memberIdToCheckout.get(member.getId()).keySet()) {
				sum = sum +  memberIdToCheckout.get(member.getId()).get(barcode);
			}
			return sum;
		}
		return 0;
	}

}
