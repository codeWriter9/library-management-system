package com.ghosh.sanjay.component;


import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.beans.BookLending;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Ledger {

    private Map<String, BookLending> memberIdToBookLending = new HashMap<>();


    public boolean hasBookFinePending(Member member) {
        return memberIdToBookLending.containsKey(member.getId());
    }


    public boolean addBookFine(Member member, BookLending bookLending) {
        memberIdToBookLending.put(member.getId(), bookLending);
        return true;
    }


}
