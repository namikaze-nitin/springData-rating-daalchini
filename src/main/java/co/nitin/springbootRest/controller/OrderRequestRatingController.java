package co.nitin.springbootRest.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.nitin.springbootRest.model.OrderRatings;
import co.nitin.springbootRest.model.OrderRequest;
import co.nitin.springbootRest.model.OrderResponse;
import co.nitin.springbootRest.service.OrderRatingsService;
import co.nitin.springbootRest.service.OrderRequestService;
import co.nitin.springbootRest.service.OrdersService;
import co.nitin.springbootRest.service.ProductsService;

/**
 * Class is a {@link RestController} that accepts an {@link OrderRequest} and returns an {@link OrderResponse}.
 * </br>
 * One order can have multiple products.
 * </br>
 * Every {@link OrderRequest} consist of one {@link OrderRatings} per product in that order.
 * </br>
 * Every order can be provided a rating by the user and this controller handles actions to be carried out on them.
 * @author Nitin Sharma
 *
 */
@RestController
public class OrderRequestRatingController {

	private OrderRatingsService orderRatingsService;
	private OrderRequestService orderRequestService;
	private OrdersService ordersSevice;
	private ProductsService productsService;
	
	Logger log = LoggerFactory.getLogger(OrderRequestRatingController.class);

	/**
	 * Constructor to autowire data members belonging to {@link OrderRequestService}, {@link OrderRatingsService}, {@link ProductsService} and {@link OrdersService}.
	 * Constructor injection is preferred over field injection in spring development.
	 * </br>
	 * Steps in working : Sequential condition to be satisfied :
	 * </br>
	 * 1) OrderNo sent in request should exist in database.</br>
	 * 2) Ratings corresponding to that OrderNo should not be there.</br>
	 * 3) Product whose rating is to be saved should be available in database.</br>
	 * 
	 * @param orderRatingsService : {@link OrderRatingsService}
	 * @param orderRequestService : {@link OrderRequestService}
	 * @param ordersSevice : {@link OrdersService}
	 * @param productsService : {@link ProductsService}
	 */
	@Autowired
	public OrderRequestRatingController(OrderRatingsService orderRatingsService, OrderRequestService orderRequestService, OrdersService ordersSevice, ProductsService productsService) {

		this.orderRatingsService = orderRatingsService;
		this.orderRequestService = orderRequestService;
		this.ordersSevice = ordersSevice;
		this.productsService = productsService;
	}
	
	private static String SUCCESS_STATUS = "SUCCESS";
	private static String SUCCESS_STATUS_CODE = "SS_0001";
	private static String SUCCESS_STATUS_MESSAGE = "SS_0001";	
	private static String ERROR_STATUS = "ERROR";
	private static String ERROR_STATUS_CODE = "ER_0001";
	private static String ERROR_STATUS_MESSAGE = "ER_0001";
	
	/**
	 * Method 'orderRequestRatingController' accepts json object as its param and returns a success or failure 
	 * message in json format depending on the type of request made.
	 * </br>
	 * One order can have multiple products.
	 * </br>
	 * Every {@link OrderRequest} consist of one {@link OrderRatings} per product in that order.
	 * </br>
	 * Every order can be provided a rating by the user and this controller handles actions to be carried out on them.
	 * </br>
	 * 
	 * @author Nitin Sharma
	 * @param ordReq : {@link OrderRequest}
	 * @return : {@link OrderResponse}
	 */
	@RequestMapping(value = "/rating", method=RequestMethod.POST)
	public OrderResponse orderRequestRatingController(@RequestBody OrderRequest ordReq) {
		
		log.info("[orderRequestRatingController]");
		
		Set<OrderRatings> failedRatings = new HashSet<OrderRatings>();//add those ratings here for which object does not exist
		OrderResponse ordRes = new OrderResponse();
		
		try {
			if(ordReq != null) {
				
				String orderNoFromJson = ordReq.getOrderNo();
	
				if(	this.ordersSevice.getOrdersById(orderNoFromJson) != null ) {//Check if an Order with that orderNo exists
					if(	!this.orderRatingsService.hasOrderRatingsByOrdersNo( orderNoFromJson )) {//If rating of that orderNo does not exist

						this.orderRequestService.saveOrderRequest(ordReq);
						
						//Persist per item Rating of the Request
						List<OrderRatings> listRatings = ordReq.getRatings();
						int i = 0;

						while(i < listRatings.size()) {
					
							OrderRatings currRating = listRatings.get(i);
							
							if( this.productsService.hasProductByProductId( currRating.getVariant_id() ) ) {// check if that product exist in database
								currRating.setRequest(ordReq);
								i++;
							}
							else {
								failedRatings.add( currRating );
								listRatings.remove( currRating );//remove current ratings from list of ratings to be persisted into database
							}
						}			
						this.orderRatingsService.saveAllOrderRatings( listRatings );//save ratings one at a time, OR create a list of those ratings that can be persisted and then save all.						

						ordRes.setStatus(OrderRequestRatingController.SUCCESS_STATUS);
						ordRes.setStatusCode(OrderRequestRatingController.SUCCESS_STATUS_CODE);
						ordRes.setStatusMessage(OrderRequestRatingController.SUCCESS_STATUS_MESSAGE);		
  
						if(!failedRatings.isEmpty())
							for(OrderRatings rat : failedRatings)
								log.error(" [orderRequestRatingController] : Error adding rating : product : [" + rat + "] doesnt exist in inventory");

						return ordRes;
						
					} else log.error(" [orderRequestRatingController] : Ratings corresponding to orderNo : ["  + orderNoFromJson +"] already exist");
				} else log.error(" [orderRequestRatingController] : Order with orderNo : [" + orderNoFromJson + "] does not exist ");
			} else log.error(" [orderRequestRatingController] : OrderRequest is empty ");
		}
		catch(Exception e) {
			
			if(!failedRatings.isEmpty())
				for(OrderRatings rat : failedRatings)
					log.error(" [orderRequestRatingController] : Error adding rating : product doesnt exist : " + rat);
				
			e.printStackTrace();
		}
		
		ordRes.setStatus(OrderRequestRatingController.ERROR_STATUS);
		ordRes.setStatusCode(OrderRequestRatingController.ERROR_STATUS_CODE);
		ordRes.setStatusMessage(OrderRequestRatingController.ERROR_STATUS_MESSAGE);		
		
		return ordRes;
	}
}