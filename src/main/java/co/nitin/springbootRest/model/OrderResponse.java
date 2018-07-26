package co.nitin.springbootRest.model;

import java.io.Serializable;

/**
 * 
 * Class defines structure of response to be generated and returned back from {@link OrderRequestRatingController}
 * 
 * @author Nitin Sharma
 *
 */
public class OrderResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String statusCode;
	private String statusMessage;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	@Override
	public String toString() {
		return "OrderResponse [status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage
				+ "]";
	}
}
