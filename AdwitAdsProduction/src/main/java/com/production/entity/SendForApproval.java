package com.production.entity;

public class SendForApproval {
	private int sendForApprovalId;
	private int orderId;
	private String adNum;
	private int adrepId;
	private String name;
	private String email;
	private int approve;
	private String declineReason;

	public int getSendForApprovalId() {
		return sendForApprovalId;
	}

	public void setSendForApprovalId(int sendForApprovalId) {
		this.sendForApprovalId = sendForApprovalId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAdNum() {
		return adNum;
	}

	public void setAdNum(String adNum) {
		this.adNum = adNum;
	}

	public int getAdrepId() {
		return adrepId;
	}

	public void setAdrepId(int adrepId) {
		this.adrepId = adrepId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getApprove() {
		return approve;
	}

	public void setApprove(int approve) {
		this.approve = approve;
	}

	public String getDeclineReason() {
		return declineReason;
	}

	public void setDeclineReason(String declineReason) {
		this.declineReason = declineReason;
	}

	@Override
	public String toString() {
		return "SendForApproval [sendForApprovalId=" + sendForApprovalId + ", orderId=" + orderId + ", adNum=" + adNum
				+ ", adrepId=" + adrepId + ", name=" + name + ", email=" + email + ", approve=" + approve
				+ ", declineReason=" + declineReason + "]";
	}

}
