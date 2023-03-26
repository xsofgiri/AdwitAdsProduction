package com.production.entity;

public class QuestionTemplate {
	private int questionTemplateId;
	private String name;
	private String message;
	public int getQuestionTemplateId() {
		return questionTemplateId;
	}
	public void setQuestionTemplateId(int questionTemplateId) {
		this.questionTemplateId = questionTemplateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "QuestionTemplate [questionTemplateId=" + questionTemplateId + ", name=" + name + ", message=" + message
				+ "]";
	}

}
