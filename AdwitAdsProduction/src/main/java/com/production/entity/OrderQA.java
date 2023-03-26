package com.production.entity;

public class OrderQA {
	private int orderQaId;
	private int orderId;
	private int revSoldJobId;
	private int csrId;
	private int acsrId;
	private int adrepId;
	private String question;
	private String answer;
	private String qTimestamp;
	private String aTimestamp;

	public int getOrderQaId() {
		return orderQaId;
	}

	public void setOrderQaId(int orderQaId) {
		this.orderQaId = orderQaId;
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

	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	public int getAcsrId() {
		return acsrId;
	}

	public void setAcsrId(int acsrId) {
		this.acsrId = acsrId;
	}

	public int getAdrepId() {
		return adrepId;
	}

	public void setAdrepId(int adrepId) {
		this.adrepId = adrepId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getqTimestamp() {
		return qTimestamp;
	}

	public void setqTimestamp(String qTimestamp) {
		this.qTimestamp = qTimestamp;
	}

	public String getaTimestamp() {
		return aTimestamp;
	}

	public void setaTimestamp(String aTimestamp) {
		this.aTimestamp = aTimestamp;
	}

	@Override
	public String toString() {
		return "OrderQA [orderQaId=" + orderQaId + ", orderId=" + orderId + ", revSoldJobId=" + revSoldJobId
				+ ", csrId=" + csrId + ", acsrId=" + acsrId + ", adrepId=" + adrepId + ", question=" + question
				+ ", answer=" + answer + ", qTimestamp=" + qTimestamp + ", aTimestamp=" + aTimestamp + "]";
	}

}
