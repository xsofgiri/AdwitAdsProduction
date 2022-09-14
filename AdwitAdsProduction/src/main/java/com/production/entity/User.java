package com.production.entity;



public class User {

    private int adrepId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Publication publication;
    
	public int getAdrepId() {
		return adrepId;
	}
	public void setAdrepId(int adrepId) {
		this.adrepId = adrepId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
    
	

}
