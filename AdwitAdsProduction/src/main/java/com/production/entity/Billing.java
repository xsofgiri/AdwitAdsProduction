package com.production.entity;

public class Billing {
	private int billingId;
	private int publicationId;
	private int groupId;
	private String month;
	private int billingStatusId;
	private int invoiceId;

	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getBillingStatusId() {
		return billingStatusId;
	}

	public void setBillingStatusId(int billingStatusId) {
		this.billingStatusId = billingStatusId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
  
}
