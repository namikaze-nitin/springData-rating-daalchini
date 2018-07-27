package co.nitin.springbootRest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class APIControllerTest {

	private Logger log = LoggerFactory.getLogger(APIControllerTest.class);
	
	@Autowired private OrderRequestRatingController ordController;
	@Autowired private ProductsDAO productdao;
	@Autowired private OrderRatingsDAO orderRatingsdao;
	@Autowired private OrderRequestDAO orderRequestdao;
	@Autowired private OrdersDAO ordersDao;
	@Autowired private MockMvc mockMvc;
	@Autowired ObjectMapper mapper;
	@Test
	public void testControllerWorkingJson() throws Exception {
		
		List <OrderRatings>list = new ArrayList<>();
		
		//Saving product
		Products prod = new Products();
		prod.setVariant_id("aaaa");
		prod.setVariant_name("Aaloo Chips");
		productdao.save(prod);
		
		//Saving OrderRequest
		OrderRequest ordReq = new OrderRequest();
		ordReq.setApiName("giveitemrating");
		ordReq.setApiVersion(1.0);
		ordReq.setOrderNo("737521F547D00D26");
		ordReq.setRateOverAllExperience(4);
		
		//Saving Ratings
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

		ordReq.setRatings(list);
		orderRequestdao.save(ordReq);
		orderRatingsdao.save(list);
		
		Assert.assertNotNull(mockMvc);		
		
		mockMvc.perform(post("/rating")
					.contentType("application/json;charset=UTF-8")
					.content(mapper.writeValueAsString(ordReq)));
				
	}
}
