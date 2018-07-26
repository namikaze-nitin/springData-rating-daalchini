package co.nitin.springbootRest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.nitin.springbootRest.model.OrderRequest;

/**
 * DAO extending {@link CrudRepository} to make query from {@link OrderRequest} table of database.
 * 
 * @author Nitin Sharma
 *
 */
@Repository
public interface OrderRequestDAO extends CrudRepository<OrderRequest, String>{
}
