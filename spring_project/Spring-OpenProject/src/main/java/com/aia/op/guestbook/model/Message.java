package com.aia.op.guestbook.model;

import java.sql.Date;

public class Message {

	private int mid;
	private String uname;
	private String pw;
	private String message;
	private Date regdate;
	
	public Message() {}

	public Message(int mid, String uname, String pw, String message, Date regdate) {
		this.mid = mid;
		this.uname = uname;
		this.pw = pw;
		this.message = message;
		this.regdate = regdate;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public java.util.Date getRegDateTime(){
		return new java.util.Date(regdate.getTime());
	}

	@Override
	public String toString() {
		return "Message [mid=" + mid + ", uname=" + uname + ", pw=" + pw + ", message=" + message + ", regdate="
				+ regdate + "]";
	}
	
	

}
