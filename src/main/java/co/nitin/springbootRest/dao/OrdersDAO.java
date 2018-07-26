package co.nitin.springbootRest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.nitin.springbootRest.model.Orders;

/**
 * DAO extending {@link CrudRepository} to make query from {@link Orders} table of database.
 * 
 * @author Nitin Sharma
 *
 */
@Repository
public interface OrdersDAO extends CrudRepository<Orders, String> {
}