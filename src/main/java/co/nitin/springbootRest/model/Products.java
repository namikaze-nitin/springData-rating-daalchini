package co.nitin.springbootRest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 * Demo entity class defining structure for products available in inventory.
 * </br>
 * TODO : update it on getting actual structure of product class
 * 
 * @author Nitin Sharma
 */
@Component
@Entity
@Table(name="products")
public class Products implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String variant_id;
	
	@Column
	private String variant_name;
	
	public String getVariant_id() {
		return variant_id;
	}
	public void setVariant_id(String variant_id) {
		this.variant_id = variant_id;
	}
	public String getVariant_name() {
		return variant_name;
	}
	public void setVariant_name(String variant_name) {
		this.variant_name = variant_name;
	}
	
	@Override
	public String toString() {
		return "Products [variant_id=" + variant_id + ", variant_name=" + variant_name + "]";
	}
}
