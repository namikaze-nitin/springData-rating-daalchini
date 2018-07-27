package co.nitin.springbootRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.nitin.springbootRest.dao.OrderRequestDAO;
import co.nitin.springbootRest.model.OrderRequest;

/**
 * Service class for {@link OrderRequestDAO}.
 * 
 * @author Nitin Sharma
 *
 */
@Service
public class OrderRequestServiceImpl implements OrderRequestService{

	private OrderRequestDAO orderReqDao;
	
	/**
	 * Constructor to autowire an object of type {@link OrderRequestDAO}.
	 * </br>
	 * Constructor injection is prefered over setter injections in spring development.
	 * 
	 * @param orderReqDao
	 */
	@Autowired
	public OrderRequestServiceImpl(OrderRequestDAO orderReqDao) {//Autowiring a constructor is prefered
		this.orderReqDao = orderReqDao;
	}
	
	/**
	 * Service method to persist {@link OrderRequest} object into database
	 * 
	 * @see OrderRequestDAO
	 * @author Nitin Sharma
	 */
	@Override
	public void saveOrderRequest(OrderRequest request) {
		this.orderReqDao.save(request);
	}

	@Override
	public boolean hasOrderByOrderId(String id) {
		return (this.orderReqDao.findOne(id) != null)?true:false;
	}
	
}
