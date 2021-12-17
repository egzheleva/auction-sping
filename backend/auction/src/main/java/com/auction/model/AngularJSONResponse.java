package com.auction.model;

public class AngularJSONResponse {

	private AjaxStatus status;
	private Object data;
	
	public AngularJSONResponse(Object data) {
		super();
		this.status = new AjaxStatus();
		this.data = data;
	}
	
	public AngularJSONResponse(AjaxStatus status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	public AjaxStatus getStatus() {
		return status;
	}
	public void setStatus(AjaxStatus status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}

