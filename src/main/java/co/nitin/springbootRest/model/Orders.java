package co.nitin.springbootRest.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 * 
 * Demo Orders class. Created to check functioinality of API.
 * 
 * TODO : Update this class after getting original Orders structure.
 * 
 * @author Nitin Sharma
 *
 */
@Component
@Entity
@Table(name="orders")
public class Orders implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String orderNo;
	
	@Column
	private int TotalCost;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Orders [orderNo=" + this.orderNo + ", TotalCost=" + this.TotalCost + "]";
	}	
}