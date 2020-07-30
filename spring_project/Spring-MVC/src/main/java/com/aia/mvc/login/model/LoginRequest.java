package com.aia.mvc.login.model;

public class LoginRequest {

	private String uid;
	private String upw;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", upw=" + upw + "]";
	}

}
