package com.production.entity;

public class NoteSent {
	private int noteSentId;
	private int orderId;
	private int revSoldJobId;
	private String note;
	private String timestamp;

	public int getNoteSentId() {
		return noteSentId;
	}

	public void setNoteSentId(int noteSentId) {
		this.noteSentId = noteSentId;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "NoteSent [noteSentId=" + noteSentId + ", orderId=" + orderId + ", revSoldJobId=" + revSoldJobId
				+ ", note=" + note + ", timestamp=" + timestamp + "]";
	}
	
}
