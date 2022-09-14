package com.production.entity;

public class PubProject {

	private int pubProjectId;
	private String name;
	private int publicationId;
	private String initial;
	
	public int getPubProjectId() {
		return pubProjectId;
	}
	public void setPubProjectId(int pubProjectId) {
		this.pubProjectId = pubProjectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
}
