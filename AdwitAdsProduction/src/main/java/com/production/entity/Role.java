package com.production.entity;

public class Role {

	private int roleId;
	private String titleString;
	private boolean canCategorise;
	private boolean canSendQuestion;
	private boolean canSendCancelRequest;
	private boolean canDesign;
	private boolean canSendDesignToAdRep;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getTitleString() {
		return titleString;
	}
	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public boolean isCanCategorise() {
		return canCategorise;
	}
	public void setCanCategorise(boolean canCategorise) {
		this.canCategorise = canCategorise;
	}
	public boolean isCanSendQuestion() {
		return canSendQuestion;
	}
	public void setCanSendQuestion(boolean canSendQuestion) {
		this.canSendQuestion = canSendQuestion;
	}
	public boolean isCanSendCancelRequest() {
		return canSendCancelRequest;
	}
	public void setCanSendCancelRequest(boolean canSendCancelRequest) {
		this.canSendCancelRequest = canSendCancelRequest;
	}
	public boolean isCanDesign() {
		return canDesign;
	}
	public void setCanDesign(boolean canDesign) {
		this.canDesign = canDesign;
	}
	public boolean isCanSendDesignToAdRep() {
		return canSendDesignToAdRep;
	}
	public void setCanSendDesignToAdRep(boolean canSendDesignToAdRep) {
		this.canSendDesignToAdRep = canSendDesignToAdRep;
	}
	
}
