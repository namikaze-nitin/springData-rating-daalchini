package co.nitin.springbootRest.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.nitin.springbootRest.dao.OrderRatingsDAO;
import co.nitin.springbootRest.dao.OrderRequestDAO;
import co.nitin.springbootRest.dao.OrdersDAO;
import co.nitin.springbootRest.dao.ProductsDAO;
import co.nitin.springbootRest.model.Products;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class DAOPersistTest {

	private Logger log = LoggerFactory.getLogger(OrderRequestRatingControllerTest.class);
	
	@Autowired private OrderRequestRatingController ordController;
	@Autowired private ProductsDAO productdao;
	@Autowired private OrderRatingsDAO orderRatingsdao;
	@Autowired private OrderRequestDAO orderRequestdao;
	@Autowired private OrdersDAO ordersDao;

	@Test
	public void testDatabaseController() {
		
		Assert.assertNotNull(productdao);

		Products prod = new Products();
		prod.setVariant_id("xxxx");
		prod.setVariant_name("Aaloo Chips");
		productdao.save(prod);
		
		Assert.assertNotNull( productdao.findOne(prod.getVariant_id()));
	}

}
