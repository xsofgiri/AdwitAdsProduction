package com.production.entity;

public class PixelSize {

	private int pixelSizeId;
	private String name;
	private int width;
	private int height;
	private int isActive;
	private int isDeleted;
	
	public int getPixelSizeId() {
		return pixelSizeId;
	}
	public void setPixelSizeId(int pixelSizeId) {
		this.pixelSizeId = pixelSizeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
}
