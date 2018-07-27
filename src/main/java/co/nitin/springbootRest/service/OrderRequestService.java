package co.nitin.springbootRest.service;

import org.springframework.stereotype.Repository;

import co.nitin.springbootRest.model.OrderRequest;

/**
 * Check {@link OrderRequestServiceImpl} for implementation details.
 * 
 * @author Nitin Sharma
 *
 */
@Repository
public interface OrderRequestService {

	public void saveOrderRequest(OrderRequest request);
	public boolean hasOrderByOrderId(String id);
}