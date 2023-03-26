package com.production.entity;

public class Page {
	private int pageId;
	private int pageDesignId;
	private String pageNo;
	private String articles;
	private String ads;
	private String noteInstructions;
	private int pageStatusId;
	private String attachArticle;
	private String attachAds;
	private String isApprove;

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageDesignId() {
		return pageDesignId;
	}

	public void setPageDesignId(int pageDesignId) {
		this.pageDesignId = pageDesignId;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}

	public String getAds() {
		return ads;
	}

	public void setAds(String ads) {
		this.ads = ads;
	}

	public String getNoteInstructions() {
		return noteInstructions;
	}

	public void setNoteInstructions(String noteInstructions) {
		this.noteInstructions = noteInstructions;
	}

	public int getPageStatusId() {
		return pageStatusId;
	}

	public void setPageStatusId(int pageStatusId) {
		this.pageStatusId = pageStatusId;
	}

	public String getAttachArticle() {
		return attachArticle;
	}

	public void setAttachArticle(String attachArticle) {
		this.attachArticle = attachArticle;
	}

	public String getAttachAds() {
		return attachAds;
	}

	public void setAttachAds(String attachAds) {
		this.attachAds = attachAds;
	}

	public String getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}  

}
