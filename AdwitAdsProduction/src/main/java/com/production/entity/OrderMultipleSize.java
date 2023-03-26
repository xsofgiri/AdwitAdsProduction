package com.production.entity;

public class OrderMultipleSize {
	private int orderMultipleSizeId;
	private int orderId;
	private int sizeID;

	public int getOrderMultipleSizeId() {
		return orderMultipleSizeId;
	}

	public void setOrderMultipleSizeId(int orderMultipleSizeId) {
		this.orderMultipleSizeId = orderMultipleSizeId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getSizeID() {
		return sizeID;
	}

	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}

	@Override
	public String toString() {
		return "OrderMultipleSize [orderMultipleSizeId=" + orderMultipleSizeId + ", orderId=" + orderId + ", sizeID="
				+ sizeID + "]";
	}

}
