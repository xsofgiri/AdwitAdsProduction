package com.production.entity;

public class LiteMyCreditsHistory {
	private int id;
	private int uId;
	private int creditsAddedId;
	private float creditsDebited;
	private int orderId;
	private float creditsCredited;
	private int purpose;
	private String timestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getCreditsAddedId() {
		return creditsAddedId;
	}

	public void setCreditsAddedId(int creditsAddedId) {
		this.creditsAddedId = creditsAddedId;
	}

	public float getCreditsDebited() {
		return creditsDebited;
	}

	public void setCreditsDebited(float creditsDebited) {
		this.creditsDebited = creditsDebited;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getCreditsCredited() {
		return creditsCredited;
	}

	public void setCreditsCredited(float creditsCredited) {
		this.creditsCredited = creditsCredited;
	}

	public int getPurpose() {
		return purpose;
	}

	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
