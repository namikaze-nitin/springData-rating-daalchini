package co.nitin.springbootRest.service;

import org.springframework.stereotype.Repository;

/**
 * Check {@link ProductsServiceImpl} for implementation details.
 * 
 * @author Nitin Sharma
 */
@Repository
public interface ProductsService {
	
	public boolean hasProductByProductId(String prodId);
}