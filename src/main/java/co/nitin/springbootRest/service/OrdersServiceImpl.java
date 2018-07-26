package co.nitin.springbootRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.nitin.springbootRest.dao.OrdersDAO;
import co.nitin.springbootRest.model.Orders;

/**
 * Service class for {@link OrdersDAO}.
 * 
 * @author Nitin Sharma
 */
@Service
public class OrdersServiceImpl implements OrdersService{

	private OrdersDAO ordersDAO;
	
	/**
	 * Constructor to autowire data member of type {@link OrdersDAO}.
	 * 
	 * @param ordersDAO
	 * @author Nitin Sharma
	 */
	@Autowired
	public OrdersServiceImpl(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	/**
	 * Method to fetch an object belonging to {@link Orders} class.
	 * 
	 * @author Nitin Sharma
	 * @param id : Record corresponding to this id will be fetched.
	 */
	@Override
	public Orders getOrdersById(String id) {
		return (Orders)ordersDAO.findOne(id);
	}	
}