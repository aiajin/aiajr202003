package com.aia.op.guestbook.model;

public class MessageEditRequest {

	private int mid;
	private String uname;
	private String pw;
	private String message;

	public MessageEditRequest(int mid, String uname, String pw, String message) {
		this.mid = mid;
		this.uname = uname;
		this.pw = pw;
		this.message = message;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
