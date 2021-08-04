package com.ghosh.sanjay.actor;

import com.ghosh.sanjay.beans.Person;
import com.ghosh.sanjay.enums.AccountStatus;
import lombok.Data;

@Data
public class Account implements RecoverableAccount {

    private String id;
    private String password;
    private AccountStatus status;
    private Person person;


    public boolean resetPassword() {
        return false;
    }

}
