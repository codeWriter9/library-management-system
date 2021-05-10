package com.ghosh.sanjay.actor;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test; // collides with Junit 5 Jupiter Test
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;  // collides with junit 4 Test
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class RecoverableAccountTest {

	@Mock 
	private RecoverableAccount recoverableAccount;


	@Test
	public void testRecoverableAccountNotNull() {
		assertNotNull( recoverableAccount );
	}

	@Test
	public void testRecoverablePasswordIsFalse() {
		assertFalse( recoverableAccount.resetPassword() );
	}
}
