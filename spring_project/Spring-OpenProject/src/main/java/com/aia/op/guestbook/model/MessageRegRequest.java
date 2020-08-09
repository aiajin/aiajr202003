package com.aia.op.guestbook.model;

public class MessageRegRequest {

	private String uname;
	private String pw;
	private String message;

	public MessageRegRequest(String uname, String pw, String message) {
		this.uname = uname;
		this.pw = pw;
		this.message = message;
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
