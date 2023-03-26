package com.production.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {

	private int orderId;
	private int adRepId;
	private int mapOrderId;
	private int csrId;
	private int publicationId;
	private int orderTypeId;
	private String advertiserName;
	private String publishDate;
	private String publicationName;
	private String dateNeeded;
	private String copyContent;
	private String jobInstruction;
	private String artWork;
	private String jobNo;
	private String section;
	private String colorPreferences;
	private String fontPreferences;
	private String copyContentDescription;
	private String notes;
	private double width;
	private double height;
	private int printAdType;
	private int pixelSizeId;
	private int flexitiveSizeId;
	private String webAdType;
	private int webAdFormatId;
	private String maxFileSize;
	private String customWidth;
	private String customHeight;
	private String pickupAdNo;
	private String filePath;
	private ArrayList<String> fileList;
	private String createdOn;
	private boolean isApproved;
	private boolean isCancel;
	private boolean isRush;
	private int oldAdRepId;
	private int question;
	private int isCrequest;
	private String priority;
	private String pdfPath;
	private String pdfCreatedOn;
	private double credits;
	private int revCount;
	private int revSoldJobId;

	private int orderStatusId;
	private int oldStatus;
	private int isDownloadDelete;
	private int isSourceDelete;
	private int invoiceId;
	private int pubProjectId;
	private int clubId;
	private String approvedOn;
	private String activityTime;
	private int status;
	private String orderStatus;
	private int revSoldStatus;
	private String adRepName;
	private boolean isRevisionAllowed;
	private int jobInstructionId;
	private int artWorkId;
	private int pageDesignID;
	private int revOrderStatus;
	private String webOrderType;
	private int revSold;

	private List<RevSoldJob> revSoldList;
	private List<FlexitiveSize> flexitiveSizeList;
	private List<PixelSize> pixelSizeList;
	
	private List<OrderMultipleCustomSize> multipleCustomSizes;
	
	private FlexitiveSize flexitiveSize;
	private PixelSize pixelSize;
	
	private OrderQA orderQA;
	
	private CatResult catResult;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
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

	public String getCopyContent() {
		return copyContent;
	}

	public void setCopyContent(String copyContent) {
		this.copyContent = copyContent;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getPrintAdType() {
		return printAdType;
	}

	public void setPrintAdType(int printAdType) {
		this.printAdType = printAdType;
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

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isCancel() {
		return isCancel;
	}

	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}

	public boolean isRush() {
		return isRush;
	}

	public void setRush(boolean isRush) {
		this.isRush = isRush;
	}

	public int getOldAdRepId() {
		return oldAdRepId;
	}

	public void setOldAdRepId(int oldAdRepId) {
		this.oldAdRepId = oldAdRepId;
	}

	

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getPdfCreatedOn() {
		return pdfCreatedOn;
	}

	public void setPdfCreatedOn(String pdfCreatedOn) {
		this.pdfCreatedOn = pdfCreatedOn;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public int getRevSold() {
		return revSold;
	}

	public void setRevSold(int revSold) {
		this.revSold = revSold;
	}

	public int getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(int oldStatus) {
		this.oldStatus = oldStatus;
	}

	public int getIsDownloadDelete() {
		return isDownloadDelete;
	}

	public void setIsDownloadDelete(int isDownloadDelete) {
		this.isDownloadDelete = isDownloadDelete;
	}

	public int getIsSourceDelete() {
		return isSourceDelete;
	}

	public void setIsSourceDelete(int isSourceDelete) {
		this.isSourceDelete = isSourceDelete;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getPubProjectId() {
		return pubProjectId;
	}

	public void setPubProjectId(int pubProjectId) {
		this.pubProjectId = pubProjectId;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(String approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAdRepName() {
		return adRepName;
	}

	public void setAdRepName(String adRepName) {
		this.adRepName = adRepName;
	}

	public int getRevSoldStatus() {
		return revSoldStatus;
	}

	public void setRevSoldStatus(int revSoldStatus) {
		this.revSoldStatus = revSoldStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public boolean isRevisionAllowed() {
		return isRevisionAllowed;
	}

	public void setRevisionAllowed(boolean isRevisionAllowed) {
		this.isRevisionAllowed = isRevisionAllowed;
	}

	public int getAdRepId() {
		return adRepId;
	}

	public void setAdRepId(int adRepId) {
		this.adRepId = adRepId;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public int getJobInstructionId() {
		return jobInstructionId;
	}

	public void setJobInstructionId(int jobInstructionId) {
		this.jobInstructionId = jobInstructionId;
	}

	public int getArtWorkId() {
		return artWorkId;
	}

	public void setArtWorkId(int artWorkId) {
		this.artWorkId = artWorkId;
	}

	public int getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(int orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	public int getWebAdFormatId() {
		return webAdFormatId;
	}

	public void setWebAdFormatId(int webAdFormatId) {
		this.webAdFormatId = webAdFormatId;
	}

	public String getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(String dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getJobInstruction() {
		return jobInstruction;
	}

	public void setJobInstruction(String jobInstruction) {
		this.jobInstruction = jobInstruction;
	}

	public String getCopyContentDescription() {
		return copyContentDescription;
	}

	public void setCopyContentDescription(String copyContentDescription) {
		this.copyContentDescription = copyContentDescription;
	}

	public int getPageDesignID() {
		return pageDesignID;
	}

	public void setPageDesignID(int pageDesignID) {
		this.pageDesignID = pageDesignID;
	}

	public int getRevOrderStatus() {
		return revOrderStatus;
	}

	public void setRevOrderStatus(int revOrderStatus) {
		this.revOrderStatus = revOrderStatus;
	}

	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	public String getArtWork() {
		return artWork;
	}

	public void setArtWork(String artWork) {
		this.artWork = artWork;
	}

	public int getMapOrderId() {
		return mapOrderId;
	}

	public void setMapOrderId(int mapOrderId) {
		this.mapOrderId = mapOrderId;
	}

	public List<RevSoldJob> getRevSoldList() {
		return revSoldList;
	}

	public void setRevSoldList(List<RevSoldJob> revSoldList) {
		this.revSoldList = revSoldList;
	}

	public String getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(String maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	public String getWebOrderType() {
		return webOrderType;
	}

	public void setWebOrderType(String webOrderType) {
		this.webOrderType = webOrderType;
	}

	public int getFlexitiveSizeId() {
		return flexitiveSizeId;
	}

	public void setFlexitiveSizeId(int flexitiveSizeId) {
		this.flexitiveSizeId = flexitiveSizeId;
	}

	public String getWebAdType() {
		return webAdType;
	}

	public void setWebAdType(String webAdType) {
		this.webAdType = webAdType;
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

	public String getPickupAdNo() {
		return pickupAdNo;
	}

	public void setPickupAdNo(String pickupAdNo) {
		this.pickupAdNo = pickupAdNo;
	}

	public int getIsCrequest() {
		return isCrequest;
	}

	public void setIsCrequest(int isCrequest) {
		this.isCrequest = isCrequest;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getRevCount() {
		return revCount;
	}

	public void setRevCount(int revCount) {
		this.revCount = revCount;
	}

	public int getRevSoldJobId() {
		return revSoldJobId;
	}

	public void setRevSoldJobId(int revSoldJobId) {
		this.revSoldJobId = revSoldJobId;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	

	public List<OrderMultipleCustomSize> getMultipleCustomSizes() {
		return multipleCustomSizes;
	}

	public void setMultipleCustomSizes(List<OrderMultipleCustomSize> multipleCustomSizes) {
		this.multipleCustomSizes = multipleCustomSizes;
	}

	public List<FlexitiveSize> getFlexitiveSizeList() {
		return flexitiveSizeList;
	}

	public void setFlexitiveSizeList(List<FlexitiveSize> flexitiveSizeList) {
		this.flexitiveSizeList = flexitiveSizeList;
	}

	public List<PixelSize> getPixelSizeList() {
		return pixelSizeList;
	}

	public void setPixelSizeList(List<PixelSize> pixelSizeList) {
		this.pixelSizeList = pixelSizeList;
	}

	public int getPixelSizeId() {
		return pixelSizeId;
	}

	public void setPixelSizeId(int pixelSizeId) {
		this.pixelSizeId = pixelSizeId;
	}

	public FlexitiveSize getFlexitiveSize() {
		return flexitiveSize;
	}

	public void setFlexitiveSize(FlexitiveSize flexitiveSize) {
		this.flexitiveSize = flexitiveSize;
	}

	public PixelSize getPixelSize() {
		return pixelSize;
	}

	public void setPixelSize(PixelSize pixelSize) {
		this.pixelSize = pixelSize;
	}

	

	public OrderQA getOrderQA() {
		return orderQA;
	}

	public void setOrderQA(OrderQA orderQA) {
		this.orderQA = orderQA;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public ArrayList<String> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}

	public CatResult getCatResult() {
		return catResult;
	}

	public void setCatResult(CatResult catResult) {
		this.catResult = catResult;
	}

	

}
