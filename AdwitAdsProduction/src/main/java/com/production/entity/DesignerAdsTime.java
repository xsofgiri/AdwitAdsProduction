package com.production.entity;

public class DesignerAdsTime {

	private int designerAdsTimeId;
	private int orderId;
	private String startTime;
	private String endDate;
	private String endTime;
	private String timeTaken;
	private int designerId;

	public int getDesignerAdsTimeId() {
		return designerAdsTimeId;
	}

	public void setDesignerAdsTimeId(int designerAdsTimeId) {
		this.designerAdsTimeId = designerAdsTimeId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public int getDesignerId() {
		return designerId;
	}

	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}

}
