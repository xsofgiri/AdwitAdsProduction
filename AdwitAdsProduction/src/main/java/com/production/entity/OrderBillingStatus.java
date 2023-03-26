package com.production.entity;

public class OrderBillingStatus {
	private int orderBillingStatusId;
	private String orderId;
	private int catResultId;
	private String reason;
	private int status;
	private String date;

	public int getOrderBillingStatusId() {
		return orderBillingStatusId;
	}

	public void setOrderBillingStatusId(int orderBillingStatusId) {
		this.orderBillingStatusId = orderBillingStatusId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getCatResultId() {
		return catResultId;
	}

	public void setCatResultId(int catResultId) {
		this.catResultId = catResultId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
