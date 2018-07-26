package co.nitin.springbootRest.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class defines structure of ratings provided in the form of json in controller.
 * 
 * @author Nitin Sharma
 *
 */
@Component
@Entity
@Table(name="ORD_Ratings")
public class OrderRatings implements Serializable{

	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int prdRatingId;
	
	/**
	 * Field defining id of product present in order request. 
	 */
	@Id
	private String variant_id;
	
	@ManyToOne
	@JoinColumn(name="orderNo", nullable = false)
	@JsonIgnore
	private OrderRequest request;

	/**
	 * Rating given by customer to a particular product present in the OrderRequest
	 */
	@Column
	private byte rating_food;

	public void setRequest(OrderRequest request) {
		this.request = request;
	}
	
	/**
	 * @return id of product
	 */
	public String getVariant_id() {
		return variant_id;
	}
	/**
	 * Set id of product
	 * @param variant_id
	 */
	public void setVariant_id(String variant_id) {
		this.variant_id = variant_id;
	}
	public byte getRating_food() {
		return rating_food;
	}
	public void setRating_food(byte rating_food) {
		this.rating_food = rating_food;
	}
	
	@Override
	public String toString() {
		return "OrderRatings [variant_id=" + this.variant_id + ", rating_food=" + this.rating_food + "]";
	}	
}