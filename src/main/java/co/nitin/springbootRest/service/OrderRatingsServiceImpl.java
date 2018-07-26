package co.nitin.springbootRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.nitin.springbootRest.dao.OrderRatingsDAO;
import co.nitin.springbootRest.model.OrderRatings;
import co.nitin.springbootRest.model.Orders;

/**
 * Service class for {@link OrderRatingsDAO}
 * 
 * @author Nitin Sharma
 *
 */
@Service
public class OrderRatingsServiceImpl implements OrderRatingsService{

	private OrderRatingsDAO orderRatingsDAO;
	
	/**
	 * Constructor to autowire an object of {@link OrderRatingsDAO}
	 * </br>
	 * Constructor injection is prefered over field injection in spring development.
	 *  
	 * @param orderRatingsDAO
	 */
	@Autowired
	public OrderRatingsServiceImpl(OrderRatingsDAO orderRatingsDAO) {
		this.orderRatingsDAO = orderRatingsDAO;		
	}

	/**
	 * Sevice method to persist {@link OrderRatings} object into database.
	 * 
	 * @see OrderRatingsDAO
	 * @author Nitin Sharma
	 */
	@Override
	public void saveOrderRatings(OrderRatings rating) {
		this.orderRatingsDAO.save(rating);
	}

	/**
	 * Service method to check whether User has already given ratings for products in a particular {@link Orders} .
	 * </br>
	 *  
	 * @return <b>true</b> : if ratings are already given, else <b>false</b>.
	 * @param orderNo : OrderId corresponding to which search is made.
	 */
	@Override
	public boolean hasOrderRatingsByOrdersNo(String orderNo) {
		
		//OR use Pageable : https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/AbstractPageRequest.html
		boolean result = ( this.orderRatingsDAO.findOrderRatingsByOrdersNo(orderNo) > 0 )?true:false;
		return result;
	}

	/**
	 * Service method to persist List of {@link OrderRatings} object into database;
	 * </br>
	 * 
	 * @param rating : List of {@link OrderRatings} object.
	 * @author Nitin Sharma
	 */
	@Override
	public void saveAllOrderRatings(List<OrderRatings> rating) {
		this.orderRatingsDAO.save(rating);
	}
}
