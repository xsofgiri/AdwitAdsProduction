package com.production.entity;

public class Invoice {

	private int invoiceId;
	private int publicationId;
	private int customerId;
	private int billingStatusId;
	private String time;
	private int accountId;
	private String invoiceNo;
	private int invoiceNo1;
	private int quantity;
	private float totalSqInches;
	private float totalUsd;
	private String date;
	private float specialDiscount;
	private float subtotal;
	private float desc;
	private float totalDue;

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBillingStatusId() {
		return billingStatusId;
	}

	public void setBillingStatusId(int billingStatusId) {
		this.billingStatusId = billingStatusId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getInvoiceNo1() {
		return invoiceNo1;
	}

	public void setInvoiceNo1(int invoiceNo1) {
		this.invoiceNo1 = invoiceNo1;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalSqInches() {
		return totalSqInches;
	}

	public void setTotalSqInches(float totalSqInches) {
		this.totalSqInches = totalSqInches;
	}

	public float getTotalUsd() {
		return totalUsd;
	}

	public void setTotalUsd(float totalUsd) {
		this.totalUsd = totalUsd;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getSpecialDiscount() {
		return specialDiscount;
	}

	public void setSpecialDiscount(float specialDiscount) {
		this.specialDiscount = specialDiscount;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getDesc() {
		return desc;
	}

	public void setDesc(float desc) {
		this.desc = desc;
	}

	public float getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(float totalDue) {
		this.totalDue = totalDue;
	}

}
