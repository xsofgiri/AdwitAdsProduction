package com.production.entity;

public class AdsDesignCheckMsg {
	private int id;
	private int orderId;
	private int revisionId;
	private int tlId;
	private int csrId;
	private int dcId;
	private String time;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(int revisionId) {
		this.revisionId = revisionId;
	}

	public int getTlId() {
		return tlId;
	}

	public void setTlId(int tlId) {
		this.tlId = tlId;
	}

	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	public int getDcId() {
		return dcId;
	}

	public void setDcId(int dcId) {
		this.dcId = dcId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
