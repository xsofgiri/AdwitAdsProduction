package com.production.entity;

public class OrderRevision {
	private int orderRevisionId;
	private int adrepId;
	private String orderId;
	private String jobSlug;
	private String version;
	private String copyContentDescription;
	private String filePath;
	private int csrIdUpload;
	private String createdOn;

	public int getOrderRevisionId() {
		return orderRevisionId;
	}

	public void setOrderRevisionId(int orderRevisionId) {
		this.orderRevisionId = orderRevisionId;
	}

	public int getAdrepId() {
		return adrepId;
	}

	public void setAdrepId(int adrepId) {
		this.adrepId = adrepId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getJobSlug() {
		return jobSlug;
	}

	public void setJobSlug(String jobSlug) {
		this.jobSlug = jobSlug;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCopyContentDescription() {
		return copyContentDescription;
	}

	public void setCopyContentDescription(String copyContentDescription) {
		this.copyContentDescription = copyContentDescription;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getCsrIdUpload() {
		return csrIdUpload;
	}

	public void setCsrIdUpload(int csrIdUpload) {
		this.csrIdUpload = csrIdUpload;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

}
