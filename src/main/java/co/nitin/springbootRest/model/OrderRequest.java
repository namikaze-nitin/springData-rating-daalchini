package co.nitin.springbootRest.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;

/**
 * CLass defines structure of Request made to {@link OrderRequestRatingController} in json format.
 * 
 * @author Nitin Sharma
 *
 */
@Component
@Entity
@Table(name="ORD_Request")
public class OrderRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * Id corresponding to order made.
	 */
	@Id
	private String orderNo;
	
	/**
	 * Overall ordering experience of user.
	 */
	@Column
	private int rateOverAllExperience;

	@Column
	private String apiName;

	@Column
	private Double apiVersion;
		
	/**
	 * Fields marked with @Transient annotation will not pe persisted into database.
	 * </br>
	 * <a href="https://stackoverflow.com/questions/2154622/why-does-jpa-have-a-transient-annotation">For Details on @Transient and transient</a>
	 */
	@Transient
	private List<OrderRatings> ratings;

	public List<OrderRatings> getRatings() {
		return ratings;
	}
	public void setRatings(List<OrderRatings> ratings) {
		this.ratings = ratings;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getRateOverAllExperience() {
		return rateOverAllExperience;
	}
	public void setRateOverAllExperience(int rateOverAllExperience) {
		this.rateOverAllExperience = rateOverAllExperience;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public Double getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(Double apiVersion) {
		this.apiVersion = apiVersion;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderNo=" + this.orderNo + ", rateOverAllExperience=" + this.rateOverAllExperience + ", apiName="
				+ this.apiName + ", apiVersion=" + this.apiVersion + "]";
	}	
}
