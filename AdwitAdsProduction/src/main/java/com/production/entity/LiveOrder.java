package com.production.entity;

public class LiveOrder {
	private int liveOrderId;
	private int publicationId;
	private int orderId;
	private String jobNo;
	private String category;
	private int designerId;
	private int csrId;
	private int csrIdQA;
	private int orderStatusId;
	private int productionStatusId;
	private String orderStatusTitle;
	private String productionStatusTitle;
	private int clubId;
	private int question;
	private int isCrequest;
	private String timeStamp;
	private Orders orders;
	private TimeZone timeZone;
	private Publication publication;
	private Club club;

	public int getLiveOrderId() {
		return liveOrderId;
	}

	public void setLiveOrderId(int liveOrderId) {
		this.liveOrderId = liveOrderId;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDesignerId() {
		return designerId;
	}

	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}

	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	public int getCsrIdQA() {
		return csrIdQA;
	}

	public void setCsrIdQA(int csrIdQA) {
		this.csrIdQA = csrIdQA;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public int getProductionStatusId() {
		return productionStatusId;
	}

	public void setProductionStatusId(int productionStatusId) {
		this.productionStatusId = productionStatusId;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	

	public int getIsCrequest() {
		return isCrequest;
	}

	public void setIsCrequest(int isCreques) {
		this.isCrequest = isCreques;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "LiveOrder [liveOrderId=" + liveOrderId + ", publicationId=" + publicationId + ", orderId=" + orderId
				+ ", jobNo=" + jobNo + ", category=" + category + ", designerId=" + designerId + ", csrId=" + csrId
				+ ", csrIdQA=" + csrIdQA + ", orderStatusId=" + orderStatusId + ", productionStatusId="
				+ productionStatusId + ", clubId=" + clubId + ", question=" + question + ", isCrequest=" + isCrequest
				+ ", timeStamp=" + timeStamp + "]";
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public String getOrderStatusTitle() {
		return orderStatusTitle;
	}

	public void setOrderStatusTitle(String orderStatusTitle) {
		this.orderStatusTitle = orderStatusTitle;
	}

	public String getProductionStatusTitle() {
		return productionStatusTitle;
	}

	public void setProductionStatusTitle(String productionStatusTitle) {
		this.productionStatusTitle = productionStatusTitle;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	

}
