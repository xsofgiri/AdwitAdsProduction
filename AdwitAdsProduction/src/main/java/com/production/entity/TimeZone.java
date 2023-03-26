package com.production.entity;

public class TimeZone {
	private int timeZoneID;
	private int priority;
	private String timeZoneName;

	public int getTimeZoneID() {
		return timeZoneID;
	}

	public void setTimeZoneID(int timeZoneID) {
		this.timeZoneID = timeZoneID;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTimeZoneName() {
		return timeZoneName;
	}

	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}

	@Override
	public String toString() {
		return "TimeZone [timeZoneID=" + timeZoneID + ", priority=" + priority + ", timeZoneName=" + timeZoneName + "]";
	}

}
