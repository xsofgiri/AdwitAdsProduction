package com.production.entity;

public class DpError {
	private int dpErrorId;
	private String name;
	private int groupId;
	private int dpErrorTypeId;
	private int dpErrorDegreeId;
	private int isStatus;

	public int getDpErrorId() {
		return dpErrorId;
	}

	public void setDpErrorId(int dpErrorId) {
		this.dpErrorId = dpErrorId;
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

	public int getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(int isStatus) {
		this.isStatus = isStatus;
	}

	@Override
	public String toString() {
		return "DpError [dpErrorId=" + dpErrorId + ", name=" + name + ", groupId=" + groupId + ", dpErrorTypeId="
				+ dpErrorTypeId + ", dpErrorDegreeId=" + dpErrorDegreeId + ", isStatus=" + isStatus + "]";
	}

}
