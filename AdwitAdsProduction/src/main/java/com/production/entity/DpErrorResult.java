package com.production.entity;

public class DpErrorResult {
	private int dpErrorResultId;
	private int dpResultId;
	private String jobName;
	private int dpErrorId;
	private int dpErrorTypeId;
	private int dpErrorDegreeId;

	public int getDpErrorResultId() {
		return dpErrorResultId;
	}

	public void setDpErrorResultId(int dpErrorResultId) {
		this.dpErrorResultId = dpErrorResultId;
	}

	public int getDpResultId() {
		return dpResultId;
	}

	public void setDpResultId(int dpResultId) {
		this.dpResultId = dpResultId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getDpErrorId() {
		return dpErrorId;
	}

	public void setDpErrorId(int dpErrorId) {
		this.dpErrorId = dpErrorId;
	}

	public int getDpErrorTypeId() {
		return dpErrorTypeId;
	}

	public void setDpErrorTypeId(int dpErrorTypeId) {
		this.dpErrorTypeId = dpErrorTypeId;
	}

	public int getDpErrorDegreeId() {
		return dpErrorDegreeId;
	}

	public void setDpErrorDegreeId(int dpErrorDegreeId) {
		this.dpErrorDegreeId = dpErrorDegreeId;
	}

}
