package com.production.entity;

import java.util.ArrayList;

public class AdwitTeams {
	private int adwitTeamsId;
	private String name;
	private int isActive;
	private String category;
	private String clubs;
	private ArrayList<Club> clubList;
	

	public int getAdwitTeamsId() {
		return adwitTeamsId;
	}

	public void setAdwitTeamsId(int adwitTeamsId) {
		this.adwitTeamsId = adwitTeamsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClubs() {
		return clubs;
	}

	public void setClubs(String clubs) {
		this.clubs = clubs;
	}

	public ArrayList<Club> getClubList() {
		return clubList;
	}

	public void setClubList(ArrayList<Club> clubList) {
		this.clubList = clubList;
	}
  
}
