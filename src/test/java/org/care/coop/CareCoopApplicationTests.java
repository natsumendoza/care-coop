package org.care.coop;

import org.care.coop.ws.CareCoopApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CareCoopApplication.class)
@WebAppConfiguration
public class CareCoopApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Test");
	}

}
