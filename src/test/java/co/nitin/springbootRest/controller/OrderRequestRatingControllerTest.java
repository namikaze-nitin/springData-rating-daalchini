package co.nitin.springbootRest.controller;

import java.util.ArrayList;
import java.util.List;

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
@AutoConfigureMockMvc
public class OrderRequestRatingControllerTest {

	private Logger log = LoggerFactory.getLogger(OrderRequestRatingControllerTest.class);
	
	@Value("${local.server.port}")
	private int port;
	
	@Autowired private OrderRequestRatingController ordController;
	@Autowired private ProductsDAO productdao;
	@Autowired private OrderRatingsDAO orderRatingsdao;
	@Autowired private OrderRequestDAO orderRequestdao;
	@Autowired private OrdersDAO ordersDao;
	@Autowired private MockMvc mockMvc;
	
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
	
	
	@Test
	public void testDatabaseController() {
		
		Assert.assertNotNull(productdao);

		Products prod = new Products();
		prod.setVariant_id("xxxx");
		prod.setVariant_name("Aaloo Chips");
		productdao.save(prod);
		
		Assert.assertNotNull( productdao.findOne(prod.getVariant_id()));
	}
	
	@Test
	public void testPersistingRatings() {

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
	
	@Test
	public void testControllerFunctioning() {

		List <OrderRatings>list = new ArrayList<>();
		
		Products prod = new Products();
		prod.setVariant_id("aaaa");
		prod.setVariant_name("Aaloo Chips");
		productdao.save(prod);

		OrderRequest ordReq = new OrderRequest();
		ordReq.setApiName("giveitemrating");
		ordReq.setApiVersion(1.0);
		ordReq.setOrderNo("737521F547D00D26");
		ordReq.setRateOverAllExperience(4);
		orderRequestdao.save(ordReq);
		
		OrderRatings ordRat1 = new OrderRatings();
		ordRat1.setRating_food((byte) 1);
		ordRat1.setVariant_id("aaaa");
		list.add(ordRat1);

		OrderRatings ordRat2 = new OrderRatings();
		ordRat2.setRating_food((byte) 1);
		ordRat2.setVariant_id("bbbb");
		list.add(ordRat2);
		
		OrderRatings ordRat3 = new OrderRatings();
		ordRat3.setRating_food((byte) 0);
		ordRat3.setVariant_id("cccc");
		list.add(ordRat3);
		
		ordRat1.setRequest(ordReq);
		ordRat2.setRequest(ordReq);
		ordRat3.setRequest(ordReq);

		orderRatingsdao.save(list);

		//       OrderRequest req = new OrderRequest();
        Assert.assertNotNull( mockMvc );
		Assert.assertNotNull( productdao.findOne(prod.getVariant_id()) );
		Assert.assertEquals( orderRatingsdao.findOne("aaaa").getRating_food() , 1);
	}
}
