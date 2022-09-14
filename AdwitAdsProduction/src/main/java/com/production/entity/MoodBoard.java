package com.production.entity;

import java.util.ArrayList;

public class MoodBoard {

	private int moodBoardId;
	private String name;
	private String path;
	private ArrayList<String> imagePath;
	
	public int getMoodBoardId() {
		return moodBoardId;
	}
	public void setMoodBoardId(int moodBoardId) {
		this.moodBoardId = moodBoardId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ArrayList<String> getImagePath() {
		return imagePath;
	}
	public void setImagePath(ArrayList<String> imagePath) {
		this.imagePath = imagePath;
	}
	
}
