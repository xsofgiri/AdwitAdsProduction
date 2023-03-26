package com.production.entity;

public class PageRevision {

	private int pageRevisionId;
	private int pageDesignId;
	private String articles;
	private String ads;
	private String note;
	private String zipPath;
	private String pdfPath;
	private String revisionVersion;
	private int pageRevStatusId;
	private String createdOn;  

	public int getPageRevisionId() {
		return pageRevisionId;
	}

	public void setPageRevisionId(int pageRevisionId) {
		this.pageRevisionId = pageRevisionId;
	}

	public int getPageDesignId() {
		return pageDesignId;
	}

	public void setPageDesignId(int pageDesignId) {
		this.pageDesignId = pageDesignId;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getZipPath() {
		return zipPath;
	}

	public void setZipPath(String zipPath) {
		this.zipPath = zipPath;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getRevisionVersion() {
		return revisionVersion;
	}

	public void setRevisionVersion(String revisionVersion) {
		this.revisionVersion = revisionVersion;
	}

	public int getPageRevStatusId() {
		return pageRevStatusId;
	}

	public void setPageRevStatusId(int pageRevStatusId) {
		this.pageRevStatusId = pageRevStatusId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

}
