package com.ghosh.sanjay.actor;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.junit.Test;

import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RecoverableAccountTest {

    @Mock
    private RecoverableAccount recoverableAccount;


    @Test
    public void testRecoverableAccountNotNull() {
        assertNotNull(recoverableAccount);
    }

    @Test
    public void testRecoverablePasswordIsFalse() {
        assertFalse(recoverableAccount.resetPassword());
    }
}
