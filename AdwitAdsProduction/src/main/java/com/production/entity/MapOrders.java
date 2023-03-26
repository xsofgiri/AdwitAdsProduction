package com.production.entity;

public class MapOrders {
	private int id;
	private int mapId;
	private int mainOrdersId;
	private int userId;
	private int orderTypeId;
	private String advId;
	private int pubId;
	private String jobName;
	private int numAds;
	private int status;
	private String filePath;
	private String createdOn;
	private int odId;
	private int orderId;
	private String sizeId;
	private float width;
	private float height;
	private String jobInstruction;
	private String artWork;
	private String colorPreferences;
	private String fontPreferences;
	private String copyContentDescription;
	private String notes;
	private String publishDate;
	private String dateNeeded;
	private String printAdType;
	private String webAdType;
	private String pixelSize;
	private String customWidth;
	private String customHeight;
	private int adFormat;
	private String maximumFileSize;
	private int approve;
	private int adwitadsPickupId;
	private String timestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getMainOrdersId() {
		return mainOrdersId;
	}

	public void setMainOrdersId(int mainOrdersId) {
		this.mainOrdersId = mainOrdersId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(int orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	public String getAdvId() {
		return advId;
	}

	public void setAdvId(String advId) {
		this.advId = advId;
	}

	public int getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getNumAds() {
		return numAds;
	}

	public void setNumAds(int numAds) {
		this.numAds = numAds;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getSizeId() {
		return sizeId;
	}

	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getJobInstruction() {
		return jobInstruction;
	}

	public void setJobInstruction(String jobInstruction) {
		this.jobInstruction = jobInstruction;
	}

	public String getArtWork() {
		return artWork;
	}

	public void setArtWork(String artWork) {
		this.artWork = artWork;
	}

	public String getColorPreferences() {
		return colorPreferences;
	}

	public void setColorPreferences(String colorPreferences) {
		this.colorPreferences = colorPreferences;
	}

	public String getFontPreferences() {
		return fontPreferences;
	}

	public void setFontPreferences(String fontPreferences) {
		this.fontPreferences = fontPreferences;
	}

	public String getCopyContentDescription() {
		return copyContentDescription;
	}

	public void setCopyContentDescription(String copyContentDescription) {
		this.copyContentDescription = copyContentDescription;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(String dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getPrintAdType() {
		return printAdType;
	}

	public void setPrintAdType(String printAdType) {
		this.printAdType = printAdType;
	}

	public String getWebAdType() {
		return webAdType;
	}

	public void setWebAdType(String webAdType) {
		this.webAdType = webAdType;
	}

	public String getPixelSize() {
		return pixelSize;
	}

	public void setPixelSize(String pixelSize) {
		this.pixelSize = pixelSize;
	}

	public String getCustomWidth() {
		return customWidth;
	}

	public void setCustomWidth(String customWidth) {
		this.customWidth = customWidth;
	}

	public String getCustomHeight() {
		return customHeight;
	}

	public void setCustomHeight(String customHeight) {
		this.customHeight = customHeight;
	}

	public int getAdFormat() {
		return adFormat;
	}

	public void setAdFormat(int adFormat) {
		this.adFormat = adFormat;
	}

	public String getMaximumFileSize() {
		return maximumFileSize;
	}

	public void setMaximumFileSize(String maximumFileSize) {
		this.maximumFileSize = maximumFileSize;
	}

	public int getApprove() {
		return approve;
	}

	public void setApprove(int approve) {
		this.approve = approve;
	}

	public int getAdwitadsPickupId() {
		return adwitadsPickupId;
	}

	public void setAdwitadsPickupId(int adwitadsPickupId) {
		this.adwitadsPickupId = adwitadsPickupId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "MapOrders [id=" + id + ", mapId=" + mapId + ", mainOrdersId=" + mainOrdersId + ", userId=" + userId
				+ ", orderTypeId=" + orderTypeId + ", advId=" + advId + ", pubId=" + pubId + ", jobName=" + jobName
				+ ", numAds=" + numAds + ", status=" + status + ", filePath=" + filePath + ", createdOn=" + createdOn
				+ ", odId=" + odId + ", orderId=" + orderId + ", sizeId=" + sizeId + ", width=" + width + ", height="
				+ height + ", jobInstruction=" + jobInstruction + ", artWork=" + artWork + ", colorPreferences="
				+ colorPreferences + ", fontPreferences=" + fontPreferences + ", copyContentDescription="
				+ copyContentDescription + ", notes=" + notes + ", publishDate=" + publishDate + ", dateNeeded="
				+ dateNeeded + ", printAdType=" + printAdType + ", webAdType=" + webAdType + ", pixelSize=" + pixelSize
				+ ", customWidth=" + customWidth + ", customHeight=" + customHeight + ", adFormat=" + adFormat
				+ ", maximumFileSize=" + maximumFileSize + ", approve=" + approve + ", adwitadsPickupId="
				+ adwitadsPickupId + ", timestamp=" + timestamp + "]";
	}
	
	

}
