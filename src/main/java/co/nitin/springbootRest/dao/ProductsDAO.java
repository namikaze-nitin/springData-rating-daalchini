package co.nitin.springbootRest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.nitin.springbootRest.model.Products;

/**
 * DAO extending {@link CrudRepository} to make query from {@link Products} table of database.
 * 
 * @author Nitin Sharma
 *
 */
@Repository
public interface ProductsDAO extends CrudRepository<Products, String>{
}
