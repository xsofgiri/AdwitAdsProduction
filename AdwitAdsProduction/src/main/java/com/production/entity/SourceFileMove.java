package com.production.entity;

public class SourceFileMove {
	private int sourceFileMoveId;
	private int orderId;
	private int helpDeskId;
	private String slug;
	private String path;
	private int isStatus;

	public int getSourceFileMoveId() {
		return sourceFileMoveId;
	}

	public void setSourceFileMoveId(int sourceFileMoveId) {
		this.sourceFileMoveId = sourceFileMoveId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getHelpDeskId() {
		return helpDeskId;
	}

	public void setHelpDeskId(int helpDeskId) {
		this.helpDeskId = helpDeskId;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(int isStatus) {
		this.isStatus = isStatus;
	}

	@Override
	public String toString() {
		return "SourceFileMove [sourceFileMoveId=" + sourceFileMoveId + ", orderId=" + orderId + ", helpDeskId="
				+ helpDeskId + ", slug=" + slug + ", path=" + path + ", isStatus=" + isStatus + "]";  
	}

}
