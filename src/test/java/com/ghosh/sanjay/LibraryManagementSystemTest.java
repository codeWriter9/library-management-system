package com.ghosh.sanjay;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import static com.ghosh.sanjay.LibraryManagementSystem.main;

import java.io.IOException;

import com.ghosh.sanjay.LibraryManagementSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Unit test for Entry Point In Application.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LibraryManagementSystemTest {

	private static Logger LOG = getLogger(lookup().lookupClass());
	

	@InjectMocks
	private LibraryManagementSystem application;


	@Before
	public void before() {
		
	}
	
	@Test
	public void checkIfThisRuns() throws Exception {
		try {
			application.run(new String[] {});
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}

	@Test
	public void thisJustChecksIfApplicationStarts() throws IOException {
		try {
			main(new String[] {});
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}

	@After
	public void after() {
	
	}

}
