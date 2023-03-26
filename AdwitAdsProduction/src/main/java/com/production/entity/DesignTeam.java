package com.production.entity;

public class DesignTeam {
	private int designTeamId;
	private String name;
	private int groupId;
	private String code;
	private String emailId;
	private String newAdTemplate;
	private String revAdTemplate;
	private int isActive;
	private int isDeleted;

	public int getDesignTeamId() {
		return designTeamId;
	}

	public void setDesignTeamId(int designTeamId) {
		this.designTeamId = designTeamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getNewAdTemplate() {
		return newAdTemplate;
	}

	public void setNewAdTemplate(String newAdTemplate) {
		this.newAdTemplate = newAdTemplate;
	}

	public String getRevAdTemplate() {
		return revAdTemplate;
	}

	public void setRevAdTemplate(String revAdTemplate) {
		this.revAdTemplate = revAdTemplate;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

}
