package com.production.entity;

public class ProductionConversation {
	private int productionConversationId;
	private int orderId;
	private int revSoldJobId;
	private int designerId;
	private int tlDesignerId;
	private int csrId;
	private String time;
	private String message;
	private String operation;
	private String filePath;

	public int getProductionConversationId() {
		return productionConversationId;
	}

	public void setProductionConversationId(int productionConversationId) {
		this.productionConversationId = productionConversationId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRevSoldJobId() {
		return revSoldJobId;
	}

	public void setRevSoldJobId(int revSoldJobId) {
		this.revSoldJobId = revSoldJobId;
	}

	public int getDesignerId() {
		return designerId;
	}

	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}

	public int getTlDesignerId() {
		return tlDesignerId;
	}

	public void setTlDesignerId(int tlDesignerId) {
		this.tlDesignerId = tlDesignerId;
	}

	
	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
