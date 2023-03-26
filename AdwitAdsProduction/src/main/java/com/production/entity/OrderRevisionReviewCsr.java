package com.production.entity;

public class OrderRevisionReviewCsr {
	private int orderRevisionReviewCsrId;
	private int orderId;
	private int revSoldJobId;
	private String version;
	private int csrId;
	private String csrMistake;
	private String timestamp;

	public int getOrderRevisionReviewCsrId() {
		return orderRevisionReviewCsrId;
	}

	public void setOrderRevisionReviewCsrId(int orderRevisionReviewCsrId) {
		this.orderRevisionReviewCsrId = orderRevisionReviewCsrId;
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

	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	public String getCsrMistake() {
		return csrMistake;
	}

	public void setCsrMistake(String csrMistake) {
		this.csrMistake = csrMistake;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
