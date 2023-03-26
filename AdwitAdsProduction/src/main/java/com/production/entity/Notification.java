package com.production.entity;

public class Notification {
	private int notificationId;
	private String headline;
	private String message;
	private int adwitUserId;
	private int adrepId;
	private int publicationId;
	private String image;
	private String startDate;
	private String endDate;
	private String time;
	private int jobStatus;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAdwitUserId() {
		return adwitUserId;
	}

	public void setAdwitUserId(int adwitUserId) {
		this.adwitUserId = adwitUserId;
	}

	public int getAdrepId() {
		return adrepId;
	}

	public void setAdrepId(int adrepId) {
		this.adrepId = adrepId;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(int jobStatus) {
		this.jobStatus = jobStatus;
	}

}
