package com.production.entity;

public class RevSoldJob {

	private int revSoldJobId;
	private int orderId;
	private String pdfPath;
    private int status;
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
	public String getPdfPath() {
		return pdfPath;
	}
	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
