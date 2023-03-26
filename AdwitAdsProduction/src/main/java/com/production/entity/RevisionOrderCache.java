package com.production.entity;

public class RevisionOrderCache {
	private int revisionOrderCacheId;
	private int orderId;
	private int revSoldJobId;
	private String orderSlug;
	private int adrepId;
	private String filePath;

	public int getRevisionOrderCacheId() {
		return revisionOrderCacheId;
	}

	public void setRevisionOrderCacheId(int revisionOrderCacheId) {
		this.revisionOrderCacheId = revisionOrderCacheId;
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

	public String getOrderSlug() {
		return orderSlug;
	}

	public void setOrderSlug(String orderSlug) {
		this.orderSlug = orderSlug;
	}

	public int getAdrepId() {
		return adrepId;
	}

	public void setAdrepId(int adrepId) {
		this.adrepId = adrepId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
