package com.production.entity;

public class LiteOnlineFormat {
	private int id;
	private String name;
	private int sTatic;
	private float sCredits;
	private int animated;
	private float aCredits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getsTatic() {
		return sTatic;
	}

	public void setsTatic(int sTatic) {
		this.sTatic = sTatic;
	}

	public float getsCredits() {
		return sCredits;
	}

	public void setsCredits(float sCredits) {
		this.sCredits = sCredits;
	}

	public int getAnimated() {
		return animated;
	}

	public void setAnimated(int animated) {
		this.animated = animated;
	}

	public float getaCredits() {
		return aCredits;
	}

	public void setaCredits(float aCredits) {
		this.aCredits = aCredits;
	}

	@Override
	public String toString() {
		return "LiteOnlineFormat [id=" + id + ", name=" + name + ", sTatic=" + sTatic + ", sCredits=" + sCredits
				+ ", animated=" + animated + ", aCredits=" + aCredits + "]";
	}
  
}
