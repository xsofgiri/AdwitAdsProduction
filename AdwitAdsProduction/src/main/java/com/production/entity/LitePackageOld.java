package com.production.entity;

public class LitePackageOld {
	private int id;
	private int uId;
	private int credits;
	private float creditsPrice;
	private float discount;
	private float perDiscount;
	private int totalPrice;
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public float getCreditsPrice() {
		return creditsPrice;
	}

	public void setCreditsPrice(float creditsPrice) {
		this.creditsPrice = creditsPrice;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getPerDiscount() {
		return perDiscount;
	}

	public void setPerDiscount(float perDiscount) {
		this.perDiscount = perDiscount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
