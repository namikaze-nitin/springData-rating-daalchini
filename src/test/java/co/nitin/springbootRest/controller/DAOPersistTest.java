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
import co.nitin.springbootRest.model.OrderRatings;
import co.nitin.springbootRest.model.OrderRequest;
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
	public void testProductPersisting() {
		
		Assert.assertNotNull(productdao);

		Products prod = new Products();
		prod.setVariant_id("xxxx");
		prod.setVariant_name("Aaloo Chips");
		productdao.save(prod);
		
		Assert.assertNotNull( productdao.findOne(prod.getVariant_id()));
	}
	
	@Test
	public void testOrderPersisting() {

		OrderRequest ordReq = new OrderRequest();
		ordReq.setOrderNo("12345");
		orderRequestdao.save(ordReq);
		
		OrderRatings ordRat1 = new OrderRatings();
		ordRat1.setVariant_id("aaaa");
		ordRat1.setRating_food((byte) 1);
		ordRat1.setRequest(ordReq);
		Assert.assertNotNull( orderRequestdao );
		System.out.println(ordRat1.getVariant_id());
		
		orderRatingsdao.save(ordRat1);
	}


}
