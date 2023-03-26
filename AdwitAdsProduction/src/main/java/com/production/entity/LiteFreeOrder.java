package com.production.entity;

public class LiteFreeOrder {
	private int id;
	private String firstName;
	private String LastName;
	private String emailId;
	private String advertiserName;
	private String jobName;
	private float width;
	private float height;
	private int printAdType;
	private String copyContentDescription;
	private String filePath;
	private String createdOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getPrintAdType() {
		return printAdType;
	}

	public void setPrintAdType(int printAdType) {
		this.printAdType = printAdType;
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

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "LiteFreeOrder [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", emailId="
				+ emailId + ", advertiserName=" + advertiserName + ", jobName=" + jobName + ", width=" + width
				+ ", height=" + height + ", printAdType=" + printAdType + ", copyContentDescription="
				+ copyContentDescription + ", filePath=" + filePath + ", createdOn=" + createdOn + "]";
	}

}
