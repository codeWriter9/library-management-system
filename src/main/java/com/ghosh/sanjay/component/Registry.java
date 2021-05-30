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

 	public boolean checkoutBookItem(BookItem bookItem, Member member) throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
		//System.out.println("------------------------");
		//System.out.println(">>>checkoutBookItem<<<");
		//System.out.println(">>>memberIdToCheckout=" + memberIdToCheckout);
		//System.out.println("------------------------");
		if( bookItems.containsKey( bookItem.getBarcode()) && barCodeToCopies.get( bookItem.getBarcode()) != 0 ) {
			if( memberIdToCheckout.containsKey( member.getId()) && memberIdToCheckout.get( member.getId() ).containsKey( bookItem.getBarcode()  ) ) throw new BookAlreadyCheckedoutException();
			else if( memberIdToCheckout.get( member.getId()) != null && !memberIdToCheckout.get( member.getId()).isEmpty() && memberIdToCheckout.get( member.getId()).get( bookItem.getBarcode() ) > MEMBER_CHECKOUT_LIMIT ) throw new MemberCheckoutLimitExceededException();
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
		if( memberIdToCheckout.containsKey( member.getId()) && memberIdToCheckout.get( member.getId() ).containsKey( bookItem.getBarcode() ) ) {
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
			memberIdToBarcode.put(member.getId(), "");
			memberIdToCheckout.put(member.getId(), new HashMap<>());
			//System.out.println("------------------------");
	                //System.out.println(">>>addMember<<<");
			//System.out.println("memberIdToCheckout=" + memberIdToCheckout);
			//System.out.println("------------------------");
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
			return sum;
		}
		return 0;
	}

}
