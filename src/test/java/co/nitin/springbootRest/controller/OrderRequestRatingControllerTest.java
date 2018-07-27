package co.nitin.springbootRest.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class OrderRequestRatingControllerTest {

	private Logger log = LoggerFactory.getLogger(OrderRequestRatingControllerTest.class);
	
	@Value("${local.server.port}")
	private int port;
	
	@Autowired private OrderRequestRatingController ordController;
	
	@Test
	public void controllerLoad() {
		
		log.info("[controllerLoad]");
		Assert.assertNotNull(this.ordController);
	}
	
	@Test
	public void testServerPort() {
		
		log.info("[testServerPort]");
		Assert.assertEquals(port, 8080);
	}
	//TODO create another test using in built database class
}
