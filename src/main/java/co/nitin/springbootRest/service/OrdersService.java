package co.nitin.springbootRest.service;

import org.springframework.stereotype.Repository;
import co.nitin.springbootRest.model.Orders;

/**
 * Check {@link OrdersServiceImpl} for implementation details.
 * 
 * @author Nitin Sharma
 */
@Repository
public interface OrdersService {

	public Orders getOrdersById(String id);
}
