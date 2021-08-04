package com.ghosh.sanjay.service;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.component.Registry;
import com.ghosh.sanjay.exceptions.BookAlreadyCheckedoutException;
import com.ghosh.sanjay.exceptions.MemberCheckoutLimitExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLendingService {

    @Autowired
    private Registry registry;

    public boolean checkoutBookItem(BookItem bookItem, Member member) throws BookAlreadyCheckedoutException, MemberCheckoutLimitExceededException {
        return registry.checkoutBookItem(bookItem, member);
    }

    public Integer totalCheckedoutBooks(Member member) {
        return registry.totalCheckedoutBooks(member);
    }

    public boolean checkinBookItem(BookItem bookItem, Member member) {
        return registry.checkinBookItem(bookItem, member);
    }

    public boolean isBookAvailable(String barcode) {
        return registry.isBookAvailable(barcode);
    }

    public BookItem fetchBookDetails(String barcode) {
        return registry.fetchBookDetails(barcode);
    }


}
