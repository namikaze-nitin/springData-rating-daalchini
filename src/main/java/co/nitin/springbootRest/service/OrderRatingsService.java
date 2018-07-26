package co.nitin.springbootRest.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.nitin.springbootRest.model.OrderRatings;

/**
 * Check {@link OrderRatingsServiceImpl} for implementation details
 * 
 * @author Nitin Sharma
 *
 */
@Repository
public interface OrderRatingsService {

	public void saveOrderRatings(OrderRatings rating);
	public void saveAllOrderRatings(List<OrderRatings> rating);
	public boolean hasOrderRatingsByOrdersNo(String orderNo);
}
