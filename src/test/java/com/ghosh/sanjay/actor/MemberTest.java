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
public class MemberTest {

    private Person person1;
    private Person person2;

    private Address address1;
    private Address address2;

    @Mock
    private Member member;
    private Member member1;
    private Member member2;
    private Member member3;

    @Before
    public void before() {
        address1 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();
        address2 = Address.builder().streetAddress("").city("").state("").zipCode("").country("").build();

        person1 = Person.builder().name("<NAME-1>").address(address1).email("").phone("").build();
        person2 = Person.builder().name("<NAME-2>").address(address2).email("").phone("").build();

        member1 = new Member();
        member1.setId("");
        member1.setPassword("");
        member1.setStatus(ACTIVE);
        member1.setPerson(person1);

        member2 = new Member();
        member2.setId("");
        member2.setPassword("");
        member2.setStatus(ACTIVE);
        member2.setPerson(person1);

        member3 = new Member();
        member3.setId("");
        member3.setPassword("");
        member3.setStatus(ACTIVE);
        member3.setPerson(person2);
    }


    @Test
    public void testRecoverableAccountNotNull() {
        assertNotNull(member);
    }

    @Test
    public void testRecoverablePasswordIsFalse() {
        assertFalse(member.resetPassword());
    }

    @Test
    public void testLibrarianEquals() {
        assertEquals(member1, member2);
    }

    @Test
    public void testLibrarianNotEquals() {
        assertNotEquals(member1, member3);
    }

}
