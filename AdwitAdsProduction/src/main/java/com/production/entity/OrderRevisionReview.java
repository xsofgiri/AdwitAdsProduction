package com.production.entity;

public class OrderRevisionReview {  
	private int orderRevisionReviewId;
	private int orderId;
	private int revSoldJobId;
	private String version;
	private int designerId;
	private String designerMistake;
	private String timestamp;

	public int getOrderRevisionReviewId() {
		return orderRevisionReviewId;
	}

	public void setOrderRevisionReviewId(int orderRevisionReviewId) {
		this.orderRevisionReviewId = orderRevisionReviewId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRevSoldJobId() {
		return revSoldJobId;
	}

	public void setRevSoldJobId(int revSoldJobId) {
		this.revSoldJobId = revSoldJobId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getDesignerId() {
		return designerId;
	}

	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}

	public String getDesignerMistake() {
		return designerMistake;
	}

	public void setDesignerMistake(String designerMistake) {
		this.designerMistake = designerMistake;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
  
}
