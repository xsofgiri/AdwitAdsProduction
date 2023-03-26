package com.production.entity;

public class AdwitProductionStaff {
	private int designerId;
	private String name;
	private int gender;
	private String emailId;
	private String mobileNo;
	private String username;
	private String password;
	private String pwdDate;
	private int saralID;
	private int designerLevelId;
	private int joinLocationId;
	private int workLocationId;
	private int isOnlineAd;
	private int designerRoleId;
	private String encryptedKey;
	private String image;
	private float shiftFactor;
	private int shiftFactorStatus;
	private int isNewD;
	private String pwdExpiryDate;
	private String createdOn;
	private int isActive;
	private int isDeleted;
	private String publicationId;
	private String categoryLevel;
	private String clubId;
	private String alias;
	private int businessGroupId;
	private String isPdfReviewTool;

	public int getDesignerId() {
		return designerId;
	}

	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPwdDate() {
		return pwdDate;
	}

	public void setPwdDate(String pwdDate) {
		this.pwdDate = pwdDate;
	}

	public int getSaralID() {
		return saralID;
	}

	public void setSaralID(int saralID) {
		this.saralID = saralID;
	}

	public int getDesignerLevelId() {
		return designerLevelId;
	}

	public void setDesignerLevelId(int designerLevelId) {
		this.designerLevelId = designerLevelId;
	}

	public int getJoinLocationId() {
		return joinLocationId;
	}

	public void setJoinLocationId(int joinLocationId) {
		this.joinLocationId = joinLocationId;
	}

	public int getWorkLocationId() {
		return workLocationId;
	}

	public void setWorkLocationId(int workLocationId) {
		this.workLocationId = workLocationId;
	}

	public int getIsOnlineAd() {
		return isOnlineAd;
	}

	public void setIsOnlineAd(int isOnlineAd) {
		this.isOnlineAd = isOnlineAd;
	}

	public int getDesignerRoleId() {
		return designerRoleId;
	}

	public void setDesignerRoleId(int designerRoleId) {
		this.designerRoleId = designerRoleId;
	}

	public String getEncryptedKey() {
		return encryptedKey;
	}

	public void setEncryptedKey(String encryptedKey) {
		this.encryptedKey = encryptedKey;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getShiftFactor() {
		return shiftFactor;
	}

	public void setShiftFactor(float shiftFactor) {
		this.shiftFactor = shiftFactor;
	}

	public int getShiftFactorStatus() {
		return shiftFactorStatus;
	}

	public void setShiftFactorStatus(int shiftFactorStatus) {
		this.shiftFactorStatus = shiftFactorStatus;
	}

	public int getIsNewD() {
		return isNewD;
	}

	public void setIsNewD(int isNewD) {
		this.isNewD = isNewD;
	}

	public String getPwdExpiryDate() {
		return pwdExpiryDate;
	}

	public void setPwdExpiryDate(String pwdExpiryDate) {
		this.pwdExpiryDate = pwdExpiryDate;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(String publicationId) {
		this.publicationId = publicationId;
	}

	public String getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(String categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getBusinessGroupId() {
		return businessGroupId;
	}

	public void setBusinessGroupId(int businessGroupId) {
		this.businessGroupId = businessGroupId;
	}

	public String getIsPdfReviewTool() {
		return isPdfReviewTool;
	}

	public void setIsPdfReviewTool(String isPdfReviewTool) {
		this.isPdfReviewTool = isPdfReviewTool;
	}

	@Override
	public String toString() {
		return "AdwitProductionStaff [designerId=" + designerId + ", name=" + name + ", gender=" + gender + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", username=" + username + ", password=" + password
				+ ", pwdDate=" + pwdDate + ", saralID=" + saralID + ", designerLevelId=" + designerLevelId
				+ ", joinLocationId=" + joinLocationId + ", workLocationId=" + workLocationId + ", isOnlineAd="
				+ isOnlineAd + ", designerRoleId=" + designerRoleId + ", encryptedKey=" + encryptedKey + ", image="
				+ image + ", shiftFactor=" + shiftFactor + ", shiftFactorStatus=" + shiftFactorStatus + ", isNewD="
				+ isNewD + ", pwdExpiryDate=" + pwdExpiryDate + ", createdOn=" + createdOn + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + ", publicationId=" + publicationId + ", categoryLevel=" + categoryLevel
				+ ", clubId=" + clubId + ", alias=" + alias + ", businessGroupId=" + businessGroupId
				+ ", isPdfReviewTool=" + isPdfReviewTool + "]";
	}

}
