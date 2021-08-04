package com.ghosh.sanjay.actor;

import static com.ghosh.sanjay.enums.AccountStatus.ACTIVE;
import static org.junit.jupiter.api.Assertions.*;


import com.ghosh.sanjay.beans.Address;
import com.ghosh.sanjay.beans.Person;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class AccountTest {

    private Person person1;
    private Person person2;

    private Address address1;
    private Address address2;

    @Mock
    private Account account;
    private Account account1;
    private Account account2;
    private Account account3;

    @Before
    public void before() {
        address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
        address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();

        person1 = Person.builder().name("<NAME-1>").address(address1).email("").phone("").build();
        person2 = Person.builder().name("<NAME-2>").address(address2).email("").phone("").build();

        account1 = new Account();
        account1.setId("");
        account1.setPassword("");
        account1.setStatus(ACTIVE);
        account1.setPerson(person1);

        account2 = new Account();
        account2.setId("");
        account2.setPassword("");
        account2.setStatus(ACTIVE);
        account2.setPerson(person1);

        account3 = new Account();
        account3.setId("");
        account3.setPassword("");
        account3.setStatus(ACTIVE);
        account3.setPerson(person2);
    }


    @Test
    public void testRecoverableAccountNotNull() {
        assertNotNull(account);
    }

    @Test
    public void testRecoverablePasswordIsFalse() {
        assertFalse(account.resetPassword());
    }

    @Test
    public void testAccountEquals() {
        assertEquals(account1, account2);
    }

    @Test
    public void testAccountNotEquals() {
        assertNotEquals(account1, account3);
    }


}
