package com.auction.model;

public class AjaxStatus {

	private int status;
	private int statusCode;
	private String message;
	
	public AjaxStatus(){
		this.status = 200;
		this.statusCode = 0;
		this.message = "";
	}
	public AjaxStatus(int status, int statusCode, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
