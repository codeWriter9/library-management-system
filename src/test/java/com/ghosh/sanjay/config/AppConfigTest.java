package com.ghosh.sanjay.config;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.Assert.assertNotNull;
import static org.slf4j.LoggerFactory.getLogger;


@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppConfigTest {

	private static Logger LOG = getLogger(lookup().lookupClass());	

	@Test
	public void contextLoads() {
		LOG.info("context Loads");
	}
}

