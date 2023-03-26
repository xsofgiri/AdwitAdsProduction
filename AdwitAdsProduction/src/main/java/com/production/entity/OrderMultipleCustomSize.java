package com.production.entity;

public class OrderMultipleCustomSize {
	private int orderMultipleCustomSizeId;
	private int orderId;
	private int customWidth;
	private int customHeight;

	public int getCustomHeight() {
		return customHeight;
	}

	public void setCustomHeight(int customHeight) {
		this.customHeight = customHeight;
	}

	public int getOrderMultipleCustomSizeId() {
		return orderMultipleCustomSizeId;
	}

	public void setOrderMultipleCustomSizeId(int orderMultipleCustomSizeId) {
		this.orderMultipleCustomSizeId = orderMultipleCustomSizeId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomWidth() {
		return customWidth;
	}

	public void setCustomWidth(int customWidth) {
		this.customWidth = customWidth;
	}

}
