package com.production.entity;

public class OrderCancel {
	private int orderCancelId;
	private int orderId;
	private int csrId;
	private int adrepId;
	private String cReason;
	private String retainReason;
	private String rReason;
	private String cTimestamp;
	private String atimestamp;

	public int getOrderCancelId() {
		return orderCancelId;
	}

	public void setOrderCancelId(int orderCancelId) {
		this.orderCancelId = orderCancelId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCsrId() {
		return csrId;
	}

	public void setCsrId(int csrId) {
		this.csrId = csrId;
	}

	public int getAdrepId() {
		return adrepId;
	}

	public void setAdrepId(int adrepId) {
		this.adrepId = adrepId;
	}

	public String getcReason() {
		return cReason;
	}

	public void setcReason(String cReason) {
		this.cReason = cReason;
	}

	public String getRetainReason() {
		return retainReason;
	}

	public void setRetainReason(String retainReason) {
		this.retainReason = retainReason;
	}

	public String getrReason() {
		return rReason;
	}

	public void setrReason(String rReason) {
		this.rReason = rReason;
	}

	public String getcTimestamp() {
		return cTimestamp;
	}

	public void setcTimestamp(String cTimestamp) {
		this.cTimestamp = cTimestamp;
	}

	public String getAtimestamp() {
		return atimestamp;
	}

	public void setAtimestamp(String atimestamp) {
		this.atimestamp = atimestamp;
	}

}
