package com.ghosh.sanjay.service;

import com.ghosh.sanjay.actor.Member;
import com.ghosh.sanjay.beans.BookItem;
import com.ghosh.sanjay.component.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCatalogService {

    @Autowired
    private Registry registry;

    public boolean addBookItem(BookItem bookItem) {
        return registry.addBookItem(bookItem);
    }

    public boolean blockMember(Member member) {
        return registry.blockMember(member);
    }

    public boolean unBlockMember(Member member) {
        return registry.unBlockMember(member);
    }

}
