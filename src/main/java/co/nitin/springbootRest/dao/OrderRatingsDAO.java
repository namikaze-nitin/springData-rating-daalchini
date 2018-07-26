package co.nitin.springbootRest.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.nitin.springbootRest.model.OrderRatings;

/**
 * DAO extending {@link CrudRepository} to make query from {@link OrderRatings} table of database.
 * 
 * @author Nitin Sharma
 *
 */
@Repository
public interface OrderRatingsDAO extends CrudRepository<OrderRatings, String>{
	
	@Query("SELECT COUNT(o) FROM OrderRatings o WHERE o.request.orderNo = :orderNo ")//TODO use of pagination for limit
	Integer findOrderRatingsByOrdersNo(@Param("orderNo") String orderNo);
}