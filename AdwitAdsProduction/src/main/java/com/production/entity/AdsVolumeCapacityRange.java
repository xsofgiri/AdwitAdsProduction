package com.production.entity;

public class AdsVolumeCapacityRange {
	private int id;
	private String channel;
	private int team;
	private int lowestMin;
	private int lowestMax;
	private int lowMin;
	private int lowMax;
	private int optimalMin;
	private int optimalMax;
	private int peakMin;
	private int peakMax;
	private int stretch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getLowestMin() {
		return lowestMin;
	}

	public void setLowestMin(int lowestMin) {
		this.lowestMin = lowestMin;
	}

	public int getLowestMax() {
		return lowestMax;
	}

	public void setLowestMax(int lowestMax) {
		this.lowestMax = lowestMax;
	}

	public int getLowMin() {
		return lowMin;
	}

	public void setLowMin(int lowMin) {
		this.lowMin = lowMin;
	}

	public int getLowMax() {
		return lowMax;
	}

	public void setLowMax(int lowMax) {
		this.lowMax = lowMax;
	}

	public int getOptimalMin() {
		return optimalMin;
	}

	public void setOptimalMin(int optimalMin) {
		this.optimalMin = optimalMin;
	}

	public int getOptimalMax() {
		return optimalMax;
	}

	public void setOptimalMax(int optimalMax) {
		this.optimalMax = optimalMax;
	}

	public int getPeakMin() {
		return peakMin;
	}

	public void setPeakMin(int peakMin) {
		this.peakMin = peakMin;
	}

	public int getPeakMax() {
		return peakMax;
	}

	public void setPeakMax(int peakMax) {
		this.peakMax = peakMax;
	}

	public int getStretch() {
		return stretch;
	}

	public void setStretch(int stretch) {
		this.stretch = stretch;
	}

}
