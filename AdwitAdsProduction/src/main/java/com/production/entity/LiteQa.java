package com.production.entity;

public class LiteQa {
	private int id;
	private int uId;
	private String question;
	private String answer;
	private String queTimestamp;
	private String ansTimestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public String getQueTimestamp() {
		return queTimestamp;
	}

	public void setQueTimestamp(String queTimestamp) {
		this.queTimestamp = queTimestamp;
	}

	public String getAnsTimestamp() {
		return ansTimestamp;
	}

	public void setAnsTimestamp(String ansTimestamp) {
		this.ansTimestamp = ansTimestamp;
	}

	@Override
	public String toString() {
		return "LiteQa [id=" + id + ", uId=" + uId + ", question=" + question + ", answer=" + answer + ", queTimestamp="
				+ queTimestamp + ", ansTimestamp=" + ansTimestamp + "]";
	}

}
