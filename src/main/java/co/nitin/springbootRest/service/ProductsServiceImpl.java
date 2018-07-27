package co.nitin.springbootRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.nitin.springbootRest.dao.ProductsDAO;
import co.nitin.springbootRest.model.Products;

/**
 * Service class for {@link ProductsService}
 * 
 * @author Nitin Sharma
 */
@Service
public class ProductsServiceImpl implements ProductsService{

	private ProductsDAO productsDao;
	
	/**
	 * Constructor to autowire data member of type {@link ProductsDAO}.
	 * 
	 * @param productsDAO
	 * @author Nitin Sharma
	 */
	@Autowired
	public ProductsServiceImpl(ProductsDAO productsDao) {
		this.productsDao = productsDao;
	}

	/**
	 * Method to check whether a product corresponding to provided productID exists in database or not.
	 * 
	 * @return <b>true</> : if product with that id exists, else <br>false</br>
	 * @param prodId : id of product to be checked.
	 */
	@Override
	public boolean hasProductByProductId(String prodId) {
		return (this.productsDao.findOne(prodId) != null)?true:false;
	}
}