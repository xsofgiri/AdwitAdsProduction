package com.production.entity;

public class Group {
	private int groupId;
	private String name;
	private int helpDeskId;
	private int channelId;
	private int catSlugTypeId;
	private int isBillingSystem;
	private String billingEffectiveDate;
	private String initial;
	private int isDisplayPub;
	private int priority;
	private int isActive;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHelpDeskId() {
		return helpDeskId;
	}

	public void setHelpDeskId(int helpDeskId) {
		this.helpDeskId = helpDeskId;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public int getCatSlugTypeId() {
		return catSlugTypeId;
	}

	public void setCatSlugTypeId(int catSlugTypeId) {
		this.catSlugTypeId = catSlugTypeId;
	}

	public int getIsBillingSystem() {
		return isBillingSystem;
	}

	public void setIsBillingSystem(int isBillingSystem) {
		this.isBillingSystem = isBillingSystem;
	}

	public String getBillingEffectiveDate() {
		return billingEffectiveDate;
	}

	public void setBillingEffectiveDate(String billingEffectiveDate) {
		this.billingEffectiveDate = billingEffectiveDate;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public int getIsDisplayPub() {
		return isDisplayPub;
	}

	public void setIsDisplayPub(int isDisplayPub) {
		this.isDisplayPub = isDisplayPub;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
