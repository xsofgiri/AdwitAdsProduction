package com.production.entity;

public class RevOrderReason {
	private int revOrderReasonId;
	private int revSoldJobId;
	private int orderId;
	private String revReasonId;
	private int csrId;
	private int designerId;
	private int revErrorTypeId;
	private String timestamp;

	public int getRevOrderReasonId() {
		return revOrderReasonId;
	}

	public void setRevOrderReasonId(int revOrderReasonId) {
		this.revOrderReasonId = revOrderReasonId;
	}

	public int getRevSoldJobId() {
		return revSoldJobId;
	}

	public void setRevSoldJobId(int revSoldJobId) {
		this.revSoldJobId = revSoldJobId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getRevReasonId() {
		return revReasonId;
	}

	public void setRevReasonId(String revReasonId) {
		this.revReasonId = revReasonId;
	}

	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	public int getDesignerId() {
		return designerId;
	}

	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}

	public int getRevErrorTypeId() {
		return revErrorTypeId;
	}

	public void setRevErrorTypeId(int revErrorTypeId) {
		this.revErrorTypeId = revErrorTypeId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
