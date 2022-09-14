package com.production.entity;

public class OrderCustomSize {

	private int orderCustomSizeId;
	private String title;
	private String width;
	private String height;
	private int publicationId;
	public int getOrderCustomSizeId() {
		return orderCustomSizeId;
	}
	public void setOrderCustomSizeId(int orderCustomSizeId) {
		this.orderCustomSizeId = orderCustomSizeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public int getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}
}
