package com.production.entity;

public class Publication {

	private int publicationId;
	private String name;
	private String advertisingDirectorEmail;
	private int designTeamId;
	private int teamLeadId;
	private int timeZoneId;
	private int groupId;
	private int clubId;
	private String city;
	private boolean isActive;
	private boolean isDeleted;
	private boolean isEnableProject;
	private boolean isLiveTracker;
	private boolean isPDFReview;
	private boolean isCustomSize;
	
	public int getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdvertisingDirectorEmail() {
		return advertisingDirectorEmail;
	}
	public void setAdvertisingDirectorEmail(String advertisingDirectorEmail) {
		this.advertisingDirectorEmail = advertisingDirectorEmail;
	}
	public int getDesignTeamId() {
		return designTeamId;
	}
	public void setDesignTeamId(int designTeamId) {
		this.designTeamId = designTeamId;
	}
	public int getTeamLeadId() {
		return teamLeadId;
	}
	public void setTeamLeadId(int teamLeadId) {
		this.teamLeadId = teamLeadId;
	}
	public int getTimeZoneId() {
		return timeZoneId;
	}
	public void setTimeZoneId(int timeZoneId) {
		this.timeZoneId = timeZoneId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public boolean isEnableProject() {
		return isEnableProject;
	}
	public void setEnableProject(boolean isEnableProject) {
		this.isEnableProject = isEnableProject;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public boolean isLiveTracker() {
		return isLiveTracker;
	}
	public void setLiveTracker(boolean isLiveTracker) {
		this.isLiveTracker = isLiveTracker;
	}
	public boolean isPDFReview() {
		return isPDFReview;
	}
	public void setPDFReview(boolean isPDFReview) {
		this.isPDFReview = isPDFReview;
	}
	public boolean isCustomSize() {
		return isCustomSize;
	}
	public void setCustomSize(boolean isCustomSize) {
		this.isCustomSize = isCustomSize;
	}
	
}
